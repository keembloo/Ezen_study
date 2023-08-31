package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberFindController() {
        super();
    }

    // 하나의 메소드의 여러개 ajax 통신할때. type전송 ( 1: 아이디중복검사 2: 이메일 중복검사 vs 필드명 : mid : 아이디중복검사 , memail : 이메일중복검사 )
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청
		String type = request.getParameter("type");
		String data = request.getParameter("data");
		// 2. 객체/유효성
		// 3. dao요청결과
		boolean result = MemberDao.getInstence().findIdOrEmail( type , data );
		// 4. 응답
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
	}

	// 로그인
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 매개변수 요청
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		
		// 2. (객체화/유효성검사)
		
		// 3. Dao에게 전달후 결과 받기
		boolean result = MemberDao.getInstence().login(mid, mpwd);
	
		// - 만약에 로그인 성공하면 세션에 로그인한 정보를 담기
		if ( result==true) {
			// 1. 세션에 저장할 데이터를 만든다
			MemberDto loginDto = MemberDao.getInstence().info(mid);
			// 2. 세션에 [로그인 성공한 회원의 정보(loginDto)] 저장한다
			request.getSession().setAttribute("loginDto", loginDto );
			// 세션 상태 확인
			MemberDto dto = (MemberDto)request.getSession().getAttribute("loginDto");
			System.out.println("세션 상태 : "+dto);
			
		}
		
		// 4. 결과를 응답한다.
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(result); 

	}

}

/*
  
 	- 저장소
 		1. JAVA/JS 메모리
 			- JAVA 종료되거나 JS 종료/페이지전환/새로고침 되면 휘발성/초기화/사라짐
 			- DTO 이동객체 , 로직 필요한 변수들 (생성조건에 따라 사용범위가 다름)
 		
 			세션(static)
 				- 장점 : 모든 곳에서 동일한 메모리 (동일한 주소값) 사용
 				- 단점 : 프로그램/서버가 종료될때까지 유지( 메모리 )
 				- 로그인정보 : 페이지 전환 되더라도 로그인상태 유지
 				
 		2. DB 메모리
 			- 영구저장 [ 논리구조(관계형/표) 저장]
 			- 회원정보, 게시판정보, 제품정보 등등
 			- 실제 데이터 
 			
 		3. 파일
 			- 영구저장 [문자열저장]
 			- log(로그/기록) 예외처리 오류정보 , 최상위 보안 자료
 			- 실제 데이터
 			
 		
 			
 		
	로그인 했다는 증거 => 인증 [ 인증서 -> 세션 저장 ]
		- 세션 : 미리 만들어진 전역메모리 / 변수
		
		JS : sessionStorage		: 모든 JS에서 사용가능한 메모리 공간 
			세션타입 : 문자열 타입 ( 타입변환 필수! )
			세션저장 : sessionStorage.setItem( 키 , 데이터 );
			세션호출 : sessionStorage.getItem( 키 );
			
		JAVA(서블릿) : request.getSession()	: 모든 서블릿에서 사용가능한 메모리 공간
			- 세션 타입 : Object ( 타입변환 필수! )
			세션저장 : request.getSession().setArrtibute("속성명", 데이터);
			세션호출 : request.getSession().getArrtibute( "속성명" );
			세션내 속성초기화
				방법1 : (세션의 모든 속성) 초기화하는 함수
				request.getSession().invalidate(); // 로그인 정보뿐만 아니라 모두 삭제
				 
				방법2 : (세션의 특정 속성) JVM GC(쓰레기수집기 = 해당 객체를 아무도 참조하고 있지 않으면 알아서 삭제) 
				request.getSession().setAttribute("초기화할속성명", null); //삭제할 세션속성명과 동일하게 null 대입 
		
	서블릿
		내장객체
			request : 요청
				request.getParameter() 					  : ajax로부터 전달된 데이터 요청
				request.getServletContext().getRealPath() : 서블릿 저장소의 실제(c:) 경로 검색
				request.getSession()					  : 서버내 세션객체 호출
				
				
			response : 응답객체
				response.getWriter().print()	: ajax에게 전달할 데이터 응답
				response.setContentType("application/json;charset=utf-8"); [ 데이터 타입 설정 ]
				response.setContentType("text/html;charset=utf-8"); [ 데이터 타입 설정 ]
				
				
 */











