package 과제.과제11.model.dao;


import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao  {
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {return memberDao;}
	private MemberDao() {}
	
	// 1. 회원가입SQL
	public void singnupSQL(MemberDto dto) {
		System.out.println("singnupSQL 다오 도착");
		System.out.println(dto);
		// 1. 회원강비 필요한 SQL을 문자열에 작성(여기는 SQL공간이 아니라서)해서 저장
			// 테이블에 레코드 삽입 : insert into 테이블명(필드명 , 필드명, 필드명) values (매개변수, 매개변수, 매개변수, 매개변수);
		String sql = "insert into member(mid , mpw , mname , mphone ) vlaues(?, ?, ?, ?)";
		try {
			// 2. 위에서 작성한 SQL를 DB연동객체에 대입  //conn.prepareStatement(sql);
			// 3. 대입된 SQL 조작하기 위해 반환된prepareStatement를 ps대입
			ps = conn.prepareStatement(sql); // db연동객체.prepareStatement( 조작할SQL문자열 )
			// conn, ps필드는 Dao 부모클래스에게 물려받음
			// 3. 대입한 SQL DB연동객체
			
			// 4. SQL에서 작성한 매개변수(?)에 대해 값 대입 [.setString ( ? 순서번호 , 값)]
			
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4, dto.getMphone());
			// 5. SQL실행			[ ps.ps.executeUpdate(); SQL실행
			ps.executeUpdate();
		} catch (Exception e) {System.out.println("경고 회원가입실패 사유 : "+e);}
	}
	// 2. 로그인SQL
	public void loginSQL(String id , String pw) {
		System.out.println("loginSQL 다오 도착");
		System.out.println(id+pw);
	}
}
