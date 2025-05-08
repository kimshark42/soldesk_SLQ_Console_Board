package com.shark.SLQ_ConsoleBoard;

import java.sql.SQLException;

import com.shark.SLQ_ConsoleBoard.Display.Display;
import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;
import com.shark.SLQ_ConsoleBoard.utill.Db;

public class Board {
	
	public static String VRESION = "0.9.4";
	
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
					String readNo = Cj.cr(148, 40, 255, "읽으실 글 번호를 입력해주세요:");
					try {
						Db.result = Db.st.executeQuery("select * from board where b_no ="+readNo);
						Db.result.next();
						String title = Db.result.getString("b_title");
						String content = Db.result.getString("b_text");
						Color.rgb(148, 40, 255, "글 제목: "+title);
						Color.rgb(148, 40, 255, "글 내용: "+content);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "3":
					String title = Cj.bcr(Color.BG_BLUE, "제목을 입력해주세요:");
					String content = Cj.bcr(Color.BG_BLUE, "글 내용을 입력해주세요:");
					String id = Cj.bcr(Color.BG_BLUE, "작성자의 ID를 입력해주세요:");
					try {
						Db.st.executeUpdate
						("insert into board (b_title,b_id,b_datetime,b_text,b_hit"
					          + " values ('"+ title +"','"+id+"',now(),'"+content+"',0)");
						Cw.wn("글이 등록되었습니다.");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case "4":
					String delNo = Cj.r("🗑️삭제할 글 번호를 입력해주세요:");
					Db.dbExecuteUpdate("delete from board where b_no="+delNo);
					break;
				case "5":
					String editNo = Cj.r("수정할 글 번호를 입력해주세요:");
					String edTitle = Cj.r("제목을 입력해주세요:");
					String edId = Cj.r("작성자ID를 입력해주세요:");
					String edContent = Cj.r("수정할 글내용을 입력해주세요:");
					Db.dbExecuteUpdate("update board set b_title='"+edTitle+"',b_id='"+edId+"'b_datetime=now(),b_text='"+edContent+"' where b_no="+editNo);
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