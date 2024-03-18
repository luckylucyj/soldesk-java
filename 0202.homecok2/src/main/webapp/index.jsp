<%@page import="com.homecok.db.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Single+Day&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="wrap pos-rel">
		<div class="wrap-inner flex-row">
			<!-- 왼쪽 -->
			<div class="box-left">
				<div class="font-18x today">
					<span class="col-blue">TODAY IS...🏖&nbsp;&nbsp;</span>그리움
				</div>
				<div class="border-box">
					<img src="./img/avatar.jpg" class="avatar">
				</div>
				<div class="profile">사람좋은 사람들<br>
				 싸이월드<br>
				 ^-^
				 </div>
<!-- 				history 부분 -->
				<div class="flex-row jufy-between history">
					<div class="flex-row border-bot">
						<div class="arrow-left"></div>
						<div>HISTORY</div>
					</div>
					<div class="flex-row">
						<div class="arrow-up"></div>
						<div class="arrow-down"></div>
					</div>
				</div>
				<div class="flex-row align-center">
				<div class="col-blue name">임한민&nbsp;&nbsp;</div>
				<div class="birth-txt-color">(♂)1996.10.31</div>
				</div>
				<div class="txt-orange email">waiting@kbs.co.kr</div>
				<div class="flex-row dotori-line">
				<div><img src="./img/blood.png"></div>
				<div class="margin-le-10"><img src="./img/dotori.jpeg"></div>
				</div>				
			</div>
			<!-- 오른쪽 -->
			<div class="box-right pos-rel">
				<nav class="pos-abs nav-pos">
					<ul class="flex-col">
						<li><a href="#">홈</a></li>
						<li><a href="#">프로필</a></li>
						<li><a href="#">쥬크박스</a></li>
						<li><a href="#">게시판</a></li>
						<li><a href="#">방명록</a></li>
					</ul>
				</nav>
				<!--미니룸 -->
				<div class="flex-row room-check">
					<div class="col-blue left-check pos-rel">미니룸</div>
					<div class="right-check">스토리룸</div>
				</div>
				<div class="mini-room"><img src="./img/group3.png"></div>
				<!-- 				한 줄 감성 -->
				<div class="col-blue one-line font-18x">일촌평</div>
				<!-- 				<div class="col-blue one-line font-18x">일촌평</div> -->
				<div class="flex-row jufy-between one-naver">
					<div class="flex-row jufy-between one-naver-left">
						<div class="col-blue">friends say</div>
						<input placeholder="일촌과 나누고 싶은 이야기를 남겨보세요~!" class="one-naver-text">
					</div>
					<input type="submit" value="확인" class="one-naver-right">
				</div>
				<div class="one-line-bottom-esc">
					안녕하세요? (친구 <span class="col-blue">노제</span> )
				</div>
				<div class="one-line-bottom-esc">
					안녕하세요? (친구 <span class="col-blue">노제</span> )
				</div>
				<div class="one-line-bottom-esc">
					안녕하세요? (친구 <span class="col-blue">노제</span> )
				</div>
			</div>
		</div>

	</div>


</body>
</html>