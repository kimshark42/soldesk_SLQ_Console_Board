package com.shark.SLQ_ConsoleBoard.site;

import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Db;
import com.shark.SLQ_ConsoleBoard.utill.Line;

public class MemberRegister {
	
	// 회원가입 처리
	// 일단은 id와 pw 만 회원정보로 입력하게 처리
	private static String cmd = "";
	public static void run() {
		Color.sum(Color.BG_BRTGHT_BLUE, Line.sharkLine(9) + " 회원가입 " + Line.sharkLine(9));
		String id = "";
		String pw = "";
		while(true) {
			id = Cj.bcr(Color.BG_BLUE, "ID");
			if(id.length()>0) {
				break;
			} else {
				Color.sum(Color.BG_BLACK, "그딴거 없따🦈");
			}
		}
		while(true) {
			pw = Cj.bcr(Color.BG_BRTGHT_BLACK, "Password");
			if(pw.length()>0) {
				break;
			} else {
				Color.sum(Color.BG_BLACK, "그딴거 없따🦈");
			}
		}
		// id/pw 를 디비에 저장, ex) insert into member values('qwer','1234');
		Db.dbExecuteUpdate("insert into member values('"+id+"','"+pw+"')");
		Color.sum(Color.BG_BRTGHT_BLACK, "[회원가입이 완료되었습니다.]");
	}
}
