package model.dao;

public class BoardDao extends Dao{
	// 싱글톤 객체
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstence() {return boardDao;}
	private BoardDao() {}
	
	// 1. 글쓰기
	
	// 2. 모든 글 출력
	
	// 3. 개별 글 출력
	
	// 4. 게시물 수정
	
	// 5. 게시물 삭제
	
	// 6. 조회수 증가
	
}
