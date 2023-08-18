<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> AJAX 서블릿 통신 </h3>
	<H6>1. JS에서 servlet[자바웹클래스]에게 통신하고 데이터 보내기</H6>
	<button onclick="예제1()" type="button">예제1</button>

	<h6>2. [html입력받은] JS에서 servlet[자바웹클래스]에게 통신하고 데이터 보내기</h6>
	성명 : <input class="name" type="text"> <br>
	나이 : <input class="age" type="number"> <br>
	<button onclick="예제2()" type="button">예제2</button>

	<!-- 최신 JQUERY 불러오기 : AJAX 메소드 사용하기 위해 : JS가 외부로부터 통신하기 위해 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- ajax 사용하는 js -->
	<script src="1_AJAX통신.js" type="text/javascript"></script>
</body>
</html>