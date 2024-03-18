<%-- <%@page import="com.peisia.hello.Cat"%> --%>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
    
<%-- <%@ page errorPage="error.jsp" %>     --%>
    
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->

<%-- <% --%>
// 	Cat cat = new Cat();
// 	System.out.println("콘솔로찍기:"+cat.name);
<%-- %> --%>

<%-- <%=cat.name %> --%>

<!-- </body> -->
<!-- </html> -->

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->
<%-- <% --%>
// 	request.setCharacterEncoding("UTF-8");	// 이거 안하면 한글 깨짐.
// 	String s = request.getParameter("tel");
// 	out.println(s);	// 1.이걸로 출력하거나
<%-- %> --%>
<%-- 입력한 전화번호:<%=s%>2. 이걸로 출력 --%>
<!-- </body> -->
<!-- </html> -->
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
	response.sendRedirect("http://naver.com");
%>

<% %>

</body>
</html>
