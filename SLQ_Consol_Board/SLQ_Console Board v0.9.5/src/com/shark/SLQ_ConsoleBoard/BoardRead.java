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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
