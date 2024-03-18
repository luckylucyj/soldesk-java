package com.peisia.util;

public class Cw {
	private static final String DOT = "📜";
	private static final int LINE_LENGTH = 32;

	// print는 옆에 붙게 하는 기능
	public static void w(String s) {
		System.out.print(s);
	}

	public static void wn(String s) {
		System.out.println(s);
	}

	// wn 함수 - 오버로딩
	// 그냥 엔터하나 넣어주는 함수.
	public static void wn() {
		System.out.println();
	}
	/*
	 * 선 긋는 함수
	 */
	
	public static void line() {
		for(int i=0; i<LINE_LENGTH; i++) {
			w(DOT);
		}
		wn();
	}
	
	
	public static void dot() {
		w(DOT);
	}
	
	public static void space(int c) {
		for(int i=0;i<c;i++) {
			w(" ");
		}
	}

}
