package test.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test04")
public class Test04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Test04() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. JSON타입 모양의 문자열 [ - 자바는 JSON이 없음 ]
		String jsonData = "{ \"title\" : \"제목1\" , \"content\" : \"안녕하세요\" }";
			// " " 문자열 처리 안에 "문자인식 => \"
		System.out.println("자바[String타입]에서의 JSON모양 만들기 : " +jsonData);
		// 1. JSON 타입
		response.setContentType("application/json;charset=UTF-8");
		//response.setContentType("text/html;charset=UTF-8");
		// 2. 전송/응답할 데이터
		response.getWriter().print(jsonData);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
