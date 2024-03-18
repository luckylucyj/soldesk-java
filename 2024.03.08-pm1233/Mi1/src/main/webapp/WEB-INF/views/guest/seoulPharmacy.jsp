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
약국 정보 불러오기
<c:forEach var="item" items="${row}">
약국명:${item.DUTYNAME}<hr>
주소:${item.DUTYADDR}<hr>
전화번호:${item.DUTYTEL1}<hr>
영업시간(월):${item.DUTYTIME1S}~${item.DUTYTIME1C}<hr>
영업시간(화):${item.DUTYTIME2S}~${item.DUTYTIME2C}<hr>
영업시간(수):${item.DUTYTIME3S}~${item.DUTYTIME3C}<hr>
영업시간(목):${item.DUTYTIME4S}~${item.DUTYTIME4C}<hr>
영업시간(금):${item.DUTYTIME5S}~${item.DUTYTIME5C}<hr>
영업시간(토):${item.DUTYTIME6S}~${item.DUTYTIME6C}<hr>
영업시간(일):${item.DUTYTIME7S}~${item.DUTYTIME7C}<hr>
영업시간(공휴일):${item.DUTYTIME8S}~${item.DUTYTIME8C}<hr>
</c:forEach>
</body>
</html>