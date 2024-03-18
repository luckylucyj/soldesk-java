package com.peisia.noticeboard.test;

import com.peisia.c.board.data.Data;
import com.peisia.c.board.data.Post;
import com.peisia.util.Cw;

public class ProMenuList {
	public static void run() {
		Cw.wn("리스트임");
		for(Post p: Data.posts) {
			p.infoForList();
		}
	}
}
