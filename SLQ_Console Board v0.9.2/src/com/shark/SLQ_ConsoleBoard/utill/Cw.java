package com.shark.SLQ_ConsoleBoard.utill;

// 자주 쓰는 함수 ex) System.out.println(); 같은거 모아둔 java.class
// 함수를 사용할 class 안에 import com.shark.util.*; 이런식으로 넣어두면 됨

public class Cw {
	
	//라인 찍어주는 함수
	final public static String DOT = "🐟🦐"; 
	final public static String DOT2 = "🦈";
	public static void dot(int n) {
		for(int i=0;i<n;i++) {
			Color.sum(Color.BG_BRTGHT_BLUE, DOT);
		}
	}
	public static void dot2(int n) {
		for(int i=0;i<n;i++) {
			Color.sum(Color.BG_BLUE, DOT2);
		}
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