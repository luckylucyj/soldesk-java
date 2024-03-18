package com.peisia.noticeboard.test;

import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.c.board.data.Data;

public class ProcMenuDel {
	 static void run() {
		Cw.wn("글을 삭제합니다.");
		String cmd = Ci.r("삭제할 글 번호");
		int tempSearchIndex = 0;
		for (int i = 0; i < Data.posts.size(); i++) {
			if (cmd.equals(Data.posts.get(i).instanceNo + "")) {
				tempSearchIndex = i;
			}	
		}
		
		Data.posts.remove(tempSearchIndex);
		Cw.wn("글 수:"+Data.posts.size());
	}
}
