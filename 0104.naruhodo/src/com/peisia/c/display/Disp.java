package com.peisia.c.display;

import com.peisia.c.board.Board;
import com.peisia.c.util.Cw;

public class Disp {
	public static void title() {
		Cw.line();
		Cw.dot();
		Cw.space(15);
		Cw.w(Board.TITLE);
		Cw.space(15);
		Cw.dot();
		Cw.wn();
	}
	
	public static void menuMain() {
		Cw.dot();
		Cw.w("1.글리스트/2.글읽기/3.글쓰기/4.글수정/5.글삭제/x.종료");
		Cw.dot();
		Cw.wn();
	}
}
