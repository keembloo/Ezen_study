package 과제.과제11.model.dao;


import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao  {
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {return memberDao;}
	private MemberDao() {}
	  
	// 1. 회원가입SQL
	public boolean singnupSQL(MemberDto dto) {
		System.out.println("singnupSQL 다오 도착");
		System.out.println(dto);
		// 1. 회원강비 필요한 SQL을 문자열에 작성(여기는 SQL공간이 아니라서)해서 저장
			// 테이블에 레코드 삽입 : insert into 테이블명(필드명 , 필드명, 필드명) values (매개변수, 매개변수, 매개변수, 매개변수);
		String sql = "insert into member(mid , mpw , mname , mphone ) values(?, ?, ?, ?)";
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
			// 6. 리턴 [ 회원가입성공 = true / 회원가입 실패 = false ]
			return true;
		} catch (Exception e) {System.out.println("경고 회원가입실패 사유 : "+e);}
		// 6. 리턴 [ 회원가입성공 = true / 회원가입 실패 = false ]
		return false;
	}
	// 2. 로그인SQL
	public boolean loginSQL(String id , String pw) {
		//System.out.println("loginSQL 다오 도착");
		//System.out.println(id+pw);
		try {
			// 1단계 : SQL 작성한다 [ 추천 : MYSQL워크벤치에서 임의의값으로 테스트하고 ]
			String sql = "select mid , mpw from member where mid = ? and mpw = ?";
			// 2단계 : SQL 조작할수 잇는 객체 필요하므로 prepareStatement 반환받기
			ps = conn.prepareStatement(sql);
			// 3단계 : SQL 조작 [SQL안에 있는 매개변수[?]에 값 대입 ]
			ps.setString(1, id);
			ps.setString(2, pw);
			// 4단계 : SQL 실행해서 그 결과객체를 rs객체에 대입 [  *ps는 결과를 조작할 수 없다 ]
			// [ insert : ps.executeUpdate(); / select : executeQuery(); ]
			rs = ps.executeQuery();
			// 5단계 : SQL 실행 결과 조작	[ rs.next() : 결과중에서 다음 레코드객체 호출 ]
				//  만약에 검색 결과의 레코드 3개 [ rs = null -> 레코드1객체 -> 레코드2객체 -> 레코드3객체 ]
				// 								.next()		.next()	  .next()
			if( rs.next() ) { // 로그인SQL은 결과레코드가 1개 또는 0개 이므로 if 사용해서 .next() 1번 호출해서
								// .next() 다음레코드가 존재하면 true / false
				return true; // 로그인성공
			} // if end
		} catch (Exception e) {System.out.println(e);}
		return false; // 로그인 실패
	} // loginSQL end
} // class e
