// 1. 테스트
//setPoint(1000 , "회원가입축하");
//setPoint(-500 , "회원가입축하");
getPoint();
getPointList();
// 1. 포인트 사용 함수 [ mno는 서블릿이 로그인세션에 알고있다 ]
function setPoint(mpamount , mpcomment){
	if(loginState == false){
		return;
	}
	$.ajax({
		url : "/jspweb/PointController" ,
		method : "post" ,
		data : { mpamount : mpamount , mpcomment : mpcomment } , 
		success : result => {console.log(result);} ,
		error : e=> {console.log(e);}
	})
}

// 2. 내 포인트 확인 함수
function getPoint(){
	$.ajax({
		url : "/jspweb/PointController" ,
		method : "get" ,
		data : {type : "findByPoint"} , 
		success : result => {console.log(result);} ,
		error : e=> {console.log(e);}
	})
	
}

// 3. 내포인트 내역 전체 출력 함수
function getPointList(){
	$.ajax({
		url : "/jspweb/PointController" ,
		method : "get" ,
		data : {type : "findByAll"} , 
		success : result => {console.log(result);} ,
		error : e=> {console.log(e);}
	})
}

