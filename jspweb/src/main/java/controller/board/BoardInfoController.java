package controller.board;

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

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;

/**
 * Servlet implementation class BoardInfoController
 */
@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardInfoController() {
        super();
    }

    // 전체글출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BoardDto> list = new BoardDto
				
				
		ArrayList<BoardDto> result = BoardDao.getInstence().onView();
	}

	// 글등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("연결완료");
		//첨부파일 업로드 [cos.jar -> MultipartRequst 클래스 ]
		MultipartRequest multi = new MultipartRequest(
				request, // 요청방식
				request.getServletContext().getRealPath("board/upload") , // 저장경로
				1024*1024*1024 ,// 업로드허용요량[바이트] 1GB
				"UTF-8" , // 인코딩타입
				new DefaultFileRenamePolicy() // 만약에 업로드파일명이 서버내 존재하면(중복) 자동으로 파일명뒤에 숫자 붙이기
				);
		// 업로드가 잘 되었는지 확인하기 위한 업로드 서버경로 확인
		System.out.println(request.getServletContext().getRealPath("board/upload"));
		
		// 1. (입력받은 매개변수) 요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile"); // 첨부파일명은 .getFilesystemName
		
			// 작성자 mno는 입력 x / mno 는 세션에 저장되어 잇는 상태
		int mno = ((MemberDto) request.getSession().getAttribute("loginDto")).getMno();
		int bcno = Integer.parseInt( multi.getParameter("bcno"));
		
		// 2. 유효성검사/객체화
		BoardDto boardDto = new BoardDto(btitle, bcontent, bfile, mno, bcno);
		//System.out.println(boardDto);
		// 3. dao처리
		boolean result = BoardDao.getInstence().bwrite(boardDto);

		// 4. dao결과 응답
    	response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);

	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
