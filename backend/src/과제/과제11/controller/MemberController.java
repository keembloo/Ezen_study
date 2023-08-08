package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;
import 과제.과제11.view.MainPage;

public class MemberController {
	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() {return memberController;}
	private MemberController() {}
	 

	// 1. 회원가입 처리 [ 반환 : 1:성공 2:실패[db오류] 3:아이디중복실패 4:전화번호중복실패 ]
	public int signupLogic(String id , String pw , String name , String phone) {
		System.out.println("signupLogic컨트롤 도착");
		System.out.println(id +pw + name + phone);
		if(	MemberDao.getInstance().infoCheck("mid", id)) return 3; // 1. 아이디중복체크
		if(	MemberDao.getInstance().infoCheck("mphone", phone)) return 4; // 2. 전화번호 중복체크
		
		// 1. 객체화 : 5개 매개 변수들이 이동할때마다 매개변수의 코드 길어지니까 패키지화
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
			// 1. 회원가입시 회원번호는 자동[auto_intrement]이므로 필요없으므로 기본값 0
		// 2. Dao에게 전달하고  SQL 결과 받기
		boolean result = 
				MemberDao.getInstance().singnupSQL(dto);
		// 3. 결과를 view에게 전달
		if(result) return 1;
		else return 2;
	} // signupLogic end
	
	// 2. 로그인 처리
	public boolean loginLogic(String id , String pw) {
		System.out.println("loginLogic컨트롤 도착");
		System.out.println(id + pw);
		// 유효성검사했다치고		
		// 1. 매개 변수가 2개라서 객체화 해도되고 안해도 됨[선택]
		// 2. Dao 에게 전달
		boolean result = MemberDao.getInstance().loginSQL(id , pw);
		return result;
	} //loginLogic end
	
	
	// 4.
	public String findById(String name, String phone) {
		// - 테스트. view 전달받은 매개변수 확인
		System.out.println("view value :" + name + phone);
		
		// Dao에게 매개변수 전달하고 찾은 아이디 반환 받기
		String result = MemberDao.getInstance().findById(name , phone);
		return result;
		// if (result !=) {핸드폰문자전송함수}
		//return ; //실패
	}
	
	// 5.
	public String findByPw(String id , String phone) {
		// - 테스트. view 전달받은 매개변수 확인
		System.out.println("view value :" + id + phone);
		
		// Dao에게 매개변수 전달하고 찾은 아이디 반환 받기
		return MemberDao.getInstance().findByPw(id , phone);
		
		//return null; //실패
	}
} // class e

