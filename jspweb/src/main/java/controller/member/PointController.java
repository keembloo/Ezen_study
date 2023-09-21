package controller.member;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;
import model.dto.MpointDto;

/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PointController() {
        super();
    }

    // 10 , 11 -- 하나의 함수에서 2개이상의 기능 처리 type 분류
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 서로 다른 함수/기능을 실행하기 위한 분류
		String type = request.getParameter("type");
		// - 공통
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		// 2. 분류
		if ( type.equals("findByPoint")) { // 현재 포인트 출력 
			long result = MemberDao.getInstence().getPoint(mno);
			//System.out.println("컨트롤러실행");
			json = mapper.writeValueAsString(result);
		} else if (type.equals("findByAll")) { // 포인트내역 전체 출력 
			//System.out.println("컨트롤러실행");
			List<MpointDto> result = MemberDao.getInstence().getPointAll(mno);
			json = mapper.writeValueAsString(result);
		}
		response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(json);
	}

	// 9.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("컨트롤러연결");
		String mpno = UUID.randomUUID().toString(); 	// 포인트내역 식별번호 구성 [ uuid ]
			//1.  UUID.randomUUID() : (s)스태틱 UUID 고유성을 구보장하는 ID[식별자] 만들기위한 표준규약 
			//System.out.println(mpno);
			
			// 2. 회원번호를 서블리세션에서 꺼내옴
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
	
			// 3. 포인트수량 / 지급내역 
		long mpamount = Long.parseLong(request.getParameter("mpamount"));
		String mpcomment = request.getParameter("mpcomment");
		
		// --Dto
		MpointDto mpointDto = new MpointDto(mpno, mno, mpamount, mpcomment, null);
		
		// --Dao
		boolean result = MemberDao.getInstence().setPoint(mpointDto);
		response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
