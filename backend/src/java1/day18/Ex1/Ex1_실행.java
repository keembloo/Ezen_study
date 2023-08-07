package java1.day18.Ex1;

public class Ex1_실행 {
	public static void main(String[] args) {
		
		// 1. 인터페이스 타입의 변수 선언
		RemoteControl rc;
			// * 인터페이스만으로 객체 생성 불가능 [ 객체 생성하려면 추상메소드를 구현후 가능 ]
			// RemoteControl rc2 = new RemoteControl() {};
		
		// 2. 인터페이스 변수에 텔레비전 객체의 대입[주소대입]
		rc = new Television();
		// 구현객체 : 해당 추상메소드가 존재한 인터페이스를 구현해준 클래스로 객체 생성
		
		// 3. 인터페이스로 메소드 실행
		rc.turnOn();
		
		// 4. 리모컨을 오디오로 변경
		rc = new Audio();
		
		rc.turnOn();
		
		// 5. 리모콘의 상수필드 호출
		System.out.println("리모콘의 최대볼륨 : "+rc.MAX_VOLUEM);
		System.out.println("리모콘의 최저볼륨 : "+rc.MIN_VOLUEM);
		
		// 6. 메소드 실행
		rc.setVolume(100);
		
		// 7. 리모콘 교체
		rc = new Television();
		rc.setVolume(-10);
	}
}
