package com.peisia.mysqltest;

import com.peisia.c.board.display.Disp;
import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcBoard {
	void run() {
		/*
		 * 게시판 타이틀 만들어줄게(밑줄, 아이콘+타이틀, 밑줄) 형식으로
		 * */
		Disp.showTitle();
		//db에 게시판 내용 가져와서 연결해줄게
		Db.dbInit();
		//전체 글수 알려줄게 
		Cw.wn("전체 글수:"+Db.getPostCount());
		loop:while(true) {
			Db.dbPostCount();
			Disp.showMainMenu();
			String cmd=Ci.r("명령입력: ");
			switch(cmd) {
			case "1":	//글리스트
				ProcList.run();
				break;
			case "2":	//글읽기
				ProcRead.run();
				break;
			case "3":	//글쓰기
				ProcWrite.run();
				break;
			case "4":	//글삭제
				ProcDel.run();
				break;
			case "5":	//글수정
				ProcEdit.run();
				break;
			case "0":	//관리자
				break;
			case "e":	//프로그램 종료
				Cw.wn("프로그램종료");
				break loop;
			}
		}
	}
}