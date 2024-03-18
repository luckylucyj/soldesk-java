package com.peisia.mysqltest;

import java.sql.SQLException;

import com.peisia.c.board.display.Disp;
import com.peisia.util.Ci;
import com.peisia.util.Cw;
import com.peisia.util.Db;

public class ProcList {
	//몇개씩 보일지 설정하기
	static public final int PER_PAGE = 3;

	static public void run() {
		int startIndex = 0;		// 현재 페이지의 첫 글 인덱스
		int currentPage = 1;	// 현재 페이지
		
		
		////	전체 페이지 수를 구하기	////
		//전체 페이지 수를 구하는 데 처음에는 빈값으로 설정하고 원하는 값을 넣어줄게
		// 그 원하는 값은 데이터 베이스에서 받아온 값으로 할게
		
		int totalPage = 0;
		// 만약 3이랑 나눠서 나머지가 있으면 PER_PAGE를 늘려서 총 페이지수를 늘릴께 아니면 안늘릴께
		
		if(Db.getPostCount() % PER_PAGE > 0) {
			totalPage = Db.getPostCount() / PER_PAGE + 1;// 아 헷갈렸던 부분이 PER_PAGE를 늘리는게 아니라 totalpage수를 늘리는 거구나
		}else {
			totalPage = Db.getPostCount() / PER_PAGE;
		}
		
		Cw.wn("총 페이지 수:"+totalPage);

		//여기서부터는 숫자로 입력받아서 너가 원하는 행동을 실행해줄께 1. 글리스트 보여줄게 2. 글 읽어줄게 3. 글 써서 데이터 베이스에 추가할게 4. 글 수정할게
		//5. 
		String cmd;
		
		while(true) {
			//값을 입력받는 코드는 while문 안에 있는 게 국룰, 안에 없으면 한번 입력하고 반복됨.......
			cmd = Ci.r("페이지번호입력[이전 메뉴로:x]:");
			//x 누르면 종료되게 설정해줄게
			if(cmd.equals("x")) {
				break;
			}
			
			//현재 페이지=cmd로 입력한 문자열을 숫자로 바꿔서 인식해줄게
			currentPage = Integer.parseInt(cmd);
			if(currentPage > totalPage || currentPage < 1) {
				Cw.wn("페이지 범위에 맞는 값을 넣어주세요");
				continue;
			}

			startIndex = (currentPage - 1) * PER_PAGE;	// 페이지의 첫 인덱스를 계산해서 저장하기
			//밑줄, 타이틀의 구성(작성자id, 작성일, title)구성을 볼 수 있다.
			Disp.titleList();
//			select count(*) from board where b_reply_ori is null;
			String sql = "select * from board where b_reply_ori is null limit "+startIndex+","+PER_PAGE;
			try {
				Cw.wn("전송한sql문:"+sql);
				Db.result = Db.st.executeQuery(sql);
				while(Db.result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
					String no = Db.result.getString("b_no");
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
