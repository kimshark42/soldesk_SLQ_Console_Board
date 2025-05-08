package com.shark.SLQ_ConsoleBoard.Display;

import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;
import com.shark.SLQ_ConsoleBoard.utill.Line;

public class DisplaySite {
	private static String SITE_NAME = "🐟🦐🦈🐳 따이한 수족관 갤러리 🐟🦐🦈🐳";
	private static String VERSION = "v1.0.3";
	private static String MADE_BY = "by.kim_shark";
	
	public static void Stitle() {
		Color.sum(Color.BG_BRTGHT_BLUE, Line.fishLine(20));
		Cw.wn();
		Cw.space(9);
		Color.sum(Color.BG_BLUE, SITE_NAME + "[" + VERSION + MADE_BY + "]");
		Cw.space(9);
		Cw.wn();
		Color.sum(Color.BG_BRTGHT_BLUE, Line.fishLine(20));
		Cw.wn();
		Cw.wn();
	}
}
