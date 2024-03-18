<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<%-- <%@ page session="false" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Home</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<a href="/test/getOnePlusTwo">1+2 결과 보러 가기</a>
	<a href="${cp}/guest/getList">[방명록]</a>
	<a href="${cp}/guest/write">새글 쓰기</a>
	<a href="${cp}/weather/weatherList">우리나라 날씨</a>
	어제의 날씨입니다~ 어제 ${location} 의 최저기온은
	${tMin} 도 최고 기온은 ${tMax} 였습니다. 날씨였습니다.
	
	 <button onclick="showCat()">고양이를 보자</button>
	 <div><img id="img-cat"></div>
	 <hr>
	 <a href="${cp}/guest/pharmacy">우리나라 약국</a>
	 <hr>
	 <a href="${cp}/guest/atmosphere">대기농도</a>
	  <hr>
	 <a href="${cp}/guest/seoulPharmacy">한국 약국</a>

	 <a href="${cp}/guest/culture">문화</a>
	 
	 
	<script>
	
	 function showCat() {
         $.ajax({
             type: "GET",
             url: "https://api.thecatapi.com/v1/images/search",
             data: {},
             success: function (response) {
                 let imgUrl = response[0]['url'];
                 $("#img-cat").attr("src", imgUrl);
             }
         })
     }
	</script>
</body>
</html>
