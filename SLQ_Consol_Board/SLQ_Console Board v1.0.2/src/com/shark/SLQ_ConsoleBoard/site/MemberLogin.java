package com.shark.SLQ_ConsoleBoard.site;

import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Db;
import com.shark.SLQ_ConsoleBoard.utill.Line;

public class MemberLogin {
	// 로그인 처리
	private static String cmd = "";
	
	public static String run() {
		Color.sum(Color.BG_BRTGHT_BLUE, Line.sharkLine(9) + " 로그인 " + Line.sharkLine(9));
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
		if(Db.isSiteLogin(id,pw)) {
			// 로그인 처리
			return id;
		} else {
			// 로그인 실패 처리
			Color.sum(Color.BG_BLACK, "로그인에 실패하였습니다😢.");
			return null;
		}
	}
}
