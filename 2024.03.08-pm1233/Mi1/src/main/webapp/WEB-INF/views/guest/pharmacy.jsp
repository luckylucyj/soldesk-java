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
	약국 데이터 불러왔어요.
	<!-- dutyName-기관명 -->
	<!-- dutyAddr-주소 -->
	<!-- dutyEtc-비고(외래 진료 시간) -->

	기관명:${dutyName} 주소:${dutyAddr}
	<hr>
	월요일 진료 시간(c):${dutyTime1c}
	<hr>
	화요일 진료 시간(c):${dutyTime2c}
	<hr>
	수요일 진료 시간(c):${dutyTime3c}
	<hr>
	목요일 진료 시간(c):${dutyTime4c}
	<hr>
	금요일 진료 시간(c):${dutyTime5c}
	<hr>
	토요일 진료 시간(c):${dutyTime6c}
	<hr>
	일요일 진료 시간(c):${dutyTime7c}
	<hr>
	공휴일 진료 시간(c):${dutyTime8c}
	<hr>
	
	
	월요일 진료 시간(s):${dutyTime1s}
	<hr>
	화요일 진료 시간(s):${dutyTime2s}
	<hr>
	수요일 진료 시간(s):${dutyTime3s}
	<hr>
	목요일 진료 시간(s):${dutyTime4s}
	<hr>
	금요일 진료 시간(s):${dutyTime5s}
	<hr>
	토요일 진료 시간(s):${dutyTime6s}
	<hr>
	일요일 진료 시간(s):${dutyTime7s}
	<hr>
	공휴일 진료 시간(s):${dutyTime8s}
	<hr>
	공휴일 진료 시간(s) 예외:${dutyTime}
	<hr>
	약국 정보:${dutyInf}
	<hr>
	
	<a href="${cp}/">뒤로가기</a>
</body>
</html>