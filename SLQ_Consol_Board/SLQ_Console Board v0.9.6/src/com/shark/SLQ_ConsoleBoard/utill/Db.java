package com.shark.SLQ_ConsoleBoard.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	static public Connection con = null;
	static public Statement st = null;
	static public ResultSet result = null;

	static public void dbInit() {
		try {
			Db.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			Db.st = Db.con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static public void dbExecuteUpdate(String query) {
		try {
			int resultCount = st.executeUpdate(query);
			Cw.wn("처리된 행 수:" + resultCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static public void dbPostCount() {
		try {
			Db.result = Db.st.executeQuery("select count(*) from board");
			Db.result.next();
			String count = Db.result.getString("count(*)");
			Cw.wn("글 수:" + count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static public int getPostCount() {
		String count = "";
		try {
			Db.result = Db.st.executeQuery("select count(*) from board");
			Db.result.next();
			count = Db.result.getString("count(*)");
			Cw.wn("글 수:"+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int intCount = Integer.parseInt(count);
		return intCount;
	}
}
