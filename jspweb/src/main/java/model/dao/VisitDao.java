package model.dao;

import java.util.ArrayList;

import model.dto.VisitDto;

public class VisitDao extends Dao {
	// 싱글톤객체
	private static VisitDao visitDao = new VisitDao();
	public static VisitDao getInstence() {return visitDao;}
	private VisitDao() {}
	
	// 1. 저장 [ 인수 : 저장할내용이 담긴 dto , 리턴 : 성공/실패(boolean) = true/false ] 
	public boolean vwrite( VisitDto visitDto ) {
		// 0. try{} catch(){}
		try {
			String sql = "insert into visitlog (vwriter , vpwd , vcontent) values ( ? , ? , ? )"; // 1. SQL 작성
			ps = conn.prepareStatement(sql); // 2. SQL 연결
			ps.setString(1, visitDto.getVwriter()); // 3. SQL 매개변수 대입
			ps.setString(2, visitDto.getVpwd()); // 3. SQL 매개변수 대입
			ps.setString(3, visitDto.getVcontent()); // 3. SQL 매개변수 대입
			int row = ps.executeUpdate();	// 4. SQL 실행
			if(row==1)	return true; // 5. 결과 반환
			return false;
		} catch (Exception e) { System.out.println(e); }
		return false;
		
	}
	
	// 2. 호출 [ 인수 : x , 리턴 : 여러개(ArrayList)의 방문록dto = 모든 레코드 가져오기 ]
	public ArrayList<VisitDto> vread() {
		ArrayList<VisitDto> list = new ArrayList<>(); // 여러개 dto를 담을 리스트 객체
		try {
			String sql = "select * from visitlog order by vdate desc"; // 1. SQL 작성
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // s-> q , i/d/u->u 
			while( rs.next() ) { // rs.next() : select 검색결과중 다음레코드 이동 = 존재하면 true / 존재하지 않으면 false
				// 레코드/1줄/1행 / 1개 방문록 / 1개 dto
				// 레코드 -> dto 변환
				VisitDto visitDto = new VisitDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				//VisitDto visitDto = new VisitDto(
				//		rs.getInt("vno"), rs.getString("vwriter"), rs.getString("vpwd"), rs.getString("vcontent"), rs.getString("vdate"));
				// 여러개 dto를 저장할 리스트에 저장
				list.add(visitDto);
			}
		}catch (Exception e) { System.out.println(e); }
		return list;
	}
	
	// 3. 수정 [ 인수 : 수정할방문록번호(int)/수정할방문록내용(String)/비밀번호검토(String) , 리턴 : 성공/실패(boolean) = true/false ]
	public boolean vupdate( int vno , String vcontent , String vpwd ) {
		try {
			String sql ="update visitlog set vcontent = ? where vno = ? and vpwd = ?"; // 1. SQL 작성
			ps = conn.prepareStatement(sql); // 2. SQL 연결
			ps.setInt(2, vno);		// 3. SQL 매개변수 대입
			ps.setString(1, vcontent);
			ps.setString(3, vpwd);
			int row = ps.executeUpdate(); // 4. SQL 실행
			if( row == 1) return true;  // 5. SQL 실행 결과 따른 제어 
			return false;
		}catch (Exception e) { System.out.println(e);	}
		
		return false;
		}
	
	// 4. 삭제 [ 인수 : 삭제할방문록번호(int)/비밀번호검토(String) , 리턴 : 성공/실패(boolean) = true/false ]
	public boolean vdelete( int vno , String vpwd ) {
		try {
			String sql ="delete from visitlog where vno = ? and vpwd = ?"; // 1. SQL 작성
			ps = conn.prepareStatement(sql); // 2. SQL 연결
			ps.setInt(1, vno);		// 3. SQL 매개변수 대입
			ps.setString(2, vpwd);
			int row = ps.executeUpdate(); // 4. SQL 실행
			if( row == 1) return true;  // 5. SQL 실행 결과 따른 제어 
			return false;
		}catch (Exception e) { System.out.println(e);	}
			return false;
		}
	
}
