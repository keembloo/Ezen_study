<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file ="../header.jsp" %>

	<div class="webcontainer">
		<form class="registerForm">
			카테고리 : <select name="pcno">
						<option value="1">스니커즈</option>
						<option value="2">샌들</option>
						<option value="3">로퍼</option>
						<option value="4">부츠</option>
					</select> <br/>
			제품명 : <input name="pname" type="text"> <br/>
			제품설명 : <textarea name="pcontent"></textarea> <br/>
			제품가격 : <input name="pprice" type="number"> <br/>
			
			제품 장소 : <div id="map" style="width:300px;height:350px;"></div>
			<p><em>지도를 클릭해주세요!</em></p> 
			<div id="clickLatlng"></div>
			<!-- 1. 첨부파일 1개일때 -->
			<!-- 제품이미지 : <input name="pimg" type="file"> <br/> -->
			
			<!-- 2. 첨부파일 여러개일때 -->
			<!-- 제품이미지 : <input name="pimg" type="file" multiple="multiple"> <br/> -->
				<!-- multiple="multiple" 속성 사용시 cos.jar에서는 여러개 파일명 호출 불가능 -->
				<!-- 해결방안 : 1 . multiple="multiple" 사용하지 않고 input 여러개 사용 -->
				<!-- 해결방안 : 2. multiple="multiple" 사용하고  -->
				
			<!-- 3. 드래그앤드랍 -->
			<div class="fileDropBox" style="width: 200px; height: 200px; border: 1px solid red;">
				여기에 드래그해서 파일을 올려주세요.
				
				
				
				
			</div>
			
			
			<button onclick="onRegister()" type="button">등록</button>
		</form>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=753bfd065f78363879a5c2aa3ae45d7a"></script>
	<script src="/jspweb/js/product/register.js" type="text/javascript"></script>
</body>
</html>