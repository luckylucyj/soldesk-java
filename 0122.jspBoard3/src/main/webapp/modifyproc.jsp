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
	String editNum=request.getParameter("num");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	String id=request.getParameter("id");
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat","root","root");
		Statement st=con.createStatement();
		
// 		String sql = "update cat_board set "
// 				+"title='"
// 				+title
// 				+"', "
// 				+"content='"
// 				+content
// 				+"', "
// 				+"id='"
// 				+id
// 				+"' "
// 				+"where num=" + editNum;
		
		String sql="update cat_board set title='"+title+"' ,"+
				"content='"+content+"' ,"+
				"id='"+id+"' "+
				"where num= " + editNum;
	int countNum=st.executeUpdate(sql);
	if(countNum==1){
		System.out.println("전송성공");
	}else{
		System.out.println("전송실패");
		
	}
		System.out.println("================"+sql);
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	
	response.sendRedirect("list.jsp"); // 글리스트 화면으로 강제 이동

%>
</body>
</html>