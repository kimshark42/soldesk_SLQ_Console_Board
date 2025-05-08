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
			Db.result.next();
			String title = Db.result.getString("b_title");
			String content = Db.result.getString("b_text");
			Color.rgb(148, 40, 255, "글 제목: "+title);
			Color.rgb(148, 40, 255, "글 내용: "+content);
			
			BoardReply.list(Integer.parseInt(readNo));
			loop:
			while(true) {
				String cmd = Cj.cr(148, 40, 255, "[x.나가기,r:댓글쓰기]:");
				switch(cmd) {
				case "x":
					break loop;
				case "r":
					BoardReply.write(Integer.parseInt(readNo));
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
