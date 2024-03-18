package com.peisia.c.board;

import java.util.Scanner;

import com.peisia.c.data.Data;
import com.peisia.c.display.Disp;

public class Board {
	public static final String TITLE="어서오세요. 나루호도 사무소에";
	Scanner sc=new Scanner(System.in);
	public void run() {
		Data.loadData();
		Disp.title();
		ProcMenu.run();
	}
}
