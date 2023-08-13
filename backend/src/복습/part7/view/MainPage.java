package 복습.part7.view;

import java.util.Scanner;

import 복습.part7.controller.MemberController;

public class MainPage {
	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance() {return mainPage;}
	private MainPage() {}
	
	private Scanner sc =new Scanner(System.in);
	
	public void mainPage() {
		while (true) {
			System.out.print("1.회원가입 2.로그인 입력 > ");
			int ch = sc.nextInt();
			if(ch ==1){signUp();}
			else if(ch==2) {login();}
			
		} //while e
	} // mainPage e
	
	void signUp() {
		System.out.println("회원가입페이지");
		System.out.print("아이디 : ");	String id = sc.next();
		System.out.print("비밀번호 : ");	String pw = sc.next();
		System.out.print("이름 : ");		String name = sc.next();
		System.out.print("전화번호 : ");	String phone = sc.next();
		System.out.print("나이 : ");		int age = sc.nextInt();
		
		boolean result = MemberController.getInstance().signUp( id, pw , name , phone , age);
		
		if (true) {System.out.println("회원가입 완료");}
		else {System.out.println("회원가입 실패");}
	}
	
	
	void login() {
		System.out.println("로그인 페이지");
		System.out.println("아이디 : "); 		String id = sc.next();
		System.out.println("비밀번호 : ");		String pw = sc.next();
		
		int result = MemberController.getInstance().login(id , pw);
		
		if (result ==1) {System.out.println("로그인 성공");}
		else if (result ==2) {System.out.println("로그인 실패");}
	}
} // class e
