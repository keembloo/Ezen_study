
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