package hrm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HrmController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<HrmDto> result = HrmDao.getInstence().view();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result); // json 타입으로 변환은 불가능하지만 json형식의 문자열로 변환
		// 4. 응답
		//response.getWriter().print(result); // 응답은 가능하나 문자타입으로 전송되므로 js가 타입 사용 불가능 [ 문제 발생 ]
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadpath = request.getSession().getServletContext().getRealPath("/hrm/img");
    	System.out.println("hrm 폴더 img 폴더 실제(서버)경로 : "+uploadpath);
    	
    	MultipartRequest multi = new MultipartRequest(
				request , 		// 1. HttpServletRequest 요청방식 
				uploadpath , 	// 2. 첨부파일을 저장할 폴더 경로 
				1024*1024*10,	// 3. 첨부파일 용량 허용 범위 [ 바이트단위 ] 10MB
				"UTF-8" , 		// 4. 한글인코딩타입 
				new DefaultFileRenamePolicy()	// 5. [파일명중복제거] 만약에 서버내 첨부파일의 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙이기 
				);
    	
    	String himg = multi.getFilesystemName("himg"); 	System.out.println("himg : "+himg);
    	String hname = multi.getParameter("hname");		System.out.println("hname : "+hname);
    	String hphone = multi.getParameter("hphone");	System.out.println("hphone : "+hphone);
    	String hdate = multi.getParameter("hdate");		System.out.println("hdate : "+hdate);
    	String hlevel = multi.getParameter("hlevel"); System.out.println("hlevel : "+hlevel);
    	if(himg == null) {himg = "default.webp";}
    	
    	HrmDto hrmDto = new HrmDto (himg, hname, hphone, hlevel , hdate);
    	// 2. (선택) 유효성검사
    	
    	
    	// 3. dao에게 전달하고 결과 받는다
    	boolean result = HrmDao.getInstence().signup(hrmDto);
    	// 4. ajax 통신으로 결과 데이터를 응답을 보낸다 [리스폰]
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
