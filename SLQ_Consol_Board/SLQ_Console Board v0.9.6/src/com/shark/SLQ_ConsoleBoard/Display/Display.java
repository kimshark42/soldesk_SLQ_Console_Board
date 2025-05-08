package com.shark.SLQ_ConsoleBoard.Display;

import com.shark.SLQ_ConsoleBoard.Board;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;

public class Display {
	
	public static void title() {
		Color.sum(Color.BG_BRTGHT_BLUE, Cw.fishLine(20));
		Cw.wn();
		Color.sum(Color.BG_BLUE, Cw.sharkLine(9));
		Color.sum(Color.BG_BLUE, "따이한 수족관 갤러리(v." + Board.VRESION + ") by. kim_shark");
		Color.sum(Color.BG_BLUE, Cw.sharkLine(9));
		Cw.wn();
		Color.sum(Color.BG_BRTGHT_BLUE, Cw.fishLine(20));
		Cw.wn();
		Cw.wn();
	}
	
	static public void titleList() {
		Color.sum(Color.BG_BRTGHT_BLUE, Cw.sharkLine(20));
		Cw.wn();
		Color.sum(Color.BG_BLUE, "🐳🐳🐳🐳🐳🐳🐳🐳🐳 글 목록 🐳🐳🐳🐳🐳🐳🐳🐳🐳");
		Cw.wn();
		Color.sum(Color.BG_BRTGHT_BLUE, Cw.sharkLine(20));
		Cw.wn();
		Cw.wn("글번호 글제목 작성자ID 작성시간");
		Cw.wn();
	}
	
	static public void replyBar() {
		Color.sum(Color.BG_BLUE, "🐳🐳🐳🐳🐳🐳🐳🐳🐳 댓글 목록 🐳🐳🐳🐳🐳🐳🐳🐳🐳");		
	}
}
