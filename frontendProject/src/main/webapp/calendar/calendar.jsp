<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/calendar.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="calwrap"> <!-- 캘린더 전체구역 -->
		<div> <!-- 캘린더 전체구역 -->
			
			<div class="caltop"> <!-- 상단 메뉴 -->
				<button onclick="onNext(0)" type="button"> < </button> <!-- 이전달 버튼 -->
				<h3 class="caldate"> 2023년 07월 </h3> <!-- 현재/월 표시구역 -->
				<button onclick="onNext(1)" type="button"> > </button> <!-- 다음달 버튼 -->
			</div>
			<div class="calendar"> <!-- 날짜 표시 구역 -->
				<!-- 상단 요일 표기 일~토 -->

				<!-- 일 표기 -->
>
			</div>
		
		</div>
	</div> <!-- 캘린더 전체구역 end -->	
	
	<div class="modalwrap"> <!-- 모달 전체 구역 -->
		<div class="modal"> <!-- 모달 상자 -->
			
			<h3>일정 추가</h3>
			<input class="color" type="color">
			<div class="date">2023-7-10</div>
			<textarea class="contentInput" rows="5" cols="10"></textarea>
			<div class="modalbtns">
				<button onclick="onWrite()" type="button">일정 등록</button>
				<button onclick="closeModal()">닫기</button>
			</div>
		</div>
	</div>
	
	<%@include file ="../footer.jsp" %>	
	<script src="../js/calendar.js" type="text/javascript"></script>
</body>
</html>