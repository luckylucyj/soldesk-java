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
	String editNum = request.getParameter("num");
	String title = null;
	String content = null;
	String id = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		String sql = "select * from cat_board where num=" + editNum;
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		title = rs.getString("title");
		content = rs.getString("content");
		id = rs.getString("id");

	} catch (Exception e) {
		e.printStackTrace();
	}
	%>

	글번호<%=editNum%><br>
	<form action="modifyproc.jsp" method="get">
		<input name="num" type="hidden" value=<%=editNum%>>
		<input name="title" value="<%=title%>"><br>
		<textarea name="content" rows=5 cols=50><%=content%>></textarea>
		<input name="id" value="<%=id%>">
		<input type="submit" value="글수정하기">
	</form>
</body>
</html>