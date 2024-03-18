package JavaBoardId;

import java.util.HashMap;

import JavaFunsionData.BoradFunsion;
import JavaFunsionData.Product;
import Util.Ci;
import Util.Cw;

public class P_CreateId {
	
	public static void createidrun() {
			
			Cw.wn("아이디를 만드는 곳 입니다!");
			String pw_1 ="";
			String id_1 ="";
			
			start:
			while (true) {
				id_1 = Ci.rw("id");
				for(int i = 0 ; i<BoradFunsion.idcount.size() ; i++) {
					if(id_1.equals(BoradFunsion.idPwData.get(i).id)) {
						Cw.wn("중복된 아이디가 있습니다! 다시 입력해주세요!");
						continue start;
					}
				}
				
				if (id_1.length() > 0) {
					BoradFunsion.idcount.add(new Product(id_1));
					break;
				} else {
					Cw.wn("1개 이상의 문자를 입력해주세요!");
				}
			}
	
			start2:
			while (true) {
				pw_1 = Ci.rw("pw");
				if (pw_1.length() > 0) {
					BoradFunsion.idPwData.add(new Product(id_1,pw_1));
					BoradFunsion.idPwDataHash.put(id_1,pw_1);
					BoradFunsion.loginDataHash.put("로그인중",BoradFunsion.idPwDataHash);
					break start2;
				} else {
					Cw.wn("1개 이상의 문자를 입력해주세요!");
				}
			}
			
			Cw.wn("ID가 성공적으로 만들어졌습니다!");
		
	}
}