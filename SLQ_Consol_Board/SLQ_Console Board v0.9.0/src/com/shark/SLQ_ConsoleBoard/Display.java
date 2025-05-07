package com.shark.SLQ_ConsoleBoard;

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
		Color.sum(Color.BG_BLACK,"[1.글 목록/2.글 읽기/3.글 쓰기/4.글 삭제/x.프로그램 종료");
	}	
}
