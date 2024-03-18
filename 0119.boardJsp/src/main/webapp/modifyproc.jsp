<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String editNum=request.getParameter("num");
	String title=request.getParameter("title");
	String id=request.getParameter("id");
	String content=request.getParameter("content");
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat","root","root");
		Statement st=con.createStatement();
		String sql="update cat_board set title='"+title+"', id='"+id+"', content='"+content+"' where num="+editNum;
		int countNum=st.executeUpdate(sql);
		System.out.println("수정할 구문:"+sql);
		if(countNum==1){
			System.out.println("전송성공");
		}else{
			System.out.println("전송실패");			
		}
	}catch(Exception e){
		e.printStackTrace();
	}

	response.sendRedirect("list.jsp");	
%>
