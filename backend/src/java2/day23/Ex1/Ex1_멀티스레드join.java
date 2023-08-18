package java2.day23.Ex1;

public class Ex1_멀티스레드join {
	public static void main(String[] args) {
		// main스레드가 main함수 호출
		System.out.println("현재스레드이름 : "+Thread.currentThread().getName());
		
		// 1. [main스레드가] 작업 스레드객체 생성 [ main 외 추가적으로 작업스레드 추가 ]
		SumThread sumThread = new SumThread();
		// 2. [main스레드가] 작업 스레드 실행 => 대기상태 => CPU스케줄링 => 실행 => 대기상태 => 대기 => 실행
		sumThread.start();
		
		// 3. [main스레드가] 작업 스레드 객체의 필드 확인
		// 작업스레드가 1~100가지 계산 작업을 완료하기 전에 main스레드가 결과 먼저 출력
		System.out.println("join하기 전 1~100 합 : "+sumThread.getSum());
		
		try {
			sumThread.join(); // 합침 [작업스레드로 호출한 스레드는 일시정지 상태]
			// main스레드가 sumThread스레드의 join 메소드를 호출했기 때문에 main 일시정지
		} catch (Exception e) {}
		System.out.println("join한 뒤 1~100 합 : " + sumThread.getSum());
	}
}
