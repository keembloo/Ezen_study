<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/member.css" rel="stylesheet">
</head>
<body>
	<%@include file ="../header.jsp" %>
	<div class="webcontainer"> <!-- 회원가입 전체 구역 -->
		<form class="signupForm"> <!-- 폼전송시 각 input에 name -->
			<h2>마이페이지</h2>
			
			<div class="intitle">프로필 변경</div>
			<input onchange="preimg( this )" name="mimg" class="mimg" type="file" accept="image/*" />
			<img class="preimg" alt="" src="img/default.webp"> 
			
			<div class="intitle">아이디</div>
			<div class="mid"></div> 
			
			<div class="intitle">이메일</div>
			<div class="memail"></div>
			
			<div class="intitle">기존 비밀번호</div>
			<input  maxlength="20" name="mpwd" class="mpwd" type="password">
			
			<div class="intitle">새로운 비밀번호</div>
			<input maxlength="20" name="newmpwd" class="newmpwd" type="password">
			<div class="pwcheckbox"></div>
			
			<button class="signupbtn" onclick="mupdate()" type="button">수정</button>
			<button class="signupbtn" onclick="mdelete()" type="button">탈퇴</button>
		</form>
	</div>
	
	
	<!-- 최신 JQUERY 불러오기 : AJAX 메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="../js/signup.js" type="text/javascript"></script>
	<script src="../js/info.js" type="text/javascript"></script>
	
</body>
</html>