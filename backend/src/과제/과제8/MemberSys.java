package 과제.과제8;

import java.util.Arrays;
import java.util.Scanner;

// 목적 : 실행
public class MemberSys {
	public static void main(String[] args) {
		
		// 0. 여러개 Member 객체 100개=100명 회원를 저장 예정인 배열 선언
		Member[] memberList = new Member[100];
		// 배열 선언 : 타입명[] 배열명 = new 타입명[길이];
				// 타입 : 기본타입(int,float 등),참조(String,직접만든클래스=Member 등)타입
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n\n--------------- 회원시스템 --------------");// 1. 무한출력
			System.out.print("1.회원가입 2.로그인    선택>");
			int ch = sc.nextInt();// 2. 무한입력
			
			System.out.println(Arrays.toString(memberList));
			// 3. 입력/선택 경우의수
			if (ch == 1) {
				System.out.println("------------- 회원가입 -------------");
				// 1. 각 입력받아 저장
				System.out.println("아이디 : "); String inputId = sc.next();
				System.out.println("비밀번호 : "); String inputPw = sc.next();
				System.out.println("이름 : "); String inputName = sc.next();
				System.out.println("전화번호 : "); String inputPhone = sc.next();
				System.out.println("나이(연령) : "); int inputAge = sc.nextInt();
				// 2. 5가지를 하나로 묶음 = 문자열 vs 객체
				// * 객체선언 : 클래스명 객체변수명 = new 생성자명();
				Member member = new Member(); 	// 필드에 기본값 들어가있음
				// * 객체내 필드 수정
				// * .(도트연산자) : 접근연산자 (스택변수가 알고잇는 객체주소로 가! )
				member.id = inputId;	member.password = inputPw;
				member.name = inputName;	member.phone = inputPhone;
				member.age = inputAge;
				//System.out.println(member); //주소값
				// 3. 여러개의 객체를 저장하기 위해 배열에 저장
					// * 비어있는 인덱스 = 기본값인덱스 찾아서 해당 인덱스에 객체 저장
				for (int i=0; i<memberList.length; i++) {
					// 만약에 i번째 인덱스에 null이면 해당 i번째 인덱스에 입력받아서 만든 객체 대입
					if(memberList[i] == null) {
						memberList[i]= member;
						break;
					}
				} // for end
			
			}// if end
			else if (ch == 2) {
				System.out.println("------------- 로그인 -------------");
			}
			
			
		} // while e
	} // main e
} // class e


/*
	주제 : 회원제 시스템
		0. 저장
			아이디 , 비밀번호 , 이름 , 전화번호
			* 5가지(서로다른타입) 필드 / 변수/ 데이터를 하나의 묶음방법
			--> 문자열 이용 : "아이디,비밀번호,이름,전화번호,나이" : , 쉼표 이용한 필드 구분
			--> 클래스(필드) 이용 :
				1. 클래스 설계 = 새로운 클래스.java 파일 생성
				2. 클래스 멤버 구성 : 필드 , 생성자 , 메소드
			* 하나로 묶인 (기준동일=타입동일) 여러개 저장???
			--> 문자열 배열 : String[] 문자열배열 = new String[100];
			--> 클래스 배열 : Member[] 객체배열 = new Member[100];
			
		1. 초기 메뉴
			1. 회원가입 2.로그인
			
		1. 조건 기능
			1. 회원가입
				1. 아이디, 비밀번호, 이름, 전화번호, 나이 각 입력받아 저장
				2. Member 객체화 
				3. 객체를 배열 저장
				
			2. 로그인
		
		
	회원가입,로그인


*/
