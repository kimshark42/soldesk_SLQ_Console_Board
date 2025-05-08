package com.shark.SLQ_ConsoleBoard;

import java.sql.SQLException;

import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Db;

public class BoardRead {
	public static void run() {
		String readNo = Cj.cr(148, 40, 255, "읽으실 글 번호를 입력해주세요:");
		try {
			Db.result = Db.st.executeQuery("select * from board where b_no ="+readNo);
			
			Db.result.next();  // 결과를 하나씩 빼기, 더 이상 없으면(행 수가 끝나면) false 리턴됨.
			String title = Db.result.getString("b_title");  // p_name 필드(열)의 데이터 꺼내기
			String content = Db.result.getString("b_text");  // p_name 필드(열)의 데이터 꺼내기
			Color.rgb(148, 40, 255, "글 제목: "+title);
			Color.rgb(148, 40, 255, "글 내용: "+content);
			
			BoardReply.list(Integer.parseInt(readNo));  // 댓글 리스트 출력처리
			loop:
			while(true) {
				String cmd = Cj.cr(148, 40, 255, "[x.나가기,r:댓글쓰기]:");
				switch(cmd) {
				case "x":
					break loop;
				case "r":
					BoardReply.write(Integer.parseInt(readNo));
					// Integer.parseInt(readNo) -> 문자열 String을 정수 int로 변환해서 숫자 인자로 사용
					break;
				default:
					Color.sum(Color.BG_BLACK, "그딴거없따🦈");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
