<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/jspweb/css/board/list.css" rel="stylesheet">
</head>
<body>
	<%@include file ="../header.jsp" %>
	<div class="webcontainer">
		<div class="boardtop">
			<h2>게시판</h2>
			<p> 다양한 사람들과 정보를 공유하세요 </p>
		</div>
		<!-- 2. 상단구역 -->
		<div class="boardtopetc">
			<div>
				<select class="bbtn listsize" onchange="onListSize()"> <!-- 하나의 페이지에 표시할 최대 게시물수 -->
					<option>10</option>
					<option>15</option>
					<option>20</option>
				</select>
				<span class="boardcount"> </span> <!-- 전체 게시물 수  -->
			</div>
			<button class="bbtn" onclick="onWrite()" type="button">글쓰기</button>
		</div>
		<!-- 3. 카테고리 구역 -->
		<div class="boardcategorybox">
			<button onclick="onCategory(0)" class="bbtn" type="button">전체보기</button>
			<button onclick="onCategory(1)" class="bbtn" type="button">공지사항</button>
			<button onclick="onCategory(2)" class="bbtn" type="button">자유게시판</button>
			<button onclick="onCategory(3)" class="bbtn" type="button">노하우</button>
		</div>
		
		<!-- 4. 테이블 구역 -->
		<table class="table">
			<tr> <!-- 테이블 제목 -->

			</tr>
			
			<tr> <!-- 테이블 내용 -->

			</tr>
		</table>
		
		<div class="boardbottom">
			<!-- 5. 페이징처리 구역 -->
			<div class="pagebox">

			</div>
			
			<!-- 6. 검색 구역  -->
			<select class="bbtn key"> <!-- 검색 키워드 -->
				<!-- value는 sql에서 사용할 필드명 기준 -->
				<option value="b.btitle">제목</option>
				<option value="b.bcontent">내용</option>
				<option value="m.mid">작성자</option>
			</select>
			<input class="keyword" type="text"> <!-- 검색내용 -->
			<button onclick="onSearch()" class="bbtn" type="button">검색</button>
		</div>
	</div>






	<!-- 최신 JQUERY 불러오기 : AJAX 메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
</body>
</html>