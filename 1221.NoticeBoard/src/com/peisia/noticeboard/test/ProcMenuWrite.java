package com.peisia.noticeboard.test;

import com.peisia.c.board.data.Data;
import com.peisia.c.board.data.Post;
import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcMenuWrite {
	public static void run() {
		Cw.wn("글을 작성중입니다.");
		String title;
		while (true) {
			title = Ci.rl("글제목");
			if (title.length() > 0) {
				break;
			} else {
				Cw.wn("장난치지 마세요");
			}
		}
		String content;
		while (true) {
			content = Ci.rl("글내용");
			if (content.length() > 0) {
				break;
			} else {
				Cw.wn("장난치지 마세요");
			}
		}
		String writer;
		while (true) {
			writer = Ci.r("작성");
			if (writer.length() > 0) {
				break;
			} else {
				Cw.wn("장난치지 마세요");
			}
		}
		
		Post p=new Post(title, content, writer, 0);
		Data.posts.add(p);
		Cw.wn("글 작성됨");

	}

}
