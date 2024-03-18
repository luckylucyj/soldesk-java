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
<link rel="stylesheet" href="NewFile.css">
</head>
<body>
	글번호 | 제목 | 글내용 | 작성자id
	<hr>

	<%
	String readNum = request.getParameter("num");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from cat_board");
		while (rs.next()) {
			String num = rs.getString("num");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String id = rs.getString("id");
	%>
	

	<%=num%>
	<%-- ?가 받아오라는 내용임 --%>
	<a href="read.jsp?num=<%=num%>"><%=title%></a>
	<%=id%><br>

	<%
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
	<a href="write.jsp?num=<%=readNum%>">글쓰기</a>
</body>
</html>