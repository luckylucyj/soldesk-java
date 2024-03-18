package com.peisia.board.util;

import java.util.Scanner;

public class Ci {
	Scanner sc = new Scanner(System.in);
	String cmd;

	public static String r() {
		return sc.next();
	}

	public static String r(String s) {
		Cw.w(s + ".");
		return sc.next();
	}

}
