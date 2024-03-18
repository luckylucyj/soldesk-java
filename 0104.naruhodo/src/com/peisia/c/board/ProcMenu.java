package com.peisia.c.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

public class ProcMenu {
//	Connection con = null;
//	Statement st = null;
//	ResultSet result = null;
//
//	void run() {
//		dbInit();
////		dbExecuteQuery("select * from tottenham_squad where p_number=7");
//		dbExecuteUpdate(
//				"insert into board (b_title,b_id,b_datetime,b_text,b_hit) values ('콘솔프로그램에서쓴글','kitty',now(),'콘솔프로그램에서 작성한 글입니다. 글글.....글....',0);");
//	}
//
//	private void dbInit() {
//		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_board", "root", "admin");
//			st = con.createStatement(); // Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열
//										// 수있다.
//		} catch (SQLException e) {
//			System.out.println("SQLException: " + e.getMessage());
//			System.out.println("SQLState: " + e.getSQLState());
//		}
//	}
//
//	private void dbExecuteQuery(String query) {
//		try {
//			result = st.executeQuery(query);
//			while (result.next()) { // 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
//				String name = result.getString("p_name"); // p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
//				System.out.println(name);
//			}
//		} catch (SQLException e) {
//			System.out.println("SQLException: " + e.getMessage());
//			System.out.println("SQLState: " + e.getSQLState());
//		}
//	}
//
//	private void dbExecuteUpdate(String query) {
//		try {
//			int resultCount = st.executeUpdate(query);
//			System.out.println("처리된 행 수:" + resultCount);
//		} catch (SQLException e) {
//			System.out.println("SQLException: " + e.getMessage());
//			System.out.println("SQLState: " + e.getSQLState());
//		}
//	}
	
	public static Connection con = null;
	public static Statement st = null;
	public static ResultSet result = null;
	
	public static void run() {
		dbInit();// dbInit(): 데이터베이스 연결을 초기화하는 메서드입니다. JDBC를 사용하여 MySQL 데이터베이스에 연결하고, 연결된 상태에서 Statement 객체를 생성합니다.
//		dbExecuteQuery("select * from tottenham_squad where p_number=7");
		
		//사용자에게 글 제목을 입력받은 후, dbExecuteUpdate() 메서드를 호출하여 입력받은 글 제목과 고정된 값들을 이용하여 "board" 테이블에 레코드를 삽입합니다.
		Scanner sc=new Scanner(System.in);
		System.out.println("글제목을 입력해주세요:");
		String title = sc.next();
		
		dbExecuteUpdate("insert into board (b_title,b_id,b_datetime,b_text,b_hit) values ('"+ title +"','kitty',now(),'콘솔프로그램에서 작성한 글입니다. 글글.....글....',0);");
		sc.close();
		
	}
	
	private static void dbInit() {
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat","root","root");
			st = con.createStatement();	// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열 수있다.

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
		finally {
	        try {
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	private void dbExecuteQuery(String query) {
		try {
			result = st.executeQuery(query);
			while (result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				String name = result.getString("p_name");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				System.out.println(name);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}
	
	private static void dbExecuteUpdate(String query) {//주어진 SQL 쿼리를 실행하고, 실행된 행의 수를 출력하는 메서드입니다
		try {
			int resultCount = st.executeUpdate(query);
			System.out.println("처리된 행 수:"+resultCount);
		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("SQLException: " + e.getMessage());
//			System.out.println("SQLState: " + e.getSQLState());
		}
	}	
}



