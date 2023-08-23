<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="accountbook.css" rel="stylesheet">
</head>
<body>
	<div class="wrap"> <!-- 웹페이지전체 -->
	
		<div class="textbox">
			<div class="inputbox">
				<input class="input_content" type="text" placeholder="항목내용">
				<input class="input_price" type="text" placeholder="금액">
				<input class="input_date" type="text" placeholder="날짜 2023-08-01">
			</div>
			<button onclick="cwrite()" class="btn_enter" type="button">등록하기</button>
		</div>
		<!--  출력구역  -->
		<div class="contentbox">
			<!-- 
			<div class="boxinfo">
				<div class="text">내용</div>
				<div class="price">금액</div>
				<div class="date">날짜</div>
			</div>
			
			
			<div class="productbox">
				<div class="text">컴퓨터</div>
				<div class="price">3650000원</div>
				<div class="date">2023-08-01</div>
				<div class="btn_box">
					<button class="btn_edit" type="button">수정</button>
					<button class="btn_delete" type="button">삭제</button>
				</div>
			</div>
			-->

		
			
		</div> <!-- 출력구역 end -->
		
	</div> <!-- 웹페이지전체 end -->

	<!-- 최신 JQUERY 불러오기 : AJAX 메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- js import -->
	<script src="accountbook.js" type="text/javascript"></script>
</body>
</html>