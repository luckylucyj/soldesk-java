<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
    
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->


<%-- <%@include file="common.jsp" %> --%>

<!-- 개1 -->



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


<%-- <jsp:include page="common.jsp" flush="true">	 --%>
<%-- 	<jsp:param name="x" value="11" /> --%>
<%-- 	<jsp:param name="y" value="22" /> --%>
<%-- </jsp:include> --%>

<!-- 개2 -->



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

<jsp:forward page="common.jsp">	
	<jsp:param name="x" value="11" />
	<jsp:param name="y" value="22" />
</jsp:forward>

개2

</body>
</html>