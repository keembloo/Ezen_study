package controller.sample;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/Sample")
public class Sample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Sample() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		
		if ( type.equals("1")) { // 타입 1 이면

			
		} else if ( type.equals("2")) { // 타입 2 이면
			String slat = request.getParameter("slat");
			String slng = request.getParameter("slng");
			String elat = request.getParameter("elat");
			String elng = request.getParameter("elng");
		} else if ( type.equals("3")) { // 타입 3 이면
			int pno = Integer.parseInt(request.getParameter("pno"));
			
		} else if ( type.equals("4")) { // 타입 4 이면
			int page = Integer.parseInt(request.getParameter("page"));
			int listsize = Integer.parseInt(request.getParameter("listsize"));
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
