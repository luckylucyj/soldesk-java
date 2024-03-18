package com.peisia.c.board.display;

import com.peisia.noticeboard.test.Board;
import com.peisia.util.Color;
import com.peisia.util.Cw;

public class Disp {

	public static void title() {
		// TODO Auto-generated method stub
		Cw.line();
		Cw.dot();
		Cw.space(15);
		Cw.w(Board.TITLE);
		Cw.space(15);
		Cw.dot();
		Cw.wn();
		Cw.line();
	}
	
	public static void menuMain() {
		Cw.dot();
		Color.yellow("[1.글 리스트/2.글읽기/3.글쓰기/4.글삭제/5.글수정/e.종료]");
//		Cw.w("[1.글 리스트/2.글읽기/3.글쓰기/4.글삭제/5.글수정/e.종료]");
		Cw.dot();
		Cw.wn();
	}

}
