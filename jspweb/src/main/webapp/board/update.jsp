<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/board/update.css" rel="stylesheet">
</head>
<body>
	<%@include file ="../header.jsp" %>
		<div class="webcontainer">
			<h3>글 수정 페이지</h3>
			<a href="list.jsp">목록보기</a>
			
			<form class="writeForm"> <!-- 쓰기 입력 구역 -->
				카테고리 : <select name="bcno" class="bcno"> 
							<!-- 게시물에 저장되는 카테고리정보는 카테고리이름X 카테고리번호 [FK] -->
							<option value="1"> 공지사항 </option> 
							<option value="2"> 자유게시판 </option> 
							<option value="3"> 노하우 </option> 
						</select>	<br/>
				제목 : <input type="text" name="btitle" class="btitle" > <br/>
				내용 : <textarea name="bcontent" class="bcontent"></textarea> <br/>
				<div class="oldfile"></div>
				첨부파일 : <input type="file" name="bfile" class="bfile"> <br/>
				
				<button onclick="onUpdate()" type="button">글수정</button> 
				<a href="list.jsp"> 목록보기 </a>
			</form>
		</div>
	
	
	
	
	<!-- 최신 JQUERY 불러오기 : AJAX 메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src="/jspweb/js/board/update.js" type="text/javascript"></script>
</body>
</html>