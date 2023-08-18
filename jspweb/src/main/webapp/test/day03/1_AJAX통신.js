console.log('js연결');

// 1. 예제1

function 예제1(){
	$.ajax({
		url : "http://localhost/jspweb/Test06",							
		data : {'value1' : 'jsdata'},							
		method : "get" ,						
		success : function 함수(result){
			console.log('서블릿 응답한 내용 ; '+result)
		} ,	
		error : function 함수(result){}		
	});
} // f end

// 1. 예제2
function 예제2(){
	// 1. 입력받은 데이터 가져온다
	let nameData = document.querySelector('.name').value;
	let ageData = document.querySelector('.age').value;
	// 2. 객체화
	let info = {
		name : nameData , 
		age : ageData
	}
	// 3. 객체를 자바(서블릿)에게 전달
	$.ajax({
		url : "http://localhost/jspweb/Test07" ,
		data : info ,
		method : "get" , 
		success : function 함수(r){console.log("통신성공");}
	});
	
} // f end

/*
	$.ajax();
	객체{} 타입의 속성 대입
	$.ajax({
		url : "",							-- 통신할 http 주소
		data : {},							-- 보내는 데이터
		method : "" ,						-- post , get , put , delete 
		success : function 함수(result){} ,	-- 통신 성공했을때 응답데이터를 result로 매개변수 받기
		error : function 함수(result){}		-- 통신 실패했을때 실패사유를 result로 매개변수받기
	});



*/