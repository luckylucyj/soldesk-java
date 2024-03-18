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
한국환경공단 에어코리아 대기오염 통계
<hr>
시간:${dataTime} 
<br>
구분: ${dataGubun} 
<br>
항목명:${itemCode} (PM10은 미세먼지 농도)
<br>
서울: ${seoul}
<br>
대구:${daegu}
<br> 
충남: ${chungnam}
<br>
인천:${incheon}
<br> 
대전: ${daejeon}
<br>
경북:${gyeongbuk}
<br> 
세종: ${sejong}
<br>
광주:${gwangju}
<br> 
전북: ${jeonbuk}
<br>
강원:${gangwon}
<br>
울산:${ulsan}
<br>
전남:${jeonnam}
<br>
부산:${busan}
<br>
충북:${chungbuk}
<br>
제주: ${jeju}

</body>
</html>