package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/Memberinfocontroller")
public class Memberinfocontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Memberinfocontroller() {
        super();

    }
    /*
    // 1. (첨부파일 없을때) 회원가입
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ajax 통신받은 data객체의 '속성명'으로 요청한다
    	String mid = request.getParameter("mid"); System.out.println("mid : "+mid);
    	String mpwd = request.getParameter("mpwd"); System.out.println("mpwd : "+mpwd);
    	String memail = request.getParameter("memail"); System.out.println("memail : "+memail);
    	String mimg = request.getParameter("mimg"); System.out.println("mimg : "+mimg);
    	// 2. (선택) 객체화
    	MemberDto memberDto = new MemberDto (mid, mpwd, memail, mimg);
    	// 2. (선택) 유효성검사
    	
    	
    	// 3. dao에게 전달하고 결과 받는다
    	boolean result = MemberDao.getInstence().signup(memberDto);
    	// 4. ajax 통신으로 결과 데이터를 응답을 보낸다 [리스폰]
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
	}
    */
    //1. (첨부파일 있을때 form ) 회원가입
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// ---------------------------------------------------------파일 업로드------------------------------------------------------ //
    	// 첨부파일 저장할 폴더의 절대경로
    	String uploadpath = "C:\\Users\\504\\git\\Ezen_study\\jspweb\\src\\main\\webapp\\member\\img"; 
    	
    	// 첨부파일 전송 했을때.
    		// 1. 첨부파일 서버PC에 업로드( COS.jar 라이브러리 )
    			// MultipartRequest : 파일 업로드 클래스
    	MultipartRequest multi = new MultipartRequest(
				request , 		// 1. HttpServletRequest 요청방식 
				uploadpath , 	// 2. 첨부파일을 저장할 폴더 경로 
				1024*1024*10,	// 3. 첨부파일 용량 허용 범위 [ 바이트단위 ] 10MB
				"UTF-8" , 		// 4. 한글인코딩타입 
				new DefaultFileRenamePolicy()	// 5. [파일명중복제거] 만약에 서버내 첨부파일의 동일한 이름이 있을때 이름뒤에 숫자를 자동으로 붙이기 
				);
    	
    	// ---------------------------------------------------------DB처리------------------------------------------------------ //
    		// 2. form 안에 있는 각 데이터 호출
    	// 일반input : multi.getParameter("form객체전송시 input name");
    	// 첨부파일 input : multi.getFilesystemName( );
    	
    	//request.getParameter("form 객체 전송시 input name");        	
    	String mid = multi.getParameter("mid"); System.out.println("mid : "+mid);
    	String mpwd = multi.getParameter("mpwd"); System.out.println("mpwd : "+mpwd);
    	String memail = multi.getParameter("memail"); System.out.println("memail : "+memail);
    	//String mimg =  multi.getParameter("mimg");		System.out.println("mimg : "  + mimg);
   		String mimg =  multi.getFilesystemName("mimg");		System.out.println("mimg : "  + mimg);
   		
   		
    	// 2. (선택) 객체화
    	MemberDto memberDto = new MemberDto (mid, mpwd, memail, mimg);
    	// 2. (선택) 유효성검사
    	
    	
    	// 3. dao에게 전달하고 결과 받는다
    	boolean result = MemberDao.getInstence().signup(memberDto);
    	// 4. ajax 통신으로 결과 데이터를 응답을 보낸다 [리스폰]
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

/*

	용량 단위
	
	bit : 0 or 1
	byte : 01010101 -> 1byte
	kb : 1024byte -> 1kb
	mb : 1024kb -> 1mb
	
*/
