package com.shark.SLQ_ConsoleBoard;

import java.sql.SQLException;

import com.shark.SLQ_ConsoleBoard.Display.Display;
import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;
import com.shark.SLQ_ConsoleBoard.utill.Db;

public class Board {
	
	void run() {
		Display.title();
		Db.dbInit();
		Color.sum(Color.BG_BRTGHT_BLACK, "전체 글 수:"+Db.getPostCount());
		
		loop:
		while(true) {
			Db.dbPostCount();
			Color.sum(Color.BG_BLACK, "[1.글 목록📑/2.글 읽기📃/3.글 쓰기📝/4.글 삭제🗑️/x.프로그램 종료❌]:");
			String cmd = Cj.r("명령입력: ");
			switch(cmd){
				case"1":
					BoardList.run();
					break;
				case "2":
					BoardRead.run();
					break;
				case "3":
					BoardWrite.run();
					break;
				case "4":
					BoardDelet.run();
					break;
				case "5":
					BoardEdit.run();
					break;
				case "0":
					break;
				case "x":
					Color.sum(Color.BG_BRTGHT_BLACK, "프로그램을 종료합니다.");
					break loop;
			}
		}
	}
}	