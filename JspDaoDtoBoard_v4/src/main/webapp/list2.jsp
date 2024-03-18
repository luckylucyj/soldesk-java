<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.db.Dto"%>
<%@page import="com.peisia.db.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="list.css">
</head>
<body>
글번호, 제목, 작성자<hr>
<%
//페이지 블록 만들기 위한 재료
String pageNum=request.getParameter("page");
//페이지 개수가 영이면 페이지 넘을 1로 반환
if(pageNum==null){
	pageNum="1";
}
//처리하는 클래스를 만들어 놓은게 Dao이고 그걸 통해 만든 객체가 dao
Dao dao=new Dao();

//총 페이지 개수는 영으로 선언
int totalPage=0;

//posts라는 어레이 빈값으로 선언
ArrayList<Dto> posts=null;

//검색한 단어는 word에서 파라미터로 가져와서 대입한다.
String searchWord=request.getParameter("word");
if(searchWord==null||searchWord.equals("null")){
	//글 리스트 불러오는 함수
	posts=dao.list(pageNum);
	totalPage=dao.getTotalPageCount();
}else{
	posts=dao.listSearch(searchWord,pageNum);
	totalPage=dao.getSearchTotalPageCount(searchWord);
}

for(int i=1; i<totalPage; i=i+1){
%>
<%=posts.get(i).no %>
<a href="list.jsp?page=<%=i%>&"></a>
<%=posts.get(i).id %>

<%
}
%>
<!-- ㄴㄹㄴㄹ -->
<form action="list.jsp">
	<input name="word">
	<input type="submit" value="검색">
</form>
<hr>
<fieldset id="link">
	<legend>링크</legend>
	<a href="write.jsp">쓰기</a>
	<a href="list.jsp">list로</a>
</fieldset>
<hr>
<fieldset id="log">
	<legend>로그</legend>
전체 페이지 수: <%=totalPage %><br>
현재 페이지 번호: <%=pageNum %><br>
</fieldset>
</body>
</html>