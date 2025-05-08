package com.shark.SLQ_ConsoleBoard.utill;

public class Line {
	
	final static String FISH = "🐟🦐";
	final static String SHARK = "🦈";
	final static String WHILE = "🐳";
	
	// 사용할때는 Color.sum(Color.BG_RED,sharkLine(10)); 이런식으로 쓰면 됨
	// Color.sum 을 쓰기 위해 void(함수)로 정의하는게 아니라 String(문자열)로 받게끔 수정
		public static String fishLine(int n) {
			StringBuilder sb = new StringBuilder();  // StringBuilder 는 하나의 객체에 문자열을
			for(int i=0;i<n;i++) {                   // 계속 덧붙일수 있도록 하는 내장 클래스
				sb.append(FISH);                      // 대신 마지막에 return을 반드시 써야됨
			}
			return sb.toString();
		}
		
		public static String sharkLine(int n) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<n;i++) {
				sb.append(SHARK);
			}
			return sb.toString();
		}
		
		public static String whileLine(int n) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<n;i++) {
				sb.append(WHILE);
			}
			return sb.toString();
		}
		
}
