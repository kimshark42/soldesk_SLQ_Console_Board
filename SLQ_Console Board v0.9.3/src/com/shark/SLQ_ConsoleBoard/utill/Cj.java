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
