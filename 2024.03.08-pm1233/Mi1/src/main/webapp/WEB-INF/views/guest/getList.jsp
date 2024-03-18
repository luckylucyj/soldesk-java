<%@page import="com.peisia.dto.GuestDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!-- el변수 cp에 경로저장 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
총 글 수 :${count} , 
총 페이지 수 :${totalPageCount} , 
블럭 당 페이지 수: ${pagesPerBlock} , 
현재 블럭: ${currentBlock} <br>
블럭 시작 페이지: ${blockStartPage} , 
블럭 끝 페이지: ${blockEndPage}, 
블럭 총 수 : ${blockCount}<br>
이전 블럭 가능: ${hasBlockPrev}, 
다음 블럭 가능: ${hasBlockNext} 

	<table>
		<tr>
			<td>글번호</td>
			<td>글내용</td>
		</tr>
		<!-- jstl 로 처리하면 더 짧게 가능 -->
		<c:forEach var="guest" items="${list}">
			<tr>
				<td>${guest.bno}</td>
				<td><a href="${cp}/guest/read?bno=${guest.bno}">${guest.btext}</a></td>
			</tr>
		</c:forEach>

	</table>

<!-- 이전 블럭 링크 코드-->
<c:if test="${hasBlockPrev}">
<a href="${cp}/guest/getList?currentPage=${prevPage}">이전</a>
</c:if>

<!-- 페이지 링크 -->
<c:forEach var="i" begin="${blockStartPage}" end="${blockEndPage}">
<a href="${cp}/guest/getList?currentPage=${i}">${i}</a>
</c:forEach>

<!-- 이전 블럭 링크 코드-->
<c:if test="${hasBlockNext}">
<a href="${cp}/guest/getList?currentPage=${nextPage}">다음</a>
</c:if>

 
	<a href="${cp}/guest/write">새글 쓰기</a>

	<%-- <c:forEach var="guest" items="${list}"> --%>
	<%--     <c:set var="bno" value="${guest.bno}" /> --%>
	<%--     <c:set var="btext" value="${guest.btext}" /> --%>
	<%--     ${bno} --%>
	<%--     ${btext} --%>
	<!--     <hr> -->
	<%-- </c:forEach> --%>

</body>
</html>