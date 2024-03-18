package com.peisia.c.laywer;

import com.peisia.c.data.Data;
import com.peisia.c.display.Disp;

public class Board {

	
	public static void run() {
		Data.loadData();
		Disp.title();
		ProcMenu.run();
		//데이타 로드하기
		//타이틀 올리기
		//메뉴판 보여주기
	
	}
}
