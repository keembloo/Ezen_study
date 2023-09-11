package controller.chatting;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dto.ClientDto;

@ServerEndpoint("/serversocket/{mid}") // 서버소켓 URL
public class ServerSocket {
	
	//0. 접속된 클라이언트소켓들의 저장소 [ 세션 , 아이디 저장 => ClientDto ]
	public static List<ClientDto> clientList = new Vector<>();
	
	// 1. 클라이언트소켓으로부터 접속 받았을때
	@OnOpen		// 매개변수 : 1. 접속된 클라이언트소켓(세션) 2.접속된 회원아이디
	public void onOpen( Session session , @PathParam("mid") String mid ) {
		System.out.println("클라이언트 소켓이 입장했습니다."+session);
		System.out.println("접속한 회원아이디 : "+mid);
		// 1-1 : 접속된 클라이언트소켓을 리스트에 저장
		ClientDto clientDto = new ClientDto(session, mid);
		
		clientList.add(clientDto);
		System.out.println("접속된 클라이언트들 : "+clientDto);
	}
	
	// 3.
	//@OnError
	
	// 4.
	//@OnClose
	
	
	// 2.
	@OnMessage		// 매개변수 : 1. 메세지를 보낸 클라이언트소켓(세션) 2.메세지 내용 [문자열]
	public void onMessage( Session session , String msg) throws IOException {
		System.out.println("보낸 클라이언트 : "+session );
		System.out.println("보낸 내용 : "+msg );
		// 2-1 받은 메시지를 접속된 회원들에게 모두 전송
		for( ClientDto clientDto : clientList ) { // 회원목록에서 하나씩 회원 꺼내기
			clientDto.getSession().getBasicRemote().sendText(msg); // 예외처리 필수! 
		}
	}
	

	
}



/*

	* WebSocket 서버소켓 라이브러리 제공
	 	1. 서버소켓 클래스 생성
	 		- 클래스위에 서버소켓 URL 만들기
	 		@ServerEndpoint("/serversocket")
	 		- 만약에 서버소켓의 URL 경로상의 매개변수를 받을때
	 		@ServerEndpoint("/serversocket/{매개변수명1}/{매개변수명2}")
	 	2. 서버소켓 메소드 제공
	 		- 메소드 매개변수의 규칙 존재
			@OnOpen
				public void onOpen( Session session ) {}
					- Session : 서버소켓에 접속된 클라이언트소켓의 정보
				public void onOpen( Session session , @PathParam("매개변수명1") 타입 매개변수명 ){}
				
			@OnClose
			@OnError
			@OnMessage
				public void onMessage( Session session , String msg) {}
				
				클라이언트소켓.getBasicRemote().sendText(msg)
*/
