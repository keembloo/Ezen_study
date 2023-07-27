package 과제.과제10;

public class Member {
	// 1.필드 : 객체의 데이터를 저장하는 곳 = 인스턴스 vs 정적멤버static
	String id;
	String password;
	String name;
	String phone;
	int age;
	
	// 2.생성자 : 객체의 초기화를 담당 역할 = 인스턴스 vs 정적멤버static
		// 1. 빈생성자
	public Member() { }
		// 2. 모든 필드를 저장하는 풀생성자
	//클래스내 빈공간을 오른쪽 클릭 -> Source -> Generate Constructor using Fields -> 모든필드 체크후 생성
	public Member(String id , String password , String name , String phone, int age) { // 1. 매개변수 5개 정의한 생성자
		this.id = id; this.password = password; this.name = name; this.phone = phone; this.age = age;
	}
		// 3. 특정 개수 필드를 저장하는 생성자 -> 추후에 필요하면 선언
	
	// 3.메소드 : 객체의 행동을 담당 역할 = 인스턴스 vs 정적멤버static
	
		// 1. setter or getter
	
		// 2. toString : 객체호출시 객체의 주소가 아닌 필드의 값을 반환해주는 함수 [ * 개발자가 객체 상태 확인용 ]
	//클래스내 빈공간을 오른쪽 클릭 -> Source -> Generate String -> 모든필드 체크후 생성
	
	@Override
	public String toString() { // 객체의 주소값 대신 필드 문자형식으로 반환
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", age=" + age
				+ "]";
	}
	
}
