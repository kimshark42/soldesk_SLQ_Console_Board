package com.shark.SLQ_ConsoleBoard;

import java.sql.SQLException;

import com.shark.SLQ_ConsoleBoard.Display.Display;
import com.shark.SLQ_ConsoleBoard.utill.Cj;
import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;
import com.shark.SLQ_ConsoleBoard.utill.Db;

public class BoardList {
	
	static public final int FOR_PAGE = 3;
	static int startIndex = 0;    // 현재 페이지의 첫 글 인덱스
	static int currentPage = 1;   // 현재 페이지
	static boolean isSearchMode = false;  // 현재 리스트가 검색모드인지 읽기 모드인지 구분하는 값
	static int totalPage = 0;
	static int count = 0;
	static String cmd = "";
	
	static public void run() {
		
//		전체 페이지 수를 구하기
		count = Db.getPostCount();
		if(Db.getPostCount() % FOR_PAGE > 0) {
			totalPage = Db.getPostCount() / FOR_PAGE + 1;
		} else {			
			totalPage = Db.getPostCount() / FOR_PAGE;
		}
		Color.sum(Color.BG_BRTGHT_BLACK, "총 페이지 수:"+totalPage);

		while(true) {
			cmd = Cj.cr(148,40,255,"페이지 번호 입력[이전 메뉴로:x]:");
			if(cmd.equals("x")) {
				break;
			}
			currentPage = Integer.parseInt(cmd);
			if(currentPage > totalPage || currentPage < 1) {
				Cw.wn("페이지 범위에 맞는 값을 넣어주세요.");
				continue;
			}
			
			startIndex = (currentPage - 1) * FOR_PAGE;  // 페이지의 첫 인덱스를 계산해서 저장
			Display.titleList();
			String sql = "select * from board where b_reply_ori is null limit "+startIndex+","+FOR_PAGE;
			try {
				Cw.wn("전송할sql문:"+sql);
				Db.result = Db.st.executeQuery(sql);
				while(Db.result.next()) {
					String no = Db.result.getString("b_no");
					String title = Db.result.getString("b_title");
					String id = Db.result.getString("b_id");
					String datetime = Db.result.getString("b_datetime");
					Color.rgb(148, 40, 255, "No."+no+" 제목:"+title+" ID:"+id+" "+datetime);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
//	검색어를 입력받아 리스트 검색 처리
	static public void seaech() {
		cmd = Cj.bcr(Color.BG_BRTGHT_BLACK, "검색어[x.나가기]:");
		if(cmd.equals("x")) {
			return;
		} else {
			searchList(cmd);
		}
	}
//	리스트 검색 처리
	static public void searchList(String searchWord) {
//		전체 페이지수를 구하기
		count = Db.getPostCountSearch(searchWord);
		if(count % FOR_PAGE > 0) {
			totalPage = count /FOR_PAGE + 1;
		} else {
			totalPage = count /FOR_PAGE;
			
		}
		Cw.wn("총 페이지 수<검색모드🔍>:"+totalPage);
		while(true) {
			cmd = Cj.bcr(Color.BRIGHT_BLACK, "페이지 번호 입력<검색모드🔍>[x.이전 메뉴로]:");
			if(cmd.equals("x")) {
				break;
			}
			currentPage = Integer.parseInt(cmd);
			if(currentPage > totalPage || currentPage < 1) {
				Cw.wn("존재하지 않는 페이지입니다.");
				continue;
			}
			startIndex = (currentPage - 1) * FOR_PAGE;  // 페이지의 첫 인덱스를 계산해서 저장
			Display.titleList();
			String sql = "select * from board where b_reply_ori is null"
					+ " and b_title like '%" + searchWord + "%'"
					+ " limit "+startIndex+","+FOR_PAGE;
			try {
				Cw.wn("전송한 sql문:"+sql);
				Db.result = Db.st.executeQuery(sql);
				while(Db.result.next()) {
					String no = Db.result.getString("b_no");
					String title = Db.result.getString("b_title");
					String id = Db.result.getString("b_id");
					String datetime = Db.result.getString("b_datetime");
					Cw.wn("No."+no+" 제목:"+title+" ID:"+id+" "+datetime);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
