<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
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
	String num=null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat","root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from cat_board");
// 		while로 감싸지 않으면 글 하나만 불러옴()
		while(rs.next()){
		num=rs.getString("num");
		String title=rs.getString("title");
		String content=rs.getString("content");
		String id=rs.getString("id");
		%>
		글제목:<%=num %>
		<a href="read.jsp?num=<%=num %>"><%=title %>></a>
		<%=id %><br>
	<%
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	%>
	<a href="write.jsp?num=<%=num %>">글쓰기</a>
</body>
</html>