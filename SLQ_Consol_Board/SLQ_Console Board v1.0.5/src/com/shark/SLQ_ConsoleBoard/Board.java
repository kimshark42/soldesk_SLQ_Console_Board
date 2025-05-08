package com.shark.SLQ_ConsoleBoard;

import java.sql.SQLException;

import com.shark.SLQ_ConsoleBoard.Display.DisplayBoard;
import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;
import com.shark.SLQ_ConsoleBoard.utill.Db;

public class Board {
	
	public static void run() {
		DisplayBoard.title();
		Db.dbInit();
		Color.sum(Color.BG_BRTGHT_BLACK, "전체 글 수:"+Db.getPostCount());
		
		loop:
		while(true) {
			Color.sum(Color.BG_BRTGHT_BLACK, "전체 글 수:"+Db.getPostCount());
			DisplayBoard.mainManu();
			String cmd = Cj.r("명령입력:");
			switch(cmd){
				case"1":  //  1.글 목록📑
					BoardList.run();
					break;
				case "2":  //  2.글 읽기📃
					BoardRead.run();
					break;
				case "3":  //  3.글 쓰기📝
					BoardWrite.run();
					break;
				case "4":  //  4.글 삭제🗑️
					BoardDelet.run();
					break;
				case "5":  //  5.글 수정🛠️
					BoardEdit.run();
					break;
				case "6":  // 6.글 목록-검색
					 BoardList.seaech();
					 break;
				case "0":  // 관리자 모드
					break;
				case "x":  // 프로그램 종료
					Color.sum(Color.BG_BRTGHT_BLACK, "프로그램을 종료합니다.");
					break loop;
			}
		}
	}
}	