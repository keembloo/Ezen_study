package java1.day11.Ex5디자인패턴2.view;

import java.util.Scanner;

public class MainPage {
	// 0. 싱글톤 생성 [ 디자인 패턴 ]
		// 1. 현재 클래스로 static 객체 생성
	public static MainPage mainPage = new MainPage();
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
		System.out.print("--------------회원가입--------------");
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
	}
	
	void loginPage () {}
	
	void findIdPage () {}
	
	void findPwPage () {}

	
}
