package JavaBoardId;

import java.util.Map;
import java.util.Scanner;

import JavaFunsionData.BoradFunsion;
import Util.Cw;

public class P_IdCheck {

	public static String idwiter = "";
	public static String id_value;
	public static String pw_value;

	public static void idcheckrun() {

		Scanner sc = new Scanner(System.in);
		boolean pwExists = false;
		boolean idExists = false;
		Cw.wn("아이디를 입력해주세요!");
		String cmd_id = sc.nextLine();
		id_value = cmd_id;
		for (Map.Entry<String,String> idchek : BoradFunsion.idPwDataHash.entrySet()) {
			if (id_value.equals(idchek.getKey())) {
				idExists = true;
				Cw.wn("비밀번호를 입력해주세요!");
				String cmd_pw = sc.nextLine();
				pw_value = cmd_pw;
				if (pw_value.equals(idchek.getValue())) {
					pwExists = true;
					break;
				}
			}
		}
			
		if (idExists && pwExists) {
			Cw.wn("로그인 완료! 회원전용 글쓰기로 이동합니다.");
			idwiter = id_value;
			P_MenuIdList.menuidlistrun();
		} else {
			Cw.wn("아이디 또는 비밀번호가 다릅니다! 메인화면으로 이동합니다");
		}

	}

}
