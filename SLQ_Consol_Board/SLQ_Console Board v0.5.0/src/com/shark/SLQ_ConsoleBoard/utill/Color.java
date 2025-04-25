package com.shark.SLQ_ConsoleBoard.utill;

/* 컬러 코드 by 임상현, 한재우, sm.ahn */

/*
 *	사용법 : ex) sysout(RED(쓰고싶은 색깔) + "문자열" + EXIT)
 * //		또는 Color.sum(Color.BLUE,"shark");
 *          RGB 값으로 출력하고 싶을때 Color.rgb(0,0,0,"입력하고 싶은 문자열")
 *          다른 클래스에서 배경 + 글자색 적용해서 한줄 출력하고 싶으면 이거 넣으면 됨
 *        Color.printWithBgAndTextColor(Color.BG_YELLOW, Color.BLUE, "파란 글자 + 노란 배경!");  
 */

//콘솔 출력되는 글자 색 변경

public class Color {

	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";

	public static final String EXIT = "\u001B[0m";

	public static final String BG_BLACK = "\u001B[40m";
	public static final String BG_BRTGHT_BLACK = "\u001B[100m";
	public static final String BG_RED = "\u001B[41m";
	public static final String BG_GREEN = "\u001B[42m";
	public static final String BG_YELLOW = "\u001B[43m";
	public static final String BG_BLUE = "\u001B[44m";
	public static final String BG_BRTGHT_BLUE = "\u001B[104m";
	public static final String BG_MAGENTA = "\u001B[45m";
	public static final String BG_CYAN = "\u001B[46m";
	public static final String BG_WHITE = "\u001B[47m";

	public static final String BOLD = "\u001B[1m";	//진하게. 다른것들과 조합 가능함. BOLD + UNDERLINE
	public static final String DIM = "\u001B[2m";	//밝은 (안되는듯?)
	public static final String UNDERLINE = "\u001B[4m";	//밑줄
	public static final String BLINK = "\u001B[5m";		//깜빡임	(안되는듯?)
	public static final String REVERSE = "\u001B[7m";	//뒤집힌 색상 <폰트 색이 아닌 배경색으로 지정>
	public static final String HIDDEN = "\u001B[8m";	//숨김 <가려진 박스(약간 회색)로 가림>
	public static final String STRIKETHROUGH = "\u001B[9m";	//지우기 <중간에 쭉 취소선 그려짐>
	public static final String RESET = "\u001B[0m";			//리셋 (안되는듯?)
	public static final String ITALIC = "\u001B[3m";		//이탤릭

	// 색상 코드 상수 추가
	public static final String BRIGHT_BLACK = "\u001B[90m";
	public static final String BRIGHT_RED = "\u001B[91m";
	public static final String BRIGHT_GREEN = "\u001B[92m";
	public static final String BRIGHT_YELLOW = "\u001B[93m";
	public static final String BRIGHT_BLUE = "\u001B[94m";
	public static final String BRIGHT_PURPLE = "\u001B[95m";
	public static final String BRIGHT_CYAN = "\u001B[96m";
	public static final String BRIGHT_WHITE = "\u001B[97m";

	// 색상 코드 상수 추가 (256, 24bit)
	public static final String COLOR_256 = "\u001B[38;5;82m"; // 예: 256색 초록색
	
	                                                 //38: 전경색 설정 (텍스트의 색상).
												     //48: 배경색 설정 (텍스트 배경의 색상). <둘을 섞는게 가능함. 두 값을 같이 +로 결합하고 뒤에 문자열 붙여주면 됨>
	public static final String COLOR_24BIT = "\u001B[38;2;255;105;180m"; // 예: 24비트 핑크색
													   //   R   G   B (에 해당하는 수치. 0~255)
	public static final String COLOR_24BIT2 = "\u001B[48;2;255;255;180m"; // 예: 24비트 핑크색

	static public void test(String s) {
		System.out.println(ITALIC + s + EXIT);
	}
	
	static public void rgb(int r, int g, int b, String s) {
		System.out.println(String.format("\u001B[38;2;%s;%s;%sm%s%s", r,g,b,s,EXIT));
	}	
	static public void sum(String font, String s) {
		System.out.print(font + s + EXIT);
	}
	static public void sum(String font1, String font2, String s) {
		System.out.print(font1 + font2 + s + EXIT);
	}
	static public void sum(String font1, String font2, String font3, String s) {
		System.out.print(font1 + font2 + font3 + s + EXIT);
	}
	static public void sumLn(String font, String s) {
		System.out.println(font + s + EXIT);
	}
	
	public static void printWithBgAndTextColor(String bgColor, String textColor, String msg) {
		System.out.println(bgColor + textColor + msg + EXIT);   // -> 배경+글자색을 같이 적용해서 한줄에 출력
	}

	static public void blackLn(String s)    {	sumLn(BLACK,s);	    }
	static public void redLn(String s)      {	sumLn(RED,s);	    }
	static public void greenLn(String s)    {	sumLn(GREEN,s);	    }
	static public void yellowLn(String s)   {	sumLn(YELLOW,s);	}
	static public void blueLn(String s)     {	sumLn(BLUE,s);	    }
	static public void purpleLn(String s)   {	sumLn(PURPLE,s);	}
	static public void cyanLn(String s)     {	sumLn(CYAN,s);	    }
	static public void whiteLn(String s)    {	sumLn(WHITE,s);	    }

	static public void black(String s)      {	sum(BLACK,s);	}
	static public void red(String s)        {	sum(RED,s);	    }
	static public void green(String s)      {	sum(GREEN,s);	}
	static public void yellow(String s)     {	sum(YELLOW,s);	}
	static public void blue(String s)       {	sum(BLUE,s);    }
	static public void purple(String s)     {	sum(PURPLE,s);	}
	static public void cyan(String s)       {	sum(CYAN,s);    }
	static public void white(String s)      {	sum(WHITE,s);	}

//	public static void main(String[] args) {
//		String colors[] = new String[8];
//
//		for (int i = 0; i < 8; i++) {
//			colors[i] = "\u001B[3" + i + "m";
//		}
//
//		try {
//			while (true) {
//				int ran = (int) (Math.random() * 8);
//				String s = "AAAAAAAAAAAAAAAAAA";
//
//				System.out.println(colors[ran] + s + exit);
//
//				Thread.sleep(100);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}