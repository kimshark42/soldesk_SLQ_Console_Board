package com.shark.SLQ_ConsoleBoard.Display;

import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;
import com.shark.SLQ_ConsoleBoard.utill.Line;

public class Display {
	
	// 타이틀 바 관련
	public static String VRESION = "v.0.9.8";
	public static String TITLE = "따이한 수족관 갤러리";
	public static String MADEBY = "by. kim_shark";
	
	public static void title() {
		Color.sum(Color.BG_BRTGHT_BLUE, Line.fishLine(20));
		Cw.wn();
		Color.sum(Color.BG_BLUE, Line.sharkLine(9));
		Cw.space(2);
		Color.sum(Color.BG_BLUE, TITLE + " [" + VRESION + MADEBY + "]");
		Cw.space(2);
		Color.sum(Color.BG_BLUE, Line.sharkLine(9));
		Cw.wn();
		Color.sum(Color.BG_BRTGHT_BLUE, Line.fishLine(20));
		Cw.wn();
		Cw.wn();
	}
	
	static public void mainManu(){
		Color.sum(Color.BG_BRTGHT_BLACK, Line.whileLine(20));
		Cw.wn();
		Color.sum(Color.BG_BLACK
		,"[1.글 목록📑/2.글 읽기📃/3.글 쓰기📝/4.글 삭제🗑️/5.글 수정🛠️/6.글 목록-검색🔍/x.프로그램 종료❌]:");
		Cw.wn();
		Color.sum(Color.BG_BRTGHT_BLACK, Line.whileLine(20));
		Cw.wn();
		Cw.wn();
	}
	
	static public void writeList() {
		Color.sum(Color.BG_BRTGHT_BLUE, Line.sharkLine(20));
		Cw.wn();
		Color.sum(Color.BG_BLUE, Line.whileLine(9));
		Cw.space(1); Color.sum(Color.BG_BLUE, "글 목록"); Cw.space(1);
		Color.sum(Color.BG_BLUE, Line.whileLine(9));
		Cw.wn();
		Color.sum(Color.BG_BRTGHT_BLUE, Line.sharkLine(20));
		Cw.wn();
		Cw.wn("글번호 글제목 작성자ID 작성시간");
		Cw.wn();
	}
	
	static public void replyBar() {
		Color.sum(Color.BG_BLUE, Line.whileLine(9));
		Cw.space(1); Color.sum(Color.BG_BLUE, "댓글"); Cw.space(1);
		Color.sum(Color.BG_BLUE, Line.whileLine(9));
	}
}
