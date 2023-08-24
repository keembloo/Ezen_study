package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;


@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberFindController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청
		String mid = request.getParameter("mid");
		// 2. 객체/유효성
		// 3. dao요청결과
		boolean result = MemberDao.getInstence().findId(mid);
		// 4. 응답
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}



}
