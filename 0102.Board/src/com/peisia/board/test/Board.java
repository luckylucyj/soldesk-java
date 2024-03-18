package com.peisia.board.test;

import java.util.Scanner;

import javax.xml.crypto.Data;

public class Board {
	Scanner sc=new Scanner(System.in);
	String cmd;
	public static void run() {
		Data.loadData();
		Disp.title();
		ProcMenu.run();
	}
}
