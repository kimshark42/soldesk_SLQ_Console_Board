package com.shark.SLQ_ConsoleBoard.site;

import com.shark.SLQ_ConsoleBoard.Board;
import com.shark.SLQ_ConsoleBoard.Display.DisplaySite;
import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;

public class SiteMain {
	static private String cmd = "";
	public static String loginedld = null;
	
	public static void run() {
		loop:
		while(true) {
			DisplaySite.Stitle();
			if(loginedld==null) {
				cmd = Cj.bcr(Color.BG_BLACK, "[j.회원가입🪪/i.로그인🔗/b.게시판(임시입구)📑/x.프로그램 종료❌]:");
			} else {
				Color.rgb(131, 1, 253, "OO님 환영합니다");
				cmd = Cj.bcr(Color.BG_BLACK, "[j.회원가입🪪/i.로그아웃 ⛓️‍💥/b.게시판(임시입구)📑/x.프로그램 종료❌]:");
			}
			switch(cmd) {
			case "j": // 회원가입‍🪪
				MemberRegister.run();
				break;
				// 로그아웃 ⛓️‍💥
			case "i":  // i.로그인🔗
				if(loginedld==null) {
					loginedld = MemberLogin.run();
				} else {
					Color.sum(Color.BG_BLACK, "[로그아웃 되었습니다]");
					loginedld = null;
				}
				break;
			case "a": // 관리자 
				break;
			case "x":  // x.프로그램 종료❌
				Color.sum(Color.BG_BRTGHT_BLACK, "[❌프로그램을 종료합니다.]");
				break loop;
			case "b":  // b.게시판(임시입구)📑
				Board.run();
				break;
			default:
				Color.sum(Color.BG_BLACK, "그딴거 없다🦈");
			}
		}
	}
}
