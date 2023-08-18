console.log('1_AJAX통신.js Open');

//1.예제1
function 예제1(){console.log('예제1() Open');
	// ajax 메소드 이용한 서블릿과 통신
		// $.ajx( { } );
		// { url }
		
	 $.ajax({
		 // url : "http://localhost/jspweb/Test02",
		 url :"/jspweb/Test02", 
		 method : "get",
		 success : function 함수명(result){console.log(result);}
	  });
}
function 예제2(){console.log('예제2() Open');
	 $.ajax({
		// url : "http://localhost/jspweb/Test03",
		 url :"/jspweb/Test03",
		 method : "get",
		 success : function 함수명(result){console.log(result);}
	  });
}

function 예제3(){console.log('예제3() Open');
	 $.ajax({
		 // url : "http://localhost/jspweb/Test04",
		 url :"/jspweb/Test04",
		 method : "get",
		 success : function 함수명(result){console.log(result);
		 console.log(result.title); console.log(result.content);
		 }
	  });
}

function 예제4(){console.log('예제4() Open');
	 $.ajax({
		 // url : "http://localhost/jspweb/Test05",
		 url :"/jspweb/Test05",
		 method : "get",
		 success : function 함수명(result){console.log(result);
		 console.log(result.title); console.log(result.content);
		 }
	  });
}

/*
	 $.ajx({
		 url : "통신할경로/서블릿주소" , 
		 method : "통신방법" : get , post , put , delete 선택 ,
		 success : function 함수명( 통신반환변수 ){ 통신성공했을때 실행코드 } ,
		 error : function 함수명( 통신반환변수 ){ 통신실패했을때 실행코드 }
	  });

	- 1. success/error 속성에서 통신 결과의 반환값 받는 함수 작성시
		1. succeess : function 함수명(통신반환변수){통신성공했을때 실행코드}
		2. succeess : function(통신반환변수){통신성공했을때 실행코드}
		3. succeess : (통신반환변수) => {통신성공했을때 실행코드}
		
		
 
	-----------------------------------------------------
	 서블릿
	 	- request : 요청 객체
	 	- response : 응답 객체 
	 		- response.getWriter().print() 		: 웹 출력 = 응답데이터
	 		- response.setContentType("전송할데이터타입명;인코딩탕입")  		: 출력할 데이터의 타입 혹은 인코딩
	 		- 1. 문자전송 [ default ]
	 			response.setContentType("text/html;charset=UTF-8");
 			- 2. JSON전송
 				response.setContentType("application/json;charset=UTF-8");
 				
	 -----------------------------------------------------	
	 JACKSON :
	 	
	 		
*/