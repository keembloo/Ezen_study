package model.dao;

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
	
	// 3. 아이디 찾기
	
	// 4. 비밀번호 찾기
	
	// 5. 내정보 호출
	
	// 6. 아이디/이메일 중복검사
	public boolean findId(String mid) {
		try {
			String sql ="select * from member where mid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			// [ while : 결과 레코드 여러개 검사 vs if : 결과 레코드 1개 검사 ]
			if (rs.next()) return true;  // true 는 중복 있음 / false 는 중복 없음
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 7. 회원수정
	
	// 8. 회원탈퇴
	
	
}
