<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="webcontainer">
		<div>
			<h2>--카카오맵--</h2>
			<div class="detailbox">
			
			</div>
			<div id="map" style="width:1200px;height:500px;"></div>
		</div>
		
		<div>
			<h2>안산시 착한가격업소 현황</h2>
			<table class="apiTable1">
	
			</table>
		</div>
	</div>
	
	
	<!-- 카카오js -->
	
	   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=753bfd065f78363879a5c2aa3ae45d7a&libraries=clusterer"></script>
	<script src="/jspweb/js/datago/datago.js" type="text/javascript"></script>
</body>
</html>