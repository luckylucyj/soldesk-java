
<%@page import="com.homecok.db.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.homecok.db.Dto"%>
<%@page import="com.homecok.db.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	글제목, 제목, 작성자<hr>
	<%
	ArrayList<Dto> posts = (ArrayList<Dto>) request.getAttribute("posts");

	for (int i = 0; i < posts.size(); i = i + 1) {
	%>
	<%=posts.get(i).no%>
	<a href="/board/read?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>
	<%=posts.get(i).id%>
	<hr>
	<%
	}
	%>
	<a href="/write.jsp">쓰기</a>
	<a href="/board/list">list로</a>
	<a href="/">홈으로</a>
</body>
</html>