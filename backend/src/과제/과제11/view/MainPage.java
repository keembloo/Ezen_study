package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;
 
public class MainPage {
	// 0. 싱글톤
	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance() {return mainPage;}
	private MainPage() {}
	//0. 입력객체
	private Scanner sc = new Scanner(System.in);
	
	// 1. 메인메뉴
	public void mainView() {
		while(true) {
			System.out.println("\n\n ========= 회원제 커뮤니티 ==========");
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 선택 : ");
			
			try {
				int ch = sc.nextInt(); // 만약에 타입과 일치하지 않는 값을 입력하면 InputMismatchException
				if(ch ==1) { signupView();}
				if(ch==2) {loginView();}
				if(ch==3) {findById();}
				if(ch==4) {findByPw();}
				
			}catch ( Exception e) {
				System.out.println("경고) 잘못 입력했습니다.");
				sc = new Scanner(System.in); // 입력객체의 메모리를 새롭게 만들어주기 
			} // c end
		} // while e
	} // main e
	// 2. 회원가입 화면
	public void signupView() {
		System.out.println("------ 회원가입 페이지 ------");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		// 2. 입력받은 값을 컨트롤에게 전달하고 결과 받기
		int result = 
				MemberController.getInstance().signupLogic(id , pw , name , phone);
		// 3. 결과에 따른 출력
		if ( result ==1 ) {System.out.println("안내) 회원가입 성공");}
		else if (result ==2){System.out.println("경고) 회원가입실패 관리자에게 문의");}
		else if (result ==3){System.out.println("경고) 회원가입실패 아이디중복");}
		else if (result ==4){System.out.println("경고) 회원가입실패 전화번호중복");}
	}
	// 3. 로그인 화면
	public void loginView() {
		System.out.println("------ 로그인 페이지 ------");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		boolean result =
				MemberController.getInstance().loginLogic(id , pw);
		if (result) {System.out.println("안내) 로그인 성공");
			// 만약에 로그인 성공하면 다른 view 클래스로 이동
			LoginPage.getInstance().loginMenu();
		}
		else {System.out.println("경고) 로그인실패");}
	}
	
	// 4. 아이디 찾기 
	public void findById() {
		System.out.println("------ 아이디찾기 페이지 ------");
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		String result = MemberController.getInstance().findById(name, phone);
		
		if (result !=null) {System.out.println("회원님의 아이디 : "+result);}
		else {System.out.println("경고) 정보가 일치하는 아이디가 없습니다.");}
	}
	
	// 5. 비밀번호 찾기
	public void findByPw() {
		System.out.println("------ 비밀번호찾기 페이지 ------");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		String result = MemberController.getInstance().findByPw(id, phone);
		if (result !=null) {System.out.println("회원님의 비밀번호 : "+result);}
		else {System.out.println("경고) 정보가 일치하는 아이디가 없습니다.");}
	}
}
