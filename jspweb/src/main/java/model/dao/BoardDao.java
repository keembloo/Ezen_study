package model.dao;

import model.dto.BoardDto;

public class BoardDao extends Dao{
	// 싱글톤 객체
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstence() {return boardDao;}
	private BoardDao() {}
	
	// 1. 글쓰기
	public boolean bwrite(BoardDto boardDto) {
		try {
			String sql="insert into board( btitle , bcontent , bfile , mno , bcno) values (? , ? , ? , ? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setString(3, boardDto.getBfile());
			ps.setInt(4, boardDto.getMno());
			ps.setInt(5, boardDto.getBcno());
			int row = ps.executeUpdate();
			if(row==1) 	return true;			
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 2. 모든 글 출력
	public void onView() {
		try {
			String sql="select bno , btitle , mid , bdate , bview from member natural join board order by bno desc";
			ps = conn.prepareStatement(sql);
			
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	// 3. 개별 글 출력
	
	// 4. 게시물 수정
	
	// 5. 게시물 삭제
	
	// 6. 조회수 증가
	
}
