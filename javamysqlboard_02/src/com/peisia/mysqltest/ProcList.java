package com.peisia.mysqltest;

import java.sql.SQLException;

import com.peisia.c.board.display.Disp;
import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;


/*
 * 글리스트 보여줘 어떻게 보여줄껀데?->db 연결해서-> 
너가 원하는 페이지의 글을 보여줄게
페이지글수를 어떻게 알까->내가 어떻게 알지?->그러면 이 글을 보고 있는 사람에게 보여주자.
String cmd;
cmd=Ci.r("보고싶은 페이지 번호를 입력해주세요");

final은 함수안에 있으면 안되?-> 전역적으로 쓰는 게 좋기 때문에 밖에 썼어
 * */

public class ProcList {
	static public final int PER_PAGE = 3;

	static public void run() {
		int startIndex = 0;		// 현재 페이지의 첫 글 인덱스
		int currentPage = 1;	// 현재 페이지
		
		////	전체 페이지 수를 구하기	////
		int totalPage = 0;
		if(Db.getPostCount() % PER_PAGE > 0) {
			totalPage = Db.getPostCount() / PER_PAGE + 1;
		}else {
			totalPage = Db.getPostCount() / PER_PAGE;
		}
		
		Cw.wn("총 페이지 수:"+totalPage);
		
		String cmd;
		// 페이지 번호를 입력 받으면 해당 페이지 글을 보여줌
		while(true) {
			
			//while문 안에 페이지 입력 코드 있는 건 이제 국룰
			cmd = Ci.r("페이지번호입력[이전 메뉴로:x]:");
			//죄송합니다. switch문 어떻게 쓰는지 까먹어서는 아니고 조건으로 걸어야 해서 if문으로 짰어요
			
			if(cmd.equals("x")) {
				break;
			}

			//입력받은 값은 문자니까 숫자로 바꿔주고 만약에 입력받은 페이지 번호가 아직 존재하지 번호라면 안내 메시지 한번 띄어줄게
			currentPage=Integer.parseInt(cmd);
			if(currentPage>totalPage|| currentPage<1) {
				Cw.wn("페이지 범위에 맞는 값을 넣어주세요");// 이 안내 페이지는 한 줄 차지해야 하기 때문에 wn으로 감싸서 출력해요
				continue;//그리고 다시 이어지게 컨티뉴를 써줘요-왜냐하면 손님을 바로 걷어찰 수는 없잖아요
			}
			
			startIndex = (currentPage - 1) * PER_PAGE;	// 페이지의 첫 인덱스를 계산해서 저장하기
			Disp.titleList();
//			select count(*) from board where b_reply_ori is null;
			String sql = "select * from board where b_reply_ori is null limit "+startIndex+","+PER_PAGE;
			try {
				Cw.wn("전송한sql문:"+sql);
				Db.result = Db.st.executeQuery(sql);
				while(Db.result.next()) {
					String no=Db.result.getString("b_no");
					String title = Db.result.getString("b_title");
					String id = Db.result.getString("b_id");
					String datetime = Db.result.getString("b_datetime");
					Cw.wn(no+" "+title+" "+id+" "+datetime);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			
		}
		


	}
}
