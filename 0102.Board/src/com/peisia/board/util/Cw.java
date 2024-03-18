package com.peisia.board.util;

public class Cw {
	public static final String DOT = "📝";
	public static final int LINE = 32;

	public static void w(String s) {
		System.out.print(s);
	}

	public static void wn(String s) {
		System.out.println(s);
	}

	public static void wn() {
		System.out.println();
	}

	public static void line() {
		for (int i = 0; i < LINE; i++) {
			w(DOT);
		}
	}

	public static void dot() {
		w(DOT);
	}
	
	public static void space(int s) {
		for(int i=0;i<s; i++) {
			w("");
		}
	}

}
