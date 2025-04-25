package com.shark.SLQ_ConsoleBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.shark.SLQ_ConsoleBoard.utill.Color;
import com.shark.SLQ_ConsoleBoard.utill.Cw;

public class Board {
	public static String VRESION = "0.8.0";
	
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	
	Scanner sc = new Scanner(System.in);

	void run() {		
		Display.Title();
		
		dblnit();
		
		loop:
		while(true) {
			Color.sum(Color.BG_BLACK,"메뉴를 선택해주세요");
			String cmd = sc.next();
			switch(cmd) {
			case"1":
				Color.sum(Color.BG_BLUE,"글 목록");
				Color.sum(Color.BG_BLUE,"글 번호, 글 제목, 작성자 ID, 작성시간");
				try {
					result = st.executeQuery("select*from board");
					while(result.next()) {
						String no = result.getString("b_no");
						String title = result.getString("b_title");
						String id = result.getString("b_id");
						String datetime = result.getString("b_datetime");
						Color.sum(Color.BG_BLUE, "No."+ no + " " + title + " " + id + " " + datetime);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case"2":
				Color.sum(Color.BG_BRTGHT_BLUE, "읽을 글 번호를 입력해 주세요: ");
				String readNo = sc.next();
				
				String sql2 = "delete from board where b_no="+readNo;
				System.out.println("sqㅣ로그:"+sql2);
				dbExecuteUpdate(sql2);
				try {
					result = st.executeQuery(sql2);
					result.next();  // 결과를 하나씩 빼기, 더이상 없으면(행 수가 끝나면)false 리턴됨 (선반에 있는 데이터를 꺼내다 주는 행위)
					String title = result.getString("b_title");  // p_name 필드(열)의 데이터 꺼내기(-위에서 꺼낸거에서)
					String content = result.getString("b_text");  // p_name 필드(열)의 데이터 꺼내기(위에서 꺼낸거에서)
					
					Color.sum(Color.BRIGHT_BLUE, "글 제목:"+title);
					Cw.wn();
					Color.sum(Color.BRIGHT_BLUE, "글 내용:"+content);
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case"3":
				Color.rgb(176, 111, 240, "글 제목을 입력해 주세요: ");
				String title = sc.next();
				Color.rgb(176, 111, 240, "글 내용을 입력해주세요: ");
				String content = sc.next();
				Color.rgb(176, 111, 240, "작성자 ID를 입력해주세요: ");
				String id = sc.next();
//		        Color.rgb(93, 14, 172, "글 등록이 완료되었습니다.");
//		        String end = sc.next();
				
				String x = String.format("insert into board (b_title,b_id,b_datetime,b_text,b_hit)" + "values ('%s','%s',now(),'%s',0);" ,title,id,content);
				dbExecuteUpdate(x);
				System.out.println("SQL로그:"+x);  // <- 로그는 꼭 찍는것을 추천 나중에 어디서 걸렸는지 알기 쉬움
				break;
			case"4":
				Color.sum(Color.BG_BLACK, "삭제할 글 번호를 입력해주세요: ");
				String delNo = sc.next();
				
				String sql = "delete from board where b_no="+delNo;
				System.out.println("sqㅣ로그:"+sql);
				
				dbExecuteUpdate(sql);
				break;
			case"5":
				Color.sum(Color.BRIGHT_GREEN, "수정할 글 번호를 입력해주세요: ");
				String editNo = sc.next();
				
				Color.rgb(176, 111, 240, "수정할 글 제목을 입력해 주세요: ");
				String edtitle = sc.next();
				Color.rgb(176, 111, 240, "수정할 작성자 ID를 입력해주세요: ");
				String edid = sc.next();
				Color.rgb(176, 111, 240, "수정힐 글 내용을 입력해주세요: ");
				String edcontent = sc.next();
//		        Color.rgb(93, 14, 172, "글 수정이 완료되었습니다.");
//		        String edend = sc.next();
				
				String sql3 = String.format(
						"update board set b_title='%s',b_id='%s',b_datetime=now(),b_text='%s',where"
						
						,edtitle
						,edid
						,edcontent
						,editNo
						);
				System.out.println("sql로그:"+ sql3);
				dbExecuteUpdate(sql3);
				break;
			case"0":
				System.out.println("관리자 모드");
				break;
			case"x":
				Color.sum(Color.BG_BRTGHT_BLACK, "프로그램을 종료합니다.");
				break loop;
			}
		}		
	}

	private void dblnit() {
		try {
			// (1/n) 디비 접속 정보 넣어서 접속하기.
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			// (2/n) Statement 객체 얻어오기.
			st = con.createStatement(); // Statement는 정적 SQL문을 실행하고 그 결과를 반환받기 위한 객체이다.
										// Statement 하나당 한개의 ResultSet 객체만을
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void dbExecuteUpdate(String query) {
		try {
			// (3/n) Statement 객체의 excuteUpdate 함수에 SQL문을 실어서 DB에서 실행되게 하기
			int resultConunt = st.executeUpdate(query); // 이걸 하는 순간 DB에 있는 SQL(세로 라인, 쿼리<query>)가 날아감. (DB에도 반영됨)
			System.out.println("처리된 행 수: " + resultConunt); // 날아간 query를 로그로 찍어줌
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**************************************************************************
	쉬운 버젼에서 바뀐것
	private void dbExecuteUpdate(){
	   try{
	      // (3/n) Statement 객체의 excuteUpdate 함수에 SQL문을 실어서 DB에서 실행되게 하기
	      int resultConunt = st.executeUpdate(query); // 이걸 하는 순간 DB에 있는 SQL(세로 라인, 쿼리<query>)가 날아감. (DB에도 반영됨)
	      int resultConubt = st.executeUpdate("insert into board (b_title,b_id,b_datetime,b_text,b_hit) values ('콘솔 프로그램에서 쓴 글 입니다','shark',now(),'콘솔 프로그램에서 작성한 글입니따이. 전혀.....따이뾰이하지 않소....',0)");
	      System.out.println("처리된 행 수: " + resultConunt); // 날아간 query를 로그로 찍어줌
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
	***************************************************************************/
}