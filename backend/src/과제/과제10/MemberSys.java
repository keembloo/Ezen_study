package 과제.과제10;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import 과제.과제10.Member;

public class MemberSys {
	static Scanner sc = new Scanner(System.in);
	static Member[] memberList = new Member[100];
	
	public static void main(String[] args) {
		
		while(true) {
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			int ch = sc.nextInt(); 
			
			if( ch == 1 ) { 회원가입 (); }
			else if( ch == 2 ) { 로그인 (); } 
			else if( ch == 3 ) { 아이디찾기 (); } 
			else if( ch == 4 ) { 비밀번호찾기 (); } 
			
		} // w e 
	}
	
	static void 회원가입 () {
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

		
		Member member = new Member(id, pw, name, phone, age);
		for (int i=0; i<memberList.length; i++) {
			if (memberList[i]==null) {
				memberList[i]=member; 
				// System.out.println(memberList[i].id); 
				break;
			}
		} // for end
	} // 회원가입 e
	
	static void 로그인 () { 
		int login = 0;
		sc.nextLine();
		System.out.println("아이디 : ");
		String inputId = sc.nextLine();
		System.out.println("비밀번호 : ");
		String inputPw = sc.nextLine();
		for (int i=0; i<memberList.length; i++) {
			if (memberList[i] != null && memberList[i].id.equals(inputId) &&  memberList[i].password.equals(inputPw)) {
				login = 1;
				break;
			} // if end
		} // for end
		if (login >0) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패 아이디와 비밀번호를 확인하세요");
		}
	} // 로그인 e
	
	static void 아이디찾기 () {
		int find = 0;
		sc.nextLine();
		System.out.println("이름과 전화번호를 입력하세요");
		System.out.println("이름 : ");
		String inputName = sc.nextLine();
		System.out.println("전화번호 : ");
		String inputPhone = sc.nextLine();
		
		for (int i =0; i<memberList.length; i++) {
			if (memberList[i] != null && memberList[i].name.equals(inputName) &&  memberList[i].phone.equals(inputPhone)) {
				System.out.println("아이디 : " + memberList[i].id);
				find++;
				break;
			} 
		}
		if(find==0) {
			System.out.println("실패 ) 정보를 올바르게 입력해주세요");
		}
	} // 아이디 찾기 e
	
	static void 비밀번호찾기 () {
		int find = 0;
		sc.nextLine();
		System.out.println("아이디와 전화번호를 입력하세요");
		System.out.println("아이디 : ");
		String inputId = sc.nextLine();
		System.out.println("전화번호 : ");
		String inputPhone = sc.nextLine();
		
		for (int i =0; i<memberList.length; i++) {
			if (memberList[i] != null && memberList[i].id.equals(inputId) &&  memberList[i].phone.equals(inputPhone)) {
				Random random = new Random(); // 랜덤함수선언
				int num = 0; // 1자리 난수
				String ranNum = ""; // 1자리 형변환 변수
				int letter = 4; // 4자리수
				String resultNum = ""; //결과난수
				for (int j=0; j<letter; j++) {
					num = random.nextInt(9); // 0부터 9까지 생성 
					ranNum = Integer.toString(num); // 1자리 난수 형변환
					resultNum += ranNum;
				}
				System.out.println("임시 비밀번호 : " + resultNum);
				memberList[i].password = resultNum;
				find++;
				break;
			} 
		}
		if(find==0) {
			System.out.println("실패 ) 정보를 올바르게 입력해주세요");
		}
	}
	
}
/*
	주제 : 회원제 시스템 
		0. 회원클래스 설계 = Member
			아이디 , 비밀번호 , 이름 , 전화번호 , 나이
		0. Member 객체를 여러개 저장하는 배열 
			Member[] 객체배열 = new Member[100];
		
		1. 초기 메뉴 [ 24시간 ]
			1. 회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
			
		2. 조건 기능 
			1. 회원가입 메소드 
				1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이  각 입력받아 저장 
				2. Member 객체화
				3. 객체를 배열 저장 
				 
			2. 로그인 메소드
				1. 아이디 , 비밀번호 입력받아 저장 
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 로그인 성공 
					- 아니면 실패
					 
			3. 아이디찾기 메소드
				1. 이름 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 찾은 아이디 출력 
					- 아니면 없다.
					 
			4. 비밀번호찾기 메소드 
				1. 아이디 , 전화번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 *임시 비밀번호(문자4자리 난수생성 ) 업데이트후 출력 
					- 아니면 없다.
*/














