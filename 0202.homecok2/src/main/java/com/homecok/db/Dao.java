package com.homecok.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Dao{
	public Connection con=null;
	public Statement st=null;
	public void connect() {
		try {
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			con=DriverManager.getConnection(Db.DB_URL,Db.DB_ID,Db.DB_PW);
			st=con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(String sql) {
		try {
			st.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			st.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}