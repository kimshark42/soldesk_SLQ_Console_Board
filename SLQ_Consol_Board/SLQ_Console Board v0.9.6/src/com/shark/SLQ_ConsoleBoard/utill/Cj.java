package com.shark.SLQ_ConsoleBoard.utill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 입력 담당

public class Cj {
	static Scanner sc = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
	static public String r() {
		return sc.next();
	}
	static public String r(String comment) {
		Cw.w(comment + ":");
		return sc.next();
	}
	
	static public String cr(int r, int g, int b, String comment) {
		String coloredComment = String.format("\u001B[38;2;%d;%d;%dm%s%s", r, g, b, comment, Color.EXIT);
		Cw.w(coloredComment + ": ");
		return sc.next();
	}
	static public String bcr(String colorCode, String comment) {
		Color.sum(colorCode,comment + ": ");
		return sc.next();
	}
	
	static public String rl(String comment) {
		Cw.w(comment + ":");
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
