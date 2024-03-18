<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	String id=request.getParameter("id");
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat","root","root");
	Statement st=con.createStatement();
// 	st.executeUpdate("insert into cat_board (id, title, content) values('"+id+"','"+title+"','"+content+"')");
// 	바로 넣는 방법이 있고 변수 만들어서 담아서 하는 법이 있음
	String sql="insert into cat_board (id, title, content) values('"+id+"','"+title+"','"+content+"')";
	int resultCount=st.executeUpdate(sql);
	System.out.println("전송하려는 글"+sql);
	if(resultCount==1){
		System.out.println("전송성공");
	}else{
		System.out.println("전송실패");
	}
	}catch(Exception e){
		e.printStackTrace();
	}

	response.sendRedirect("list.jsp");
%>
</body>
</html>