package java1.day05;

public class Ex2_문자열 {
	public static void main(String[] args) {
		
		// [p.153]
		String name1 = "홍길동"; //10번지
		String name2 = "홍길동"; //10번지
			// ??? : 두 스택영역의 지역변수가 참조하는 주소는 같을까? 문자 리터럴 " "
		System.out.println( name1 == name2 );// 같다 true
		
		// [p.155]
		String name3 = new String("홍길동"); //11번지
		String name4 = new String("홍길동"); //21번지
			// " " : 리터럴이 아닌 new 연산자를 이용한 객체 생성시에는 같을까?
		System.out.println( name3 == name4 );// 다르다 false
		
		// [p.156]
		
		if(name1 == name2) { // " " 문자열리터럴 생성된 문자열객체 비교
			System.out.println("두 문자열 같습니다");
		} else {
			System.out.println("두 문자열 다릅니다");
		}
		
		if( name3 == name4) {
			System.out.println("두 문자열 같습니다");
		} else {
			System.out.println("두 문자열 다릅니다");
		}
		
		
		// [p.157] 문자열 내에서 특정 문자 추출/꺼내기
		String ssn = "9506241230123"; // 문자열 객체 선언 글자수13 인덱스0~12
		char sex = ssn.charAt(6); 		// 9[0]5[1]0[2]6[3] ~~~ 3[12]
		
		if(sex=='1' || sex =='3') System.out.println("남자입니다");
		else System.out.println("여자입니다");
		
		
		// [P.158] .length() 문자열의 길이구하기
		System.out.println("주민등록번호 길이 : " + ssn.length());
		
	}
	
}

/*
	자바 문자열 사용하는 방법
		1. String 변수명 = "문자열";
		2. String 변수명 = new String("문자열");
	자바 문자열에서 제공해주는 라이브러리=미리 만들어진 함수들
		문자열객체.메소드명()
		1. 문자열객체.equals( 문자열객체2 )		: 두 문자열객체내 문자열이 동일하면 true 아니면 false 반환 [주소x]
		2. 문자열객체.charAt( 인덱스 )			: 문자열내 해당 인덱스의 문자1개 추출 [첫번째 글자 = 인덱스 0]
		3. 문자열객체.length()					: 문자열에서 문자의 개수 반환 
			vs 배열명.length

 */