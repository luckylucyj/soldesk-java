<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	어제의 날씨입니다~ 어제 ${location} 의 최저기온은 ${tMin} 도 최고 기온은 ${tMax} 였습니다.
	날씨였습니다.

	<a href="${cp}/">뒤로가기</a>
</body>
</html>