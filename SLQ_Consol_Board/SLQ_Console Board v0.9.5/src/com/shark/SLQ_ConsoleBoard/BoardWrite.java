package com.shark.SLQ_ConsoleBoard;

import java.sql.SQLException;

import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;
import com.shark.SLQ_ConsoleBoard.utill.Db;

public class BoardWrite {
	public static void run() {
		String title = Cj.bcr(Color.BG_BLUE, "제목을 입력해주세요:");
		String content = Cj.bcr(Color.BG_BLUE, "글 내용을 입력해주세요:");
		String id = Cj.bcr(Color.BG_BLUE, "작성자의 ID를 입력해주세요:");
		try {
			Db.st.executeUpdate
			("insert into board (b_title,b_id,b_datetime,b_text,b_hit"
		          + " values ('"+ title +"','"+id+"',now(),'"+content+"',0)");
			Cw.wn("글이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
