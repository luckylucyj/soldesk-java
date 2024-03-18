package com.peisia.c.mysqlboard;

import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class ProcRead {
	static public void run() {
		//실행되는 Ci.r요소들은 run 함수안에 있다. 
		String readNo = Ci.r("읽을 글 번호를 입력해주세요:");
		try {
			//음식 배달할 때 쟁반에 받혀서 가져가듯이 셋팅하는 게 result=st.executeQuery()
			Db.result = Db.st.executeQuery("select * from "+Db.tableNameBoard+" where b_no ="+readNo);					
			Db.result.next();	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
			String title = Db.result.getString("b_title");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
			String content = Db.result.getString("b_text");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
			Cw.wn("글제목: "+title);
			Cw.wn("글내용: "+content);
			ProcReply.list(Integer.parseInt(readNo));	//댓글 리스트 출력 처리
			loop:while(true) {	//명령 입력 받게 하기. 나가기, 댓글쓰기
				String cmd=Ci.r("명령[x:나가기,r:댓글쓰기]");
				switch(cmd) {
				case "x":
					break loop;
				case "r":	//댓글 쓰기
					ProcReply.write(Integer.parseInt(readNo));
					break;
				default:
					Cw.wn("장난x");
				}
			}
		} catch (Exception e) {
		}
	}
}