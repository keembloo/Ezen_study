package 과제.과제11.model.dao;

import java.util.ArrayList;

import 과제.과제11.model.dto.BoardDto;


public class BoardDao extends Dao{

	// 0.싱글톤
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {return boardDao;}
	private BoardDao() {}
	
	// 9. boardWrite : 게시물쓰기 페이지
	public boolean boardWrite( BoardDto boardDto) {
		try {
			// 1.sql 작성
			String sql ="insert into board (btitle , bcontent , mno) values (? , ? , ?)";
			// 2. 작성한 sql 조작할 인터페이스 ps 객체 반환
			ps = conn.prepareStatement(sql);
			//3. sql 매개변수 대입 (조작)
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getMno());
			System.out.println(boardDto.getMno());
			//4. sql 실행 / 실행후 저장된 레코드 개수 반환
			int row = ps.executeUpdate();
			//5. 만약에 저장된 레코드수가 1개이면 성공
			if (row==1) return true;
		}catch (Exception e) {
			System.out.println(e);
		}
		return false; // 실패
		
	}
	// 10. boardPrint : 모든 게시물 출력
	// public BoardDto[] boardPrint() {
	public ArrayList<BoardDto> boardPrint() {
		ArrayList<BoardDto> list = new ArrayList<>(); // 여러개 BoardDto 를 저장할 리스트 객체 선언
		try {
			//String sql = "select * from board order by bdate desc"; // 1. 최신순[ desc 내림차순 ]으로 모든 게시물 호출
			String sql = "select b.* , m.mid from member m natural join board b order by b.bdate desc;"; // 1. 최신순[ desc 내림차순 ]으로 모든 게시물 호출
			
			ps = conn.prepareStatement(sql); // 2.
			// 3. SQL에 ?(매개변수)가 없으므로 set~~ 생략
			rs = ps.executeQuery(); // 4. 검색결과의 레코드를 여러개 조작하기 위해 resultSet 객체 반환
			// 5. 여러개 레코드 조회 [ rs.next() : 다음 레코드 이동(존재하면 true / 존재하지 않으면 false) ]
			while (rs.next()) { // 마지막 레코드까지 하나씩 레코드 이동 ( 다음 레코드가 존재하지 않을때까지 반복 )
				// 레코드 갯수만큼 반복문 돈다
				//* 레코드 1개마다 1개의 DTO 변환 
				//System.out.println(rs);
				BoardDto dto = new BoardDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
				// 변환된 DTO를 리스트 객체에 담기
				list.add(dto);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	// 11. boardView : 개별(1개) 게시물 출력
	public BoardDto boardView(int bno) {
		try {
			String sql="select b.* , m.mid from board b natural join member m where b.bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				// 레코드1개 --> Dto 변환
				BoardDto dto = new BoardDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
				boardViewCount(rs.getInt(1) , rs.getInt(5)); // 조회수 증가 함수 호출
				return dto;
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// 11-2 조회수 증가 함수
	public boolean boardViewCount(int bno , int bview) {
		try {
			String sql="update board set bview = ? where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ++bview); // 뒤에 ++ 넣으면 안되지....?
			ps.setInt(2, bno);
			int row = ps.executeUpdate(); // 바뀐 데이터의 갯수 반환
			if(row==1) {
				return true;
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		return false;
	}
	
	
	// 12. boardUpdate : 게시물 수정
	public void boardUpdate() {}
	
	// 13. boardDelete : 게시물 삭제
	public void boardDelete() {}
}


/*

 	테이블
 		레코드/행/가로
 		레코드/행/가로
 		레코드/행/가로
 		레코드/행/가로

	예)
		로그인한 회원정보 조회 = DTO
		관리자가 모든회원정보조회 = ArrayList<DTO>
		
		개별 게시물 1개 출력 = DTO
		모든 게시물 출력 = ArrayList<DTO>
		
		
		
	
 */