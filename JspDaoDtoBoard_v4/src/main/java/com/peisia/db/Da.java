package com.peisia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//db연결하고 데이터 갱신하고 닫기까지 해줄게
public class Da {
	Connection con=null;
	Statement st = null;
	//처음에 연결하고 업데이트하고 db닫는것까지 하나로 묶어놨는데 그거를 하나씩 분리함
	//연결해줄게
	void connect() {
		try {
			////고정 1
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			////고정 2
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);			
			////고정 3
			st=con.createStatement();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//업데이트할게
	void update(String sql) {
		try {
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//닫아줄게
	void close() {
		try {
			////고정 4
			st.close();
			////고정 5
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
