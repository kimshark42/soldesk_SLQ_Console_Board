package com.shark.SLQ_ConsoleBoard;

import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Db;

public class BoardDelet {
	
	static public void run() {
		String delNo = Cj.bcr(Color.BG_BRTGHT_BLACK, "🗑️삭제할 글 번호를 입력해주세요:");
		Db.dbExecuteUpdate("delete from board where b_no="+delNo);
	}
}
