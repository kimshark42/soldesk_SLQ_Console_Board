package com.shark.SLQ_ConsoleBoard;

import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;

public class Display {
	
	public static String MAIN_MANU = "[1.글 목록/2.글 읽기/3.글 쓰기/4.글 삭제/x.프로그램 종료]: ";
	
	final static String DOT = "🐟🦐";
	final static int DOT_COUNT = 47;
	
	public static void line() {
		for(int i=0;i<DOT_COUNT;i++) {
			Color.sum(Color.BG_BRTGHT_BLUE, DOT);
		}
		Cw.wn();
	}
	public static void dot(int n) {
		for(int i=0;i<n;i++) {
			Color.sum(Color.BG_BRTGHT_BLUE, DOT);
		}
		Cw.wn();
	}
	
	
	
	public static void Title() {
		dot(20);
		Color.sum(Color.BG_BLUE, "🦈🦈🦈🦈🦈🦈🦈🦈🦈");
		Color.sum(Color.BG_BLUE," 따이한 수족관 갤러리 (v."+Board.VRESION+" by kim.shark)");
		Color.sum(Color.BG_BLUE, "🦈🦈🦈🦈🦈🦈🦈🦈🦈");
		Cw.wn();
		dot(20);
		Color.sum(Color.BG_BLACK, MAIN_MANU);
		Cw.wn();
	}
	
}
