
package com.peisia.noticeboard.test;
import java.util.Collections;
import java.util.Scanner;

import com.peisia.c.board.data.Data;
import com.peisia.c.board.display.Disp;

public class Board {
	public static final String VERSION = "v0.0.1";
	public static final String TITLE = "고양이 게시판 (" + VERSION + ") feat. sm.ahn";
	Scanner sc=new Scanner(System.in);
	String cmd;
	
	public void run() {
		Data.loadData();//데이터 초기화(글 리스트 객체 생성 등)
		Disp.title();
		ProcMenu.run();
		sortPostsByHits();
	}
	
	
    private void sortPostsByHits() {
        // 히트 수를 기준으로 내림차순 정렬
        Collections.sort(Data.posts, (post1, post2) -> Integer.compare(post2.getHits(), post1.getHits()));
    }
}