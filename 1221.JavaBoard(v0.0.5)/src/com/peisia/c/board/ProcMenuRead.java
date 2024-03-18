package com.peisia.c.board;

import com.peisia.c.board.data.Data;
import com.peisia.c.board.data.Post;
import com.peisia.util.Ci;

public class ProcMenuRead {
	static void run() {
		// todo
		// 임시
		
		String cmd = Ci.r("읽을 글 번호");
		for (Post p : Data.posts) {
			if (cmd.equals(p.instanceNo + "")) {
				p.infoForRead();
			}
		}
	}

}
