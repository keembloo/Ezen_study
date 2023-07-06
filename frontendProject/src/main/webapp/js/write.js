console.log('write.js실행');

// 1. 썸머노트 실행할때 사용되는 코드
$(document).ready(function() {
//  $('#summernote').summernote( {설정객체});
	$('#summernote').summernote({
		lang : 'ko-KR' , // 한글적용 [ 한글.JS CDN 필요]
		height: 500 ,
		placeholder: '여기에 내용작성'
	});
});
//------------------------------------------

// 로그인제 게시판 [ 로그인 했다는 가정하에 로그인된 아이디를 가정하에 변수에 저장 ]
let loginId = '1234';
/* 
	JS는 HTML에서 포함된 문서
	- html 새로고침[F5] / 페이지전환[a태그] 되면 js도 재호출 => 메모리 휘발성
	- 영구적인저장 [ 서버 담당 = DB ] 
	- 브라우저 저장소 : 1.세션 2.쿠키 
		세션 : 모든 브라우저 꺼지면 초기화
		쿠키 : 모든 브라우저/OS 꺼져도 유지	/ 직접 쿠키 삭제하기 전까지 유지 / 보안이 필요한 데이터 사용x
		
	- 사용방법 = JS에서 객체 제공 = 키와 값으로 이루어진 객체 
		- 문자형으로 저장됨 !!!!!!!!!!!
		
		sessionStorage : 세션
			sessionStorage.setItem('데이터이름' , 데이터)	: 해당 값을 '키'라는 이름으로 저장
			sessionStorage.getItem('데이터이름')			: 해당 키를 호출하면 저장된 값 호출
			sessionStorage.clear()
			
		localStorage : 쿠키
			localStorage.setItem('데이터이름' , 데이터)
			localStorage.getItem('데이터이름' , 데이터)
			localStorage.clear()
		
		
		clear()
		
		
 */


// 1. 등록함수 [ 실행조건 : 등록버튼 클릭했을때 ]
function onWrite(){
	 // 1. 입력받은 값을 가져온다
	 let title = document.querySelector('.title').value;
	 let content = document.querySelector('#summernote').value;
	 console.log(title);
	 console.log(content);
	 // 유효성 검사한다
	
	 // 2. 입력받은 값이 여러개이면 객체화
	 let board = {
		 title : title ,  // 입력받은 값 넣기
		 content : content , // 입력받은 값 넣기
		 no : 1 , 		// 게시물 번호 [ 마지막게시물 +1 ]
		 date : `${new Date().getFullYear()}-${new Date().getMonth()+1}-${new Date().getDate()}` ,
		 view : 0 , // 게시물 조회수 기본값이 0부터 시작
		 like : 0 ,	// 게시물 추천수 기본값이 0부터 시작
		 writer : loginId // 게시물 작성자 [로그인된 아이디]
	 };
	 console.log(board);
	 
	 // 3. 해당 객체/변수를 배열에 저장한다.
	
		// 함수 {}안에 선언된 배열 : 지역변수
		// 함수{}밖에 선언된 배열 : 전역변수
		// 세션(서버pc) / 쿠키(사용자pc) : JS외 저장 가능하다. -> JS 새로고침해도 유지 	 
	sessionStorage.setItem('세션' , 1);
	localStorage.setItem('쿠키' , 2);
	
	console.log(sessionStorage.getItem('세션'))
	console.log(localStorage.getItem('쿠키'))
}; // f end























