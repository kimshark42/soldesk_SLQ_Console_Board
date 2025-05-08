package com.shark.SLQ_ConsoleBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		Board b = new Board();
		b.run();
	}
}
