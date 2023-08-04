package 과제.과제11.controller;

import 과제.과제11.view.MainPage;

public class MemberController {
	private static MemberController memberController = new MemberController();
	public static MemberController getInstance() {return memberController;}
	private MemberController() {}
	

	// 1. 회원가입 처리
	public void signupLogic() {System.out.println("signupLogic컨트롤 도착");}
	// 2. 로그인 처리
	public void loginLogic() {System.out.println("loginLogic컨트롤 도착");}
}

