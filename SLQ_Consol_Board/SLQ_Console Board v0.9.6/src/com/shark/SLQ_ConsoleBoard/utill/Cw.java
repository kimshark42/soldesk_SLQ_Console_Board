package com.shark.SLQ_ConsoleBoard.utill;

// 자주 쓰는 함수 ex) System.out.println(); 같은거 모아둔 java.class
// 함수를 사용할 class 안에 import com.shark.util.*; 이런식으로 넣어두면 됨

public class Cw {
	
	//라인 찍어주는 함수
	final public static String DOT = "🐟🦐"; 
	final public static String DOT2 = "🦈";
	
	// Color.sum 을 쓰기 위해 void(함수)로 정의하는게 아니라 String(문자열)로 받게끔 수정
	public static String fishLine(int n) {
		StringBuilder sb = new StringBuilder();  // StringBuilder 는 하나의 객체에 문자열을
		for(int i=0;i<n;i++) {                   // 계속 덧붙일수 있도록 하는 내장 클래스
			sb.append(DOT);                      // 대신 마지막에 return을 반드시 써야됨
		}
		return sb.toString();
	}
	
	public static String sharkLine(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(DOT);
		}
		return sb.toString();
	}
	
// System.out.println();
	public static void w(String s) {
		System.out.println(s);
	}
//	wn 함수 - 오버로딩
	public static void wn(String s) {
		System.out.println(s);
	}
//	그냥 엔터 하나 넣어주는 함수
	public static void wn() {
		System.out.println();
	}
}