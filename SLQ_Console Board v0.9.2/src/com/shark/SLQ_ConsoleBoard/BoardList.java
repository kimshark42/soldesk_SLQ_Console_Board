package com.shark.SLQ_ConsoleBoard;

import java.sql.SQLException;

import com.shark.SLQ_ConsoleBoard.Display.Display;
import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;
import com.shark.SLQ_ConsoleBoard.utill.Db;

public class BoardList {
	static public final int FOR_PAGE = 3;
	
	static public void run() {
		int startIndex = 0;  // 현재 페이지의 첫 글 인덱스
		int currentPage = 1;  // 현재 페이지
		
		String cmd;
		while(true) {
			cmd = Cj.r("페이지 번호 입력[이전 메뉴로:x]:");
			if(cmd.equals("x")) {
				break;
			}
			currentPage = Integer.parseInt(cmd);
			
			startIndex = (currentPage - 1) * FOR_PAGE;  // 페이지의 첫 인덱스를 계산해서 저장
			Display.titleList();
			String sql = "select * from board limit "+startIndex+","+FOR_PAGE;
			try {
				Cw.wn("전송할sql문:"+sql);
				Db.result = Db.st.executeQuery(sql);
				while(Db.result.next()) {
					String no = Db.result.getString("b_no");
					String title = Db.result.getString("b_title");
					String id = Db.result.getString("b_id");
					String datetime = Db.result.getString("b_datetime");
					Color.rgb(148, 40, 255, "No."+no+" 제목:"+title+" ID:"+id+" "+datetime);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
