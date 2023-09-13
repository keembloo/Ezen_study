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
			카테고리 : <select>
						<option value="1">스니커즈</option>
						<option value="2">샌들</option>
						<option value="3">로퍼</option>
						<option value="4">부츠</option>
					</select> <br/>
			제품명 : <input name="pname" type="text"> <br/>
			제품설명 : <textarea name="pcontent"></textarea> <br/>
			제품가격 : <input name="pprice" type="number"> <br/>
			<!-- 1. 첨부파일 1개일때 -->
			<!-- 제품이미지 : <input name="pimg" type="file"> <br/> -->
			<!-- 2. 첨부파일 여러개일때 -->
			제품이미지 : <input name="pimg" type="file" multiple="multiple"> <br/>
				<!-- multiple="multiple" 속성 사용시 cos.jar에서는 여러개 파일명 호출 불가능 -->
				<!-- 해결방안 : 1 . multiple="multiple" 사용하지 않고 input 여러개 사용 -->
				<!-- 해결방안 : 2. multiple="multiple" 사용하고  -->
			<button onclick="onRegister()" type="button">등록</button>
		</form>
	</div>

	<script src="/jspweb/js/product/register.js" type="text/javascript"></script>
</body>
</html>