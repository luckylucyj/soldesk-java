package com.peisia.noticeboard.test;

import com.peisia.c.board.data.Data;
import com.peisia.c.board.data.Post;
import com.peisia.util.Ci;
import com.peisia.util.Color;
import com.peisia.util.Cw;		

public class ProcMenuUpdate {
	static void run() {
		Cw.wn("업뎃임");
		String cmd=Ci.r("수정할 글 번호");
		Color.purple(cmd);
		for(Post p:Data.posts) {
			if(cmd.equals(p.instanceNo+"")) {	
				String content=Ci.rl("수정 할 글 내용");
				p.content=content;
				Cw.wn("글 수정됨");
			}
		}
	}
}
