
// * ajax(기본값 비동기통신)가 응답의 결과를 가지고 오기전에 아래코드 실행 [ loginState 변경되기전에 실행되므로 문제발생 ]
// - 해결방안 ajax 동기화 통신으로 바꾸기

// 1. 비로그인시 입장 불가능
if(loginState == false ){ 
	alert('회원전용 페이지입니다.'); 
	location.href="/jspweb/member/login.jsp";
}
// 2. JS 클라이언트[유저] 소켓 만들기
console.log('채팅방에 입장한 아이디 : '+ loginMid);
let clientSocket = new WebSocket(`ws://localhost:8080/jspweb/serversocket/${loginMid}`);
	// - 클라이언트 소켓이 생성되었을때 자동으로 서버소켓에 접속 ---> 서버 소켓의 @OnOpen
	// - 서버소켓URL에 매개변수 전달하기 [ - 주로 식별자 전달 ] 서버소켓URL/데이터1/데이터2/데이터3
	// --- 메소드 4가지 메소드 자동으로 실행
		// 1.(자동실행) 클라이언트소켓이 정상적으로 서버소켓 접속했을때
	clientSocket.onopen = e => {console.log('서버와 접속 성공')};
		// 2.(자동실행) 클라이언트소켓이 서버소켓과 연결에서 오류가 발생했을때
	clientSocket.onerror = e => {console.log('서버와 오류 발생'+e)};
		// 3.(자동실행) 클라이언트소켓이 서버소켓과 연결이 끊겼을때
	clientSocket.onclose = e => {console.log('서버와 연결 끊김'+e)};
		// 4.(자동실행) 클라이언트소켓이 메세지를 받았을때
	clientSocket.onmessage = e => onMsg(e);
	
	
// 3. 서버에게 메시지 전송
function onSend(){
	let msg = document.querySelector('.msg').value;
	if (msg == '' ){
		alert('내용을 입력해주세요');
		return;
	}
	// 3-2 메시지 전송
	clientSocket.send(msg); // 클라이언트소켓과 연결된 서버소켓에게 메시지 전송 -> 서버소켓의 @OnMessage 로 이동
}
	
// 4. 메세지를 받았을때 추후행동 ( 메소드 )선언
function onMsg(e){
	console.log(e);
}
	
	
/*
	JS[ HTML파일 종속된 파일 - HTML 안에서 실행되는 구조 ]
	
	* 클라이언트 : 사용 데이터 요청하는 pc
	  서버 : 데이터 제공하는 pc
		
	* URL[주소] 상의 매개변수 전달하는 방법
		1. 쿼리스트링 방식 : URL?매개변수명1=데이터1&매개변수명2=데이터2&매개변수명3=데이터3	
		2. 경로매개변수 : URL/데이터1/데이터2/데이터3
		
	* 소켓이란
		- 통신의 종착점[데이터가 전달되는 위치 -받는사람 - 보낸사람]
		
	* WebSocket 클라이언트 웹소켓 라이브러리
		* 소켓 관련된 함수들을 제공하는 클래스 
		1. 웹소켓 객체 생성
			new WebSocket("ws://ip주소:port번호/프로젝트명/서버소켓경로");
		
		2. 메소드 제공 
			.send() : 클라이언트소켓이 연결된 서버소켓에게 메시지를 전송 메소드
			
			
	* 동기화 vs 비동기화
	
	동기화 : 요청1 결과에 다른 다음 요청이 필요할때
	
	비동기화 : 여러기능을 별도로 처리할때 [유튜브 시청하면서 댓글도써야함]
	
*/







// ----------------------------------------------------------------------------------
/*
// 1. 클라이언트 소켓 만들기

	// 1. JS웹소켓 객체 [ WebSocket클래스 ] / 객체가 생성되면 서버소켓에 자동으로 접속됨
		// new WebSocket('ws://ip주소:포트번호/프로젝트명/서버소켓 URL'); [ 객체생성 ===> 서버소켓 @OnOpen ]
	let 클라이언트소켓 = new WebSocket('ws://localhost:8080/jspweb/ChattingSocket');
	console.log(클라이언트소켓);
		// 2. onopen , onclose , send , onmessage
		
		// 내가만든 함수를 클라이언트소켓 속성에 대입
	클라이언트소켓.onmessage = (e) => onmsg(e);
		
	// 2. 연결된 서버소켓에게 메세지 보내기
function msgsend(){
	// 1. input입력된 값 가져오기
	let msg = document.querySelector('.inputcontent').value;
	// 2. 클라이언트소켓 .send();
	클라이언트소켓.send(msg); // input에서 입력받은 데이터를 보내기
	// 3.
	document.querySelector('.inputcontent').value='';
	
} // f end

	// 3. 연결된 서버소켓으로부터 메세지를 받았을때
function onmsg(e){	
	console.log(e);
	console.log(e.data);

	document.querySelector('.contentbox').innerHTML +=
					`<div>${e.data}</div>`;
}

*/
/*
 
 	1. AJAX
 	
 		발신자(보내는사람)  : AJAX
 		수신자(받는사람)	: 서블릿
 	
 		JS				JAVA[서블릿]
		
		AJAX
 				rest	get
 						post
 						put
 						delete
 
 	2. (웹) 소켓
 		소켓 : 통신의 종착점[도착위치]
 		
 		JS					JAVA
 		[클라이언트소켓]		[서버소켓]
 		websocket
 		1. 서버소켓 접속 		2. 서버소켓 24시간 상시 클라이언트 소켓 명단
 		3. 데이터 전송			4. 24시간 데이터 받는다
*/