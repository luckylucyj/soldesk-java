<%@page import="com.peisia.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	여기 진짜오나???

	<%
/* 	GuestVO read = (GuestVO)request.getAttribute("read");
	long bno = read.getBno();
	String btext = read.getBtext(); */
%>

	글번호:${read.bno}
	<hr>
	글내용:
	<form action="${cp}/guest/modify" method="post">
		<input type="hidden" name='bno' value='${read.bno}'>
		<textarea name='btext'>${read.btext}</textarea>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>