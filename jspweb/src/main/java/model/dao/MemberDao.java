package model.dao;

import java.time.LocalDateTime;

import model.dto.MemberDto;

public class MemberDao extends Dao{
	// 싱글톤 객체
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstence() {return memberDao;}
	private MemberDao() {}
	
	
	// 1. 회원가입
	public boolean signup(MemberDto memberDto) {
		try {
			String sql ="insert into member( mid , mpwd , memail , mimg ) values(? , ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			ps.setString(3, memberDto.getMemail());
			ps.setString(4, memberDto.getMimg());
			int row = ps.executeUpdate();
			if( row == 1) return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 2. 로그인
	public boolean login (String mid , String mpwd) {
		try {
			String sql ="select * from member where mid = ? and mpwd =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			rs = ps.executeQuery();
			if (rs.next()) return true;
		}catch (Exception e) { System.out.println(e);}
		return false;
	}
	// 3. 아이디 찾기
	
	// 4. 비밀번호 찾기
	
	// 5. 내정보 호출
	public MemberDto info( String mid ) {
		try {
			String sql = "select mno, mid , memail, mimg from member where mid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if ( rs.next()) {
				MemberDto memberDto = new MemberDto(
						 LocalDateTime.now().toString() ,  // LocalDateTime.now().toString() : 현재 날짜/시간 문자열 반환 함수
						 rs.getInt(1), rs.getString(2), 
						 rs.getString(3), rs.getString(4));
				return memberDto;
			}
		}catch (Exception e) { System.out.println(e);}
		return null;
	}
	
	
	
	// 6. 아이디/이메일 중복검사
	// - type(mid,memail) : 필드명 / data(입력받은mid , 입력받은memail) : 필드에서 찾을 값 
	public boolean findIdOrEmail(String type , String data) {
		try {
			String sql ="select * from member where "+type+" = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			// [ while : 결과 레코드 여러개 검사 vs if : 결과 레코드 1개 검사 ]
			if (rs.next()) return true;  // true 는 중복 있음 / false 는 중복 없음
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 7. 회원수정
	public boolean mupdate( int mno , String mimg , String mpwd , String newmpwd ) {
		try {
			String sql ="update member set mimg = ? , mpwd = ? where mno = ? and mpwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mimg);
			ps.setInt(3, mno);
			ps.setString(2, newmpwd);
			ps.setString(4, mpwd);
			int count = ps.executeUpdate();
			if(count==1) {
				return true;
			}
		}catch (Exception e) { System.out.println(e);}
		return false;
	}
	
	// 8. 회원탈퇴 [ 삭제할회원번호 , 검증할패스워드 ]
	public boolean mdelete( int mno , String mpwd) {
		try {
			String sql="delete from member where mno = ? and mpwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setString(2, mpwd);
			int count = ps.executeUpdate();
			if (count==1) {return true;} // 삭제성공 -> 회원탈퇴
		}catch (Exception e) { System.out.println(e); }
		return false; // 회원번호 또는 입력받은 패스워드 일치하지 않거나
	}
	
}
