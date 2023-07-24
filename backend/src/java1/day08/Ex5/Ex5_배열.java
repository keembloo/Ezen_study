package java1.day08.Ex5;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5_배열 { // class s
	public static void main(String[] args) { // main s
	
		String[] memberList = new String[100]; // 100개 문자열 저장할수 있는 배열 선언
		
		while (true) { // 무한루프
			System.out.println(Arrays.toString(memberList)); // 배열내 데이터 확인
			// 1. 무한출력
			System.out.println("1.회원가입 : ");
			// 2. 무한입력
			Scanner sc = new Scanner(System.in);  // 1. scanner 객체 : Scanner 변수명 = new Scanner( System.in );
			int ch = sc.nextInt();  // 2. 객체 통한 메소드 호출해서 변수에 저장
			
			if(ch ==1) { // 만약에 ch가 1이면 
				System.out.println("아이디 : "); String id = sc.next();
				System.out.println("비밀번호 : "); String pw = sc.next();
				// 1. 하나의 문자열로 합치기
				String member = id+","+pw; // 쉼표(CSV)로 필드 구분
				// 2. 배열내 비어있는 인덱스 찾아서 대입
				for (int i=0; i<memberList.length; i++) {
					if(memberList[i]==null) { // 해당 인덱스가 비어있으면
						memberList[i] = member; // i번째 인덱스에 입력받은 문자열 대입
						break; //하나의 회원만 추가할 예정이므로 대입했으면 반복문 종료
					} // if end
				} // for end
			} // if end
		} // w end
		
	} // main e
} // class e
