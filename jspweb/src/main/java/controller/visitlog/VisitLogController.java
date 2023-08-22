package controller.visitlog;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.VisitDao;
import model.dto.VisitDto;


@WebServlet("/VisitLogController") // 해당 서블릿(자바)/컨트롤러 클래스를 호출하는 http 매핑주소
public class VisitLogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VisitLogController() {
        super();
    }
    
    // 1. 저장
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 1. AJAX의 DATA 속성에 있는 객체 정보를(속성명이용) 를 요청하기
    	//request.getParameter("객체의 속성명");
    	String vwriter = request.getParameter("vwriter"); System.out.println("vwriter"+vwriter);
    	String vpwd = request.getParameter("vpwd"); System.out.println("vpwd"+vpwd);
    	String vcontent = request.getParameter("vcontent"); System.out.println("vcontent"+vcontent);
    	//System.out.println(visitDto);
    	// 2. 객체화
    	VisitDto visitDto = new VisitDto(vwriter, vpwd, vcontent);
    	// 3. DAO 객체 전달후 결과 응답 받고
    	boolean result = VisitDao.getInstence().vwrite(visitDto);
    	// 4. 결과를 AJAX에게 응답한다
    	//response.getWriter().print("응답할데이터");
    	//response.setContentType("text/html;charset=UTF-8"); // (생략시 기본값) js에서 텍스트 "true"로 인식
    	response.setContentType("application/json;charset=UTF-8"); // js에서 true로 인식
    	response.getWriter().print(result);
    }
    
    // 2. 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 x : 모든글 출력은 조건이 없으므로 요청값 없다 . vs 개별글 출력 : 조건이 출력할 글 번호
		// 2. 객체화 x
		// 3. dao
		ArrayList<VisitDto> result = VisitDao.getInstence().vread();
			// js는 ArrayList 타입을 사용할수없으므로 JSON배열로 변환해서 전달 [ 라이브러리 : jackson ]
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result); // json 타입으로 변환은 불가능하지만 json형식의 문자열로 변환
		// 4. 응답
		//response.getWriter().print(result); // 응답은 가능하나 문자타입으로 전송되므로 js가 타입 사용 불가능 [ 문제 발생 ]
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}
	
	// 3. 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	// 4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
