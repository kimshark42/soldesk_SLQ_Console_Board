package com.shark.SLQ_ConsoleBoard;

import java.sql.SQLException;

import com.shark.SLQ_ConsoleBoard.Display.DisplayBoard;
import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;
import com.shark.SLQ_ConsoleBoard.utill.Db;

public class BoardReply {
	
	static public void list(int oriNo) {  // 댓글 리스트 출력
		DisplayBoard.replyBar();
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
	static public void write(int b_reply_ori) {  // 댓글 작성 함수
		String b_replay_text = Cj.bcr(Color.BG_BRTGHT_BLUE,"댓글입력📝");
		Db.dbExecuteUpdate(
		"insert into board (b_id,b_datetime,b_reply_ori,b_reply_text) values('ㅇㅇ',now(),"+
		b_reply_ori+","+b_replay_text+"')");
	}
}
