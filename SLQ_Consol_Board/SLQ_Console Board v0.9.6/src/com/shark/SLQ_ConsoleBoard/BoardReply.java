package com.shark.SLQ_ConsoleBoard;

import java.sql.SQLException;

import com.shark.SLQ_ConsoleBoard.Display.Display;
import com.shark.SLQ_ConsoleBoard.utill.Cw;
import com.shark.SLQ_ConsoleBoard.utill.Db;

public class BoardReply {
	static public void list(int oriNo) {
		Display.replyBar();
		String sql = "select * from board where b_reply_ori="+oriNo;
		try {
			Cw.wn("전송한 sql문:"+sql);
			Db.result = Db.st.executeQuery(sql);
			while(Db.result.next()) {
				String b_reply_text = Db.result.getString("b_reply_text");
				Cw.wn(b_reply_text);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
