package com.shark.SLQ_ConsoleBoard;

import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Db;

public class BoardEdit {
	public static void run() {
		String editNo = Cj.r("수정할 글 번호를 입력해주세요:");
		String edTitle = Cj.r("제목을 입력해주세요:");
		String edId = Cj.r("작성자ID를 입력해주세요:");
		String edContent = Cj.r("수정할 글내용을 입력해주세요:");
		Db.dbExecuteUpdate("update board set b_title='"
		+edTitle+"',b_id='"+edId+"'b_datetime=now(),b_text='"+edContent
		+"' where b_no="+editNo);
	}
}
