<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="hrm.css" rel="stylesheet">
</head>
<body>

	<div class="wrap"> <!-- wrap 전체구역 -->
		
		<div class="containerbox">
			<h3>과제3 : 인사관리</h3>
			<form class="signupForm">
				<div class="enterbox">
					<div class="inputbox"> <!-- 입력구역 -->
						<div class="intitle">직원사진</div>
						<input onchange="preimg(this)" name="himg" class="himg" type="file" accept="imgage/*">
						<div class="intitle">직원명</div>
						<input maxlength="10" name="hname" class="hname" type="text">
						<div class="intitle">직원전화번호</div>
						<input maxlength="13" name="hphone" class="hphone" type="text">
						<select class="levelselect">
							<option value="사장">사장</option>
							<option value="부장">부장</option>
							<option value="팀장">팀장</option>
							<option value="대리">대리</option>
							<option value="주임">주임</option>
							<option value="사원">사원</option>
						</select>
						<div class="intitle">직원입사등록일(2023-08-01)</div>
						<input maxlength="10" name="hdate" class="hdate" type="text">
						<button class="signupbtn" onclick="signup()" type="button">직원등록</button>
					</div><!-- inputbox end -->
					<div class="preview"> <!-- 프로필이미지 미리보기 구역 -->
						<img class="preimg" alt="프로필이미지" src="img/default.webp">
						<div>사진 미리 보기</div>
					</div><!-- 프로필이미지 미리보기 구역 end -->
				</div> <!-- enterbox end -->
			</form>
		</div> <!-- containerbox end -->
	<!-- 
		<div class="viewbox"> 
			<div class="content_title">
				<div>직원번호</div>
				<div>사진</div>
				<div>직원명</div>
				<div>직원전화번호</div>
				<div>직급</div>
				<div>입사등록일</div>
			</div>
		
		
			<div class="content">
				<div>01</div>
				<div>사진경로</div>
				<div>아무개</div>
				<div>010-1234-1234</div>
				<div>사원</div>
				<div>2023-08-01</div>
			</div>
		</div>
	</div>
	 -->
 	<table class="viewbox">
 	
		
    </table>




	<!-- 최신 JQUERY 불러오기 : AJAX 메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src="hrm.js" type="text/javascript"></script>
</body>
</html>