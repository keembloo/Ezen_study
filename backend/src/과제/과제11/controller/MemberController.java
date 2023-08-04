package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;
import 과제.과제11.view.MainPage;

public class MemberController {
	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() {return memberController;}
	private MemberController() {}
	 

	// 1. 회원가입 처리
	public void signupLogic(String id , String pw , String name , String phone) {
		System.out.println("signupLogic컨트롤 도착");
		System.out.println(id +pw + name + phone);
		// 유효성검사 했다치고
		// 1. 객체화 : 5개 매개 변수들이 이동할때마다 매개변수의 코드 길어지니까 패키지화
		MemberDto dto = new MemberDto(0, id, pw, name, phone);
			// 1. 회원가입시 회원번호는 자동[auto_intrement]이므로 필요없으므로 기본값 0
		// 2. Dao에게 전달
		MemberDao.getInstance().singnupSQL(dto);
	} // signupLogic end
	// 2. 로그인 처리
	public void loginLogic(String id , String pw) {
		System.out.println("loginLogic컨트롤 도착");
		System.out.println(id + pw);
		// 유효성검사했다치고
		// 1. 매개 변수가 2개라서 객체화 해도되고 안해도 됨[선택]
		// 2. Dao 에게 전달
		MemberDao.getInstance().loginSQL(id , pw);
	} //loginLogic end
} // class e

