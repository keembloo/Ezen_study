package 과제.과제11.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제11.controller.BoardController;
import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.model.dto.MemberDto;

public class LoginPage {
	// 0.싱글톤
	private static LoginPage loginPage = new LoginPage();
	public static LoginPage getInstance() {return loginPage;}
	private LoginPage() {}
	
	// 0.입력객체
	private Scanner sc = new Scanner(System.in);
	// 1. loginMenu : 로그인했을때 메뉴 페이지
	public void loginMenu() {
		while(MemberController.getInstance().getLoginSession() !=0) { // 로그인이 되어있는 경우에만 메뉴 반복문
			System.out.println("\n\n ========= ========== ==========");
			System.out.print("1.로그아웃 2.회원정보 3.글쓰기 4.글조회 선택 : ");
			boardPrint();
			
			try {
				int ch = sc.nextInt(); 
				if(ch ==1) { MemberController.getInstance().logOut();}
				if(ch==2) {info();}
				if(ch==3) {boardWrite();}
				if(ch==4) {boardView();}
			}catch ( Exception e) {
				System.out.println("경고) 잘못 입력했습니다.");
				sc = new Scanner(System.in); 
			} // c end
		} // while e
	}
	
	// 2. info	: 로그인 회원정보 페이지
	public void info() {
		System.out.println("\n\n ========= info ==========");
		// 1. 컨트롤에게 회원정보 요청해서 1명의 회원정보[dto] 반환 받기
		MemberDto result = MemberController.getInstance().info();
		// 2. 반환받은 회원정보 객체[memberDto]의 각필드를 출력
		//System.out.println("아이디 : "+ result.id()); // DTO필드의 직접접근 불가
		System.out.println("아이디 : "+ result.getMid()); // getter or setter
		System.out.println("이름 : "+ result.getMname());
		System.out.println("전화번호 : "+ result.getMphone());
		
		// 2.서브메뉴
		System.out.print("1.비밀번호수정 2.회원탈퇴 3.뒤로가기 선택> ");
		int ch = sc.nextInt();
		if(ch==1) {infoUpdate();}
		if(ch==2) {infoDelete();}
		if(ch==3) {return;} // 생략가능
	}
	
	// 3. infoUpdate : 비밀번호수정 페이지
	public void infoUpdate() {
		System.out.println("\n\n ========= 비밀번호 수정 ==========");
		System.out.print("새로운 비밀번호  : "); 	String newPw = sc.next();
		boolean result = MemberController.getInstance().infoUpdate(newPw);
		if(result) {System.out.println("안내) 비밀번호수정완료 : 로그아웃됩니다.");
			MemberController.getInstance().logOut();
		}
		else {System.out.println("경고) 비밀번호수정실패 : 관리자에게 문의");}
	}
	
	// 4. infoDelete : 회원탈퇴 페이지
	public void infoDelete() {
		System.out.println("\n\n ========= 회원 탈퇴 ==========");
		System.out.println("정말 탈퇴하시겠습니까? 1:예 2.아니오 ");
		int ch = sc.nextInt();
		if(ch==1) {
			boolean result = MemberController.getInstance().infoDelete();
			if (result) {
				System.out.println("안내) 회원탈퇴성공 : 로그아웃됩니다.");
				MemberController.getInstance().logOut();
			} else {
				System.out.println("경고) 회원탈퇴실패 : 관리자에게 문의");
			}
		}
	}
	
	// 9. boardWrite : 게시물쓰기 페이지
	public void boardWrite() {
		System.out.println("------ 글쓰기 ------");
		sc.nextLine();
		System.out.print("제목 > "); String title = sc.nextLine();
		System.out.print("내용 > "); String content = sc.nextLine();
		
		boolean result = BoardController.getInstance().boardWrite(title, content);
		if (result) {System.out.println("글쓰기 성공");}
		else {System.out.println("글쓰기 실패 : 제목 1-50 사이로 필수 입력");}
	}
	// 10. boardPrint : 모든 게시물 출력
	public void boardPrint() {
		System.out.println("------ 게시물 리스트 ------");
		// 1. 여러개의 게시물을 요청해서 반환된 결과 저장
		ArrayList<BoardDto> result =
				BoardController.getInstance().boardPrint();
		// 2. 출력
		System.out.printf("%-3s %-4s %-19s %-10s %s \n", "no" , "view" , "date" , "mid" , "title");
		for (int i = 0; i<result.size(); i++) {
			BoardDto dto = result.get(i);	// i번째의 객체를 호출
			// 리스트.size() : 리스트내 객체수 => length 동일
			System.out.printf("%-3s %-4s %-19s %-10s %s \n", 
					dto.getBno() , dto.getBview() , dto.getBdate() , dto.getMid() , dto.getBtitle() );
		}
	}
	// 11. boardView : 개별 게시물 출력
	public void boardView() {
		System.out.println("------ 게시물 보기------");
		//1. 보고자하는 게시물의 게시물번호 입력 받기 [식별번호]
		System.out.print("게시물번호 : "); int bno = sc.nextInt();
		//2.
		BoardDto result = BoardController.getInstance().boardView(bno);
		//3. 출력
		System.out.printf("bno : %-3s view : %-3s mid : %-3s date %-19s ", 
				result.getBno() , result.getBview() , 
				result.getMid() , result.getBdate());
		System.out.printf("title : %s \n", result.getBtitle());
		System.out.printf("content : %s \n", result.getBcontent());
		
		// 4. 추가메뉴
		System.out.println("1.뒤로가기 2.수정 3.삭제 선택 >");
		int ch = sc.nextInt();
		if(ch==1) {}
		if(ch==2) {boardUpdate();}
		if(ch==3) {boardDelete();}
	}
	// 12. boardUpdate : 게시물 수정
	public void boardUpdate() {}
	// 13. boardDelete : 게시물 삭제
	public void boardDelete() {}
}



/*
  ArrayList<리스트에저장할타입> 리스트 객체명 = new ArrayList<>();
  	1. .size()		: 리스트내 객체수					=유사 result.length
  	2. .get(인덱스)	: 리스트내 인덱스번째의 객체 호출		=유사 result[i]
 
 */











