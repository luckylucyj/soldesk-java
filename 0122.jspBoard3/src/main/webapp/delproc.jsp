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
	String delNum = request.getParameter("num");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		String sql = "delete from cat_board where num=" + delNum;
		System.out.println("전송하려는 구문:"+sql);
		int resultNum = st.executeUpdate(sql);
		if (resultNum == 1) {
			System.out.println("전송완료");
		} else {
			System.out.println("전송완료");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	response.sendRedirect("list.jsp");
	%>
</body>
</html>