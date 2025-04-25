package com.shark.SLQ_ConsoleBoard.utill;

// 자주 쓰는 함수 ex) System.out.println(); 같은거 모아둔 java.class
// 함수를 사용할 class 안에 import com.shark.util.*; 이런식으로 넣어두면 됨

public class Cw {
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