package com.shark.SLQ_ConsoleBoard.site;

import com.shark.SLQ_ConsoleBoard.Display.DisplaySite;
import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;

public class SiteMain {
	static private String cmd = "";
	
	public static void run() {
		loop:
		while(true) {
			DisplaySite.title();
			cmd = Cj.bcr(Color.BG_BLACK, "[r.회원가입🪪/i.로그인🔗/b.게시판(임시입구)📑/x.프로그램 종료❌]:");
			switch(cmd) {
			case "r": // 회원가입‍🪪
				break;
				// 로그아웃 ⛓️‍💥
			case "i":  // i.로그인🔗
				break;
			case "a":  // b.게시판(임시입구)📑
				break;
			case "x":  // x.프로그램 종료❌
				Color.sum(Color.BG_BRTGHT_BLACK, "[❌프로그램을 종료합니다.]");
				break loop;
			case "b":
				break;
			default:
				Color.sum(Color.BG_BLACK, "그딴거 없다🦈");
			}
		}
	}
}
