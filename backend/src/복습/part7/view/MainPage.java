package 복습.part7.view;

import java.util.Scanner;

import 복습.part7.controller.MemberController;

public class MainPage {
	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance() {return mainPage;}
	private MainPage() {}
	
	private Scanner sc = new Scanner(System.in);
	
	// 1. 메인메뉴
	public void main() {
		while(true) {
			System.out.print("1.회원가입 2.로그인 선택 :");
			
			try {
				int ch =sc.nextInt();
				if(ch==1) {signup();}
				if(ch==2) {login();}
				
			} catch (Exception e) {
				System.out.println(e);
				sc = new Scanner(System.in);
			}
		}
	}
	
	public void signup() {
		System.out.println("회원가입");
		System.out.print("아이디 : "); String id = sc.next();
		System.out.print("비밀번호 : "); String pw = sc.next();
		System.out.print("이름 : "); String name = sc.next();
		System.out.print("전화번호 : "); String phone = sc.next();
		System.out.print("전화번호 : "); int age = sc.nextInt();
		
		boolean result = MemberController.getInstance().signup(id , pw , name , phone , age);
	
	}
	
	public void login() {
		
	}
}
