package com.peisia.noticeboard.test;
import com.peisia.c.board.data.Data;
import com.peisia.c.board.data.Post;
import com.peisia.util.Ci;
import com.peisia.util.Color;
import com.peisia.util.Cw;

public class ProcMenuRead {
	public static void run() {
		Cw.wn("글 읽기중입니다");
		String cmd=Ci.r("읽을 글 번호");
		Color.blue(cmd);
		for(Post p:Data.posts) {
			if(cmd.equals(p.instanceNo+"")) {
				p.infoForRead();
				break;
			}
		}
	}
}
