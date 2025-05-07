package com.shark.SLQ_ConsoleBoard.Display;

import com.shark.SLQ_ConsoleBoard.Board;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;

public class Display {
	
	public static void title() {
		Cw.dot(20);
		Cw.wn();
		Cw.dot2(9);
		Color.sum(Color.BG_BLUE, "따이한 수족관 갤러리(v." + Board.VRESION + ") by. kim_shark");
		Cw.dot2(9);
		Cw.wn();
		Cw.dot(20);
		Cw.wn();
		Cw.wn();
	}
	
	static public void titleList() {
		Cw.wn("==========================================");
		Cw.wn("================= 글리스트 ==================");
		Cw.wn("==========================================");
		Cw.wn("글번호 글제목 작성자id 작성시간");
	}

}
