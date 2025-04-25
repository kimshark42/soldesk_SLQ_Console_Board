package com.shark.SLQ_ConsoleBoard;

import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;

public class Display {
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
		}
	}
	
	public static void Title() {
		line();
		dot(25);
		Color.sum(Color.BG_BLUE, "🦈🦈🦈🦈🦈");
		Color.sum(Color.BG_BLUE,"따이한 수족관 갤러리 (v."+Board.VRESION+" by kim.shark");
		Color.sum(Color.BG_BLUE, "🦈🦈🦈🦈🦈");
		Cw.wn();
		line();
	}
}
