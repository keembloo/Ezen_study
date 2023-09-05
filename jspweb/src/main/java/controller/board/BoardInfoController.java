package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.protocol.a.MultiPacketReader;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;
import model.dto.PageDto;

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
    // type : 1 . 전체조회 , 2.개별조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청
		String type = request.getParameter("type");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		
		if ( type.equals("1")) { // 전체 조회 로직
			// ---------------------1 카테고리 ------------------- //
			int bcno = Integer.parseInt(request.getParameter("bcno"));
			// ---------------------2 출력할 게시물수/하나의 페이지의 최대 게시물수 ------------------- //
			int listsize = Integer.parseInt(request.getParameter("listsize"));
			// ---------------------3 페이징 처리 하기 ------------------- //
			int page = Integer.parseInt(request.getParameter("page"));
				// 1. 페이지별 레코드의 시작번호
			int startrow = (page-1) * listsize;  // 페이지번호*최대게시물수
				// 1*10 => 10	0
				// 2*10 => 20	10
				// 3*10 => 30	20
			// ---------------------4 마지막 페이지번호 ------------------- //
				// 1 .마지막페이지번호 / 총페이지수 = 전체게시물수 / 페이지별 최대 게시물수 
				// 2. 전체 게시물수
			int totalsize = BoardDao.getInstence().getTotalSize(bcno);
				// 3. 마지막페이지번호/총페이지수
			int totalpate = totalsize%listsize == 0 ? 	// 만약에 나머지가 없으면
							totalsize/listsize : 		// 몫
							totalsize/listsize+1;		// 몫 +1
				// 게시물수 : 10 , 페이지별 2개씩 출력 => 총페이지수 5[몫]
				// 게시물수 : 20 , 페이지별 3개식 출력 => 총페이지수 6[몫] +1 나머지 2

			ArrayList<BoardDto> result = BoardDao.getInstence().onView(bcno , listsize , startrow);
			// ---------------------6 pageDto 구성 ------------------- //
			PageDto pageDto = new PageDto(page, listsize, startrow, totalsize, totalpate, result);
			
			
				// java 객체 => js객체형식[json]형식의 문자열로 변환
			json = objectMapper.writeValueAsString(pageDto);

		} else if (type.equals("2")) { //개별조회로직
			// 1. 매개변수 요청
			
			int bno = Integer.parseInt(request.getParameter("bno"));
			// 2. Dao처리
			BoardDto result = BoardDao.getInstence().getBoard(bno);
			
				// 3. 만약에 (로그인 혹은 비로그인 ) 요쳥한사람과 게시물작성한사람과 동일하면
			Object object = request.getSession().getAttribute("loginDto");
			if ( object == null ) { //비로그인
				result.setIshost(false); // 남이쓴글
			} else { // 로그인
				MemberDto login = (MemberDto)object;
				result.setIshost(true);
			}
			
			// 3. 응답
			json = objectMapper.writeValueAsString(result);
			
		}
		
		// 공통 로직
			// 1. 전체조회 , 개별조회하던 응답 로직 공통 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(json);
		
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

	// 3. 수정 
		protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 1. 수정할 첨부파일 업로드 
			MultipartRequest multi = new MultipartRequest(
					request,request.getServletContext().getRealPath("/board/upload"), 
					1024 * 1024 *1024 ,  "UTF-8" , new DefaultFileRenamePolicy() );
			
			// 2. 수정할 데이터 내용 요청 
			int bcno = Integer.parseInt( multi.getParameter("bcno") );
			String btitle = multi.getParameter("btitle") ;
			String bcontent = multi.getParameter("bcontent") ;
			String bfile = multi.getFilesystemName("bfile") ; // 파일명 호출 !![ getFilesystemName ]
			
			// 2* 수정할 게시물 식별키 
			int bno = Integer.parseInt( multi.getParameter("bno") );
			BoardDto updateDto = 
					new BoardDto(bno, btitle, bcontent, bfile, bcno); System.out.println("수정dto : " + updateDto );
			// * 만약에 수정할 첨부파일이 없으면 기존 첨부파일 그대로 사용
			if( updateDto.getBfile() == null ) {
				// 기존첨부파일 호출해서 수정dto에 저장하기.
				updateDto.setBfile( 
						BoardDao.getInstence().getBoard(bno).getBfile() 
						) ;
			}
			// 3. DAO
			boolean result = BoardDao.getInstence().onUpdate( updateDto );
			// 4. 응답 
			response.setContentType("application/json; charset=UTF-8"); 
			response.getWriter().print(result);
		}
		

	// 글삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		boolean result = BoardDao.getInstence().ondelete(bno);
		
		response.setContentType("application/json;charset=UTF-8");
    	response.getWriter().print(result);
	}

}
