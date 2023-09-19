<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/product/view.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
	<%@include file ="../header.jsp" %>

	<div class="webcontent">
		<div class="productBox">
			<!-- 캐러셀 -->
			<div id="carouselExample" class="carousel slide"> <!-- 캐러셀 : 이미지슬라이드 -->
			  <div class="imgbox carousel-inner"> <!-- 캐러셀 안에 넣을 이미지 목록구역 -->
			   
			    
			  </div>
			  <!-- 왼쪽 이동 버튼 -->
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <!-- 오른쪽 이동 버튼  -->
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>

			<div>판매자 : ㅇㅇㅇ</div>
			<div>
				카테고리 : <span>스니커즈</span>
				등록일 : <span>2023-09-19 11:47</span>
			</div>
			<div>제목 : 스니커즈119</div>
			<div>가격 : 1232543원</div>
			<div>내용 : 최신유행하는 국민템 없으면 아쉬움</div>
			<div>
				<button type="button">찜하기♥</button>
				<button type="button">바로구매</button>
			</div>
		</div>
	
	</div>



	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=753bfd065f78363879a5c2aa3ae45d7a&libraries=clusterer"></script>
	<script src="/jspweb/js/product/view.js" type="text/javascript"></script>

</body>
</html>