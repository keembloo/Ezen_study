package 과제.과제11.model.dao;

import 과제.과제11.model.dto.MemberDto;

public class MemberDao {
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {return memberDao;}
	private MemberDao() {}
	
	// 1. 회원가입SQL
	public void singnupSQL(MemberDto dto) {
		System.out.println("singnupSQL 다오 도착");
		System.out.println(dto);
	}
	// 2. 로그인SQL
	public void loginSQL(String id , String pw) {
		System.out.println("loginSQL 다오 도착");
		System.out.println(id+pw);
	}
}
