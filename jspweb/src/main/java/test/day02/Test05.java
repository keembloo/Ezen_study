package test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/Test05")
public class Test05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test05() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 게시물 DTO생성
		BoardDto boardDto = new BoardDto("제목2", "안녕하세요2");
		// DTO --> JSON 변환 [ js에게 데이터 전달하는데 js는 dto타입 몰라]
		// java가 문자열타입의 JSON모양 만들어서 JS에게 전달
		// 라이브러리 : jackson : 자바용 고성능 json 프로세서
		// jackson-annotations-2.14.2 , jackson-core-2.14.2 , jackson-databind-2.14.2
		// ObjectMapper 클래스 : JAVA객체를 JSON형식으로 변환해주는 함수들을 제공하는 클래스 
		 //.writeValueAsString(JAVA객체)  : 해당객체를 JSON 형식의 문자열로 반환 
		
		// 1. Dto --> JSon 변환 해주는 변환객체 [  - ObjectMapper ]
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(boardDto); // json 형식으로 변환할 객체 넣기
			System.out.println("자바 라이브러리 jackson : "+jsonData);
		// 2. 응답타입
		response.setContentType("application/json;charset=UTF-8");
		// 3. 응답 데이터
		response.getWriter().print(jsonData);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
