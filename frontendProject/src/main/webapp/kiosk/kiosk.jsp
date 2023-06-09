<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/frontendProject/css/kiosk.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp"%>

	<div class="kioskwrap">
		<div class="kioskheader">
			<!-- 헤더 : 광고이미지 / 카테고리출력 표시되는 구역 -->
			<!-- 광고이미지 -->
			<img class="himg" src="../img/himg1.png">

			<!-- 카테고리 -->
			<ul class="categorymenu">
				<!--categoryPrint() 함수가 html 넣어줌  -->
			</ul>
		</div>
		<!-- 헤더 end -->

		<div class="kioskcontent">	<!-- 본문 : 제품출력/카트 출력 구역 -->
			<div class="productbox"> <!-- 제품구역 -->
				
				<!-- productPrint() 함수가 html 넣어줌 -->
				
			</div> <!-- 제품구역 end -->
			
			<div class="cartbox"> <!-- 카트구역 -->
				<div class="cartcontent"> <!-- 제품개수, 제품정보 출력 -->
					<div class="carttop">  <!-- 제품개수/총가격 -->
						<div>카트<span class="ccount">0</span></div>
						<div>총 주문금액 <span class="ctotal">0</span></div>
					</div> <!-- 제품개수/총가격 end -->
					
					<div class="cartbottom"> <!-- 제품정보 출력 구역 end -->
						
				<!--  cartPrint() 함구가 html 넣어줌-->
						

					</div> <!-- 제품정보 출력 구역 -->
				
				</div> <!-- 제품개수, 제품정보 출력 end-->
				
				<div class="cartbtn"><!-- 버튼 구역 -->
					<button onclick="cartCancel()" class="cancelbtn">취소하기</button>
					<button onclick="productOrder()" class="orderbtn">주문하기</button>
				</div> <!-- 버튼 구역 end -->
			</div> <!-- 카트구역 end-->
		</div>
		<!-- 본문 end -->
	</div>

	<%@include file="../footer.jsp"%>
	<script src="/frontendProject/js/kiosk.js"></script>
</body>
</html>