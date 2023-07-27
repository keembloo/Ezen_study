package 과제.과제10;
						 // 현재 클래스에서 같은 패키지에 있는 클래스 호출 = 생략
						 // java.lang 기본 패키지이므로 생략 (String, System 등)
import java.util.Arrays; // 현재 클래스에서 다른 패키지에 있는 클래스 호출 = import
import java.util.Random; // 자동완성 이용해서 클래스 작성하면 import 자동
import java.util.Scanner;

import 과제.과제10.Member;
// vs
// import java.util.*; // 해당 패키지내 모든 클래스 호출

public class MemberSys {
	static Scanner sc = new Scanner(System.in); // 2. 모든 함수에서 사용 가능한 인스턴스 멤버
	// 프로그램내 전역구역에서 공유 사용되는 메모리 = 정적멤버
	// Member[] 객체배열 = new Member[100];				// 1. 인스턴스멤버		=힙영역		=new마다 할당	=> n개
	static Member[] memberList = new Member[100];	// 2. 정적멤버		=메소드영역	= 프로그램 전체 1개
	static int login = -1;		// 3. 정적멤버 = 메소드영역 = 로그인을 성공한 인덱스(회원위치) 기억
	
	public static void main(String[] args) { // main 함수에 static
		
		while(true) {
			// 확인용
			System.out.println("회원리스트 상태 : "+ Arrays.toString(memberList));
			
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			// 입력객체의 사용 구역 범위 생각!!!! [ 프로그램내 전역 = static ] 
			// 입력객체는 현재 { } 사용할건지 ... 모든 구역에서 사용할건지.. 다른 클래스에서도, 프로그램내 모든구역
			// Scanner sc = new Scanner(System.in); // 1.해당 main{ } 안에서만 사용되는 객체
			int ch = sc.nextInt(); 
			
			//if( ch == 1 ) { MemberSys sys = new MemberSys(); sys.회원가입 (); } // main함수 밖에 있는 다른 함수 호출
			// 1. 인스턴스멤버(static없는) 함수는 객체를 생성하고 호출한다.
			// 2. 정적멤버(static있는) 함수는 객체없이 클래스를 통한 호출한다.
			if( ch == 1 ) { 회원가입 (); }
			else if( ch == 2 ) { 로그인 (); } 
			else if( ch == 3 ) { 아이디찾기 (); } 
			else if( ch == 4 ) { 비밀번호찾기 (); } 
			
		} // w e 
	} // main e
	
	// 1. 회원가입 함수 : 입력받아 저장 [Create]
	//void 회원가입 () { // 인스턴트 멤버 = 객체 생성해서 할당후 사용
	static void 회원가입 () { 
		// 1. 입력받기 -> 각각 5개 입력받기 -> 묶음
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

		// 2. 5개 변수를 하나의 객체로 묶음	
			// 2. 2안
		Member member = new Member(id, pw, name, phone, age); // member 변수에는 힙주소 저장
		// 3. 회원의 1개의 객체를 배열 저장
			// 1. 배열내 빈공간=null을 찾는다
		for (int i=0; i<memberList.length; i++) {
			if (memberList[i]==null) {
				memberList[i]=member; 
				// System.out.println(memberList[i].id); 
				System.out.println("회원가입 성공");
				break;
			}
		} // for end
	} // 회원가입 e
	
	// 2. 로그인 함수 :입력받아 기존에 데이터와 일치하는지 비교 [Reading]
	static void 로그인 () { // 정적멤버 = 우선할당
		sc.nextLine();
		System.out.print("--------------로그인--------------");
		// 1. 입력받기 -> 각각 2개 입력받기
		System.out.println("아이디 : ");
		String inputId = sc.nextLine();
		System.out.println("비밀번호 : ");
		String inputPw = sc.nextLine();
		// 2. 입력받은 값이 배열내 존재하는지 찾기
		for (int i=0; i<memberList.length; i++) {
			if (memberList[i] != null && memberList[i].id.equals(inputId) &&  memberList[i].password.equals(inputPw)) {
				login = i; // 정적 멤버 변수에 로그인 성공한 인덱스를 넣어두기 -> 추후에 사용할 목적
				break;
			} // if end
		} // for end
		if (login >=0) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패 아이디와 비밀번호를 확인하세요");
		}
	} // 로그인 e
	
	// 3. 아이디찾기 함수 : 입력받아 기존에 데이터와 일치하는지 비교 [Reading]
	static void 아이디찾기 () {
		sc.nextLine();
		System.out.print("--------------아이디찾기--------------");
		System.out.println("이름과 전화번호를 입력하세요");
		System.out.println("이름 : ");
		String inputName = sc.nextLine();
		System.out.println("전화번호 : ");
		String inputPhone = sc.nextLine();
		
		for (int i =0; i<memberList.length; i++) {
			if (memberList[i] != null && memberList[i].name.equals(inputName) &&  memberList[i].phone.equals(inputPhone)) {
				System.out.println("아이디 : " + memberList[i].id);
				return; 	// 일치하는회원이 존재하면 아이디 출력후 함수 강제종료
			} // if end
		} // for end
		System.out.println("실패 ) 정보를 올바르게 입력해주세요");
		
	} // 아이디 찾기 e
	
	// 4. 비밀번호찾기 함수 : 입력받아 기존에 데이터와 일치하는지 비교 [Reading]
	static void 비밀번호찾기 () {
		sc.nextLine();
		System.out.print("--------------비밀번호찾기--------------");
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
				return;
			} 
		}
		System.out.println("실패 ) 정보를 올바르게 입력해주세요");
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
					
								// 1. 1안
		// Member m = new Member(); //빈 생성자
			// 1. member = { id = null , pw = null , name = null,  phone = null , age =0 }
		// m.id = id; m.pw = pw; m.name = name; m.phone = phone; m.age = age;   
*/














