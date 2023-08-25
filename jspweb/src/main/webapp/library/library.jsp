<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- css import -->
	<link href="library.css" rel="stylesheet">
</head>
<body>

	<div class="wrap"> <!-- 전체구역 -->
		<h3> 도서관 열람실 입실/퇴실 </h3>
		<div class="contentbox"> <!-- 화면구역 -->
			<div class="seatarea"> <!-- 좌석구역 -->
				<div class="seatBox"> 

				</div>
			</div>
			
			<div class="inputBox"> <!-- 입력 구역 -->
				<input class="nameInput" type="text" placeholder="이름">
				<input class="phoneInput" type="text" placeholder="전화번호 -포함 ">
			</div>
			
		</div>
		<div class="buttonBox"> <!-- 버튼구역 -->
			<button onclick="enterseat()" class="btnEnter" type="button"> 입실 </button>
			<button onclick="outseat()" class="btnOut" type="button"> 퇴실 </button>
		</div>
	</div> <!-- 전체구역 end-->


	<!-- 최신 JQUERY 불러오기 : AJAX 메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- js import -->
	<script src="library.js" type="text/javascript"></script>
</body>
</html>