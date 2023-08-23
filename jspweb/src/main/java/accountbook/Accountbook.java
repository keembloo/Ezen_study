package accountbook;

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

@WebServlet("/Accountbook")
public class Accountbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Accountbook() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acontent = request.getParameter("content"); System.out.println("acontent"+acontent);
		int aprice = Integer.parseInt(request.getParameter("price")); System.out.println("aprice"+aprice);
		String adate = request.getParameter("date"); System.out.println("adate"+adate);
		
		AccountbookDto accountbookDto = new AccountbookDto(acontent, aprice, adate);
		boolean result = AccountbookDao.getInstence().cwrite(accountbookDto);
		
		response.setContentType("application/json;charset=UTF-8"); // js에서 true로 인식
    	response.getWriter().print(result);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AccountbookDto> result = AccountbookDao.getInstence().cread();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ano = Integer.parseInt(request.getParameter("ano")); System.out.println("ano"+ano);
		String acontent = request.getParameter("acontent"); System.out.println("acontent"+acontent);
		int aprice = request.getParameter("aprice"); System.out.println("aprice"+aprice);
		String adate = request.getParameter("adate"); System.out.println("adate"+adate);
		
		AccountbookDto accountbookDto = new AccountbookDto(ano, acontent, aprice, adate);
		boolean result = AccountbookDao.getInstence().cupdate(accountbookDto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ano = Integer.parseInt(request.getParameter("ano")); System.out.println("ano"+ano);
		boolean result = AccountbookDao.getInstence().cdelete(ano);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}
