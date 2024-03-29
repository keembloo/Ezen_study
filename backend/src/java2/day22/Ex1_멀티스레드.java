package java2.day22;

import java.awt.Toolkit;

public class Ex1_멀티스레드 {
	public static void main(String[] args) { // 메인스레드가 main메소드를 호출하면서 코드 시작
		
		// p.596 예1
		Toolkit toolkit = Toolkit.getDefaultToolkit();	// java.awt : JAVAUI 제공
			// * 5번의 비프음 발생시켰는데 소리는 1번만 들림
		
		// ---------------------- 싱글 스레드 ---------------------- //
		for(int i=0; i<5; i++) { toolkit.beep(); } // toolkit.beep(); 비프음
		
			// * 5번의 비프음 발생 시키면서 0.5초씩 딜레이
		for(int i=0; i<5; i++) {
			toolkit.beep();
			// * 0.5초간 딜레이 [ 메인스레드 잠깐 멈춤 ] - 밀리초(1/1000)초
			try {
				Thread.sleep(500); // 예외처리 발생
			} catch (Exception e) {System.out.println(e);}
		} // for end
		
			// * 5번의 출력
		for ( int i =0; i<5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);}catch (Exception e) { System.out.println(e);}
		}
		
		// ---------------------- 1. 멀티 스레드 [익명구현체] ---------------------- //
		// 1. [main스레드가 작업스레드 생성] main 스레드외 작업스레드 객체 만들기
		Thread thread = new Thread( new Runnable() {
			
			@Override
			public void run() { // Runnable 인터페이스 추상메소드 구현
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for ( int i=0; i<5; i++) {
					toolkit.beep();
					try {Thread.sleep(500);}catch (Exception e) { System.out.println(e);}
				} // for end
			} // 추상메소드 구현 end
		}); // 생성자 end
		
		// 2. [main스레드가 작업스레드 실행] 작업스레드 시작
		thread.start();
		
		// 3. main 스레드 작업
		for ( int i =0; i<5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);}catch (Exception e) { System.out.println(e);}
		}
		
		// ---------------------- 2. 멀티 스레드 [익명 구현체] ---------------------- //
		비프음 비프음 = new 비프음(); // Runnable 인터페이스 구현한 객체 [구현체]
		Thread thread2 = new Thread(비프음); // Runnable 구현체를 Thread 객체에게 전달
		thread2.start();	// Thread 클래스에 start()실행시 run 메소드 실행
		
		// 3. main 스레드 작업
		for ( int i =0; i<5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);}catch (Exception e) { System.out.println(e);}
		}
		
		// ---------------------- 3. 멀티 스레드 [Thread 자식 클래스 구현체] ---------------------- //
		비프음2 비프음2 = new 비프음2(); // Thread 자식객체 생성
		비프음2.start(); // run메소드 실행
		
		// 3. main 스레드 작업
		for ( int i =0; i<5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);}catch (Exception e) { System.out.println(e);}
		}
	} // main e
}

/*


*/