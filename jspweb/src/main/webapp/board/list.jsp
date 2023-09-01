<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/board/list.css" rel="stylesheet">
</head>
<body>
	<%@include file ="../header.jsp" %>
	<div class="webcontainer">
		<button onclick="onWrite()" type="button">글쓰기</button>
		
		<table class="table">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>글작성일</th>
			</tr>
			
			<tr>
				<td>10</td>
				<td>하잉</td>
				<td>asdf9</td>
				<td>2023-09-01 13:51:23</td>
			</tr>
		</table>
	</div>






	<!-- 최신 JQUERY 불러오기 : AJAX 메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
</body>
</html>