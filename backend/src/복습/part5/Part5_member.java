package 복습.part5;

public class Part5_member {
/*
 0. 저장

    Member 클래스 필드는  아이디 , 비밀번호 , 이름 , 전화번호 , 나이 5개 입니다.

   여러개 Member객체를 저장하기 위한 Member[] 객체배열 = new Member[100]; 선언합니다.

1. 초기 메뉴 [ 24시간 ]

    1. 회원가입 2.로그인

2. 조건 기능

     1. 회원가입

         1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이 각 입력받아 저장

         2. Member 객체화

          3. 객체를 배열 저장

     2. 로그인

          1. 아이디 , 비밀번호 입력받아 저장

          2. 입력받은 값과 배열내 동일한 값 찾기

          - 만약에 동일한 값 있으면 로그인 성공

          - 아니면 실패
 */
	// 1. 필드
	String id;
	String pw;
	String name;
	String phone;
	int age;

	
	// 2. 생성자

	public Part5_member(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	// 3 메소드
	
}
