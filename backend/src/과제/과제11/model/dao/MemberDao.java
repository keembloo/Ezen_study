package 과제.과제11.model.dao;



import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao  {
	// 0.싱글톤 객체
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {return memberDao;}
	private MemberDao() {}
	 
	
	// 1. 회원정보 체크 함수 : type=1 아이디중복체크 type=2 전화번호중복체크... // vs String 필드명
	public boolean infoCheck( String 검색할필드명, String 검색할값 ) {
		try {
			String sql = "select * from member where "+검색할필드명+" = ?";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.setString(1, 검색할값);
			rs = ps.executeQuery();
			if(rs.next()) {return true;} // 레코드 존재 => 이미 있는 데이터 => 중복
		}catch (Exception e) {System.out.println(e);}
		
		return false;
	}
	
	// 2. 회원가입SQL
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
	// 3. 로그인SQL
	public int loginSQL(String id , String pw) {
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
				return rs.getInt(1); // 검색된 회원번호(첫번째필드)를 반환
			} // if end
			
		} catch (Exception e) {System.out.println(e);}
		return 0; // 로그인 실패
	} // loginSQL end
	
		
	// 4.
	public String findById(String name , String phone) {
		try {
			//System.out.println("다오도착");
			// try {} 안에 예외가 발생할것 같은 , 일반예외 : JDBC , 파일처리 필수
			// 1단계 : sql 작성.
			String sql ="select mid from member where mname = ? and mphone = ?";
			// 2단계 : 작성된 sql를 조작할 PreparedStatment 객체를 연동객체로부터 반환
			ps = conn.prepareStatement(sql);
			// 3단계 : sql 조작 [매개변수 대입]
			ps.setString(1, name); // 1. sql문에 있는 첫번째 ? 에 name 변수 대입
			ps.setString(2, phone); // 2.sql문에 있는 두번째 ? 에 phone 변수 대입
			// select mid from member where member where mname = 입력된name and mphone = 입력된phone
			// 4단계 : sql조작 [ sql 실행 (select = executeQuery() , insert , update = executeUptate())]
			// 5단계 : sql 결과를 조작할 ResultSet 객체를 executeQuery 메소드로부터 반환
			rs = ps.executeQuery();
			// 6단계 : sql 결과 조작 
				// rs.next() : 검색된 여럿 레코드중 다음레코드 위치 이동 
				// rx.get타입( 검색필드 순서번호 )
					// rs.getString(검색필드순서번호) : 현재 위치한 레코드의 필드값 문자열 호출 
					// rs.getInt(검색필드순서번호) : 현재 위치한 레코드의 필드값 정수 호출 
			if(rs.next()) {return rs.getString(1); } // 검색된 레코드중 첫번째 필드인 id값을 반환
			// 만약에 *(전체)로 검색한다면 1번은 mno , 2번이 mdi 이기때문에 1이아니라 2번이 들어감
			
			
			
		} catch (Exception e) {System.out.println(e);}
		
		return null; // 실패
	}
	
	// 5.
	public String findByPw(String id , String phone) {
		//System.out.println("다오도착");
		try {
			String sql ="select mpw from member where mid = ? and mphone = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, phone);
			rs = ps.executeQuery();
			if (rs.next()) {return rs.getString(1);} // 검색된 레코드중 1번째 필드인 pw값을 반환
		} catch (Exception e) {System.out.println(e);}
		
		return null; //실패
	}
	
	// 6. 회원번호를 가지고 회원정보 찾기 / 회원번호가 존재하는 레코드 찾기
		public MemberDto info(int mno) {
			try {
				String sql ="select * from member where mno = ? ";// 1. SQL작성
				ps = conn.prepareStatement(sql); // 2. SQL 조작할 객체
				ps.setInt(1, mno); // 3. SQL조작
				rs = ps.executeQuery(); // 4. sql 실행 // 5. sql결과 조작 객체
				
				if(rs.next()) { // 6. sql결과 조작	// 만약에 다음 레코드가 존재하면
					// 현재 레코드 [필드순서 1: 회원번호 2:아이디 3:비밀번호 4:이름 5:전화번호]를 DTO로 만들기
					MemberDto dto = new MemberDto(
							rs.getInt(1), rs.getString(2), 
							rs.getString(3) , rs.getString(4), rs.getString(5));
					return dto;
				}
			} catch (Exception e) {	System.out.println(e);}
			return null; // 실패
		}
		
		// 7.
		public boolean infoUpdate(String newPw , int mno) {
			try {
				String sql = "update member set mpw = ? where mno = ? "; // 1.SQL 작성
				ps = conn.prepareStatement(sql); // 2. 작성한 SQL 조작할 객체
				ps.setString(1, newPw); ps.setInt(2, mno); // 3. SQL 조작
				int row = ps.executeUpdate(); // 4. SQL 실행 [ 업데이트한 레코드 개수 반환 ]
				if (row ==1) return true; // 성공
				
			} catch (Exception e) {
				System.out.println(e);
			}
			return false; //실패
		}
		
		// 8.
		public boolean infoDelete(int mno) {
			try {
				String sql ="delete from member where mno = ? ";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, mno);
				int row = ps.executeUpdate(); // [삭제한 레코드 개수 반환]
				if( row == 1) return true;
			} catch (Exception e) {
				System.out.println(e);
			}
			return false; // 실패
		}
} // class e
















