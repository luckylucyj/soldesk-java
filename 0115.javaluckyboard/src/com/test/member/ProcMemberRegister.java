package com.test.member;

import com.peisia.util.Ci;
import com.peisia.util.Cw;

public class ProcMemberRegister {
	// id랑 pw 입력하는거라 비공개적으로 해야 됨, 내 아이디와 비밀번호를 누구든 볼 수 있다고 생각하면 소름돋음
	static private String cmd="";
	static public void run() {
		Cw.wn("++++++++++++회원가입++++++++++++");
		String id="";
		String pw="";
		while(true) {
			id=Ci.r("아이디를 입력해주세요");			
			if(id.length()<=0) {
				Cw.wn("제대로 입력해주세요");
			}else {
				
			}
		}
		while(true) {
			pw=Ci.r("비밀번호를 입력해주세요");			
			if(id.length()<=0) {
				Cw.wn("제대로 입력해주세요");
			}else {
				
			}
		}
	}
}
