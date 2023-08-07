package java1.day11.Ex5디자인패턴2.view;

import java.util.Scanner;

import java1.day11.Ex5디자인패턴2.controller.MemberController;
import java1.day11.Ex5디자인패턴2.model.dao.MemberDao;

public class MainPage {
	// 0. 싱글톤 생성 [ 디자인 패턴 ]
		// 1. 현재 클래스로 static 객체 생성
	private static MainPage mainPage = new MainPage();
		// 2. 외부 객체에서 해당 실클톤 호출하기 위한 메소드
	public static MainPage getInstance() { return mainPage; }
	// 3. 외부 해당 클래스로 객체 생성 잠금, 생성자를 private
	private MainPage() { }
	
	// 1. 필드
	private Scanner sc = new Scanner(System.in);
	// 2. 생성자
	// 3. 함수
	
	public void mainPage() {
		while(true) {
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			int ch = sc.nextInt(); 
			if( ch == 1 ) { singupPage(); }
			else if( ch == 2 ) { loginPage();} 
			else if( ch == 3 ) { findIdPage();} 
			else if( ch == 4 ) { findPwPage();} 
		} // w e 
	} // main e
	
	void singupPage() {
		sc.nextLine();
		System.out.println("--------------회원가입--------------");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		// --> 컨트롤러/서빙에게 전달 // 컨트롤 클래스내 메소드 호출
		boolean result = MemberController.getInstance().signupPage(id , pw , name , phone , age);
		if (result)System.out.println("회원가입성공");
		else System.out.println("회원가입실패");
	}
	
	void loginPage () {
		sc.nextLine();
		System.out.println("--------------로그인--------------");
		System.out.print("아이디 : ");
		String inputId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String inputPw = sc.nextLine();
		boolean result = MemberController.getInstance().loginPage(inputId,inputPw);
		if (result) { System.out.println("로그인 성공");}
		else {System.out.println("로그인실패");}
	}
	
	void findIdPage () {
		sc.nextLine();
		System.out.println("--------------아이디찾기--------------");
		System.out.println("이름과 전화번호를 입력하세요");
		System.out.print("이름 : ");
		String inputName = sc.nextLine();
		System.out.print("전화번호 : ");
		String inputPhone = sc.nextLine();
		int result = MemberController.getInstance().findIdPage(inputName , inputPhone);
		if (result>=0) {System.out.println("아이디 : " + MemberDao.memberList[result].getId());}
		else {System.out.println("일치하는 아이디가 없습니다 다시 확인해주세요");}
	}
	
	void findPwPage () {
		sc.nextLine();
		System.out.println("--------------비밀번호찾기--------------");
		System.out.println("아이디와 전화번호를 입력하세요");
		System.out.print("아이디 : ");
		String inputId = sc.nextLine();
		System.out.print("전화번호 : ");
		String inputPhone = sc.nextLine();
		String resultNum = MemberController.getInstance().findPwPage( inputId , inputPhone );
		if (resultNum !="") {System.out.println("임시 비밀번호 : "+resultNum);}
		else {System.out.println("일치하는 정보가 없습니다 다시 확인해주세요");}
	}

	
}
