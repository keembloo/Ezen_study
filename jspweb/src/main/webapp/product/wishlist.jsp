<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/product/wishlist.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
	<%@include file ="../header.jsp" %>

	<div class="container"> <!-- bs : container 디바이스 크기에 다른 반응형 구역 -->
	
		<table class="table table-hover table-striped text-center align-middle"> <!-- bs : table 테이블에 기본css 적용된 테이블 / text-center : 수평정렬 / align-middle : 수직정렬 -->
			<tr>
				<th width="5%"> <input class="checkbox" type="checkbox"> </th>
				<th width="5%"> 이미지 </th>
				<th width="40%"> 제품 정보 </th>
				<th width="10%"> 가격 </th>
				<th width="10%"> 비고 </th>
			</tr>
			
			<tr>
				<td><input class="checkbox" type="checkbox"></td>
				<td><img src="/jspweb/product/img/manbo.png" width="100%"></td>
				<td>신발팜</td>
				<td>252,153원</td>
				<td><button type="button">X</button></td>
			</tr>
			
			<tr>
				<td><input class="checkbox" type="checkbox"></td>
				<td><img src="/jspweb/product/img/manbo.png" width="100%"></td>
				<td>신발팜</td>
				<td>252,153원</td>
				<td><button type="button">X</button></td>
			</tr>
			
		</table>
		
		<div class="selectbtn">
			<button class="btn btn-secondary" type="button">선택 삭제</button>
			<button class="btn btn-secondary" type="button">전체 삭제</button>
		</div>
		<div class="buybtn">
			<button class="btn btn-warning" type="button">선택 구매</button>
			<button class="btn btn-warning" type="button">전체 구매</button>
		</div>
	</div>
	


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=753bfd065f78363879a5c2aa3ae45d7a&libraries=clusterer"></script>
	<script src="/jspweb/js/product/wishlist.js" type="text/javascript"></script>
</body>
</html>