package java2.day23.Ex1;
/*
	멀티스레드 구현하는 방법 2가지
		1. Thread 클래스로부터 extends
			- 상속은1개만되서 다음에 또 재사용불가
			- 필드와 메소드 오버라이드할거면 씀
		2. Runnable 인터페이스로부터 implements
 			- 메소드만 오버라이드할거면 씀
		
	둘다 run메소드 재정의 필요
	
	-상태
		1. new를 이요한 스레드 객체 생성 [스레드 생성]
		2. start() 메소드 이용한 run() 작업코드 실행
			- start() 한다고해서 바로 실행x
			
			실행대기(Runnable) : 실행 대기표 받고 기다리는 중 (운영체제가 하드웨어[cpu]를 사용할수 잇는 권한 줄때까지 ) = cpu스케줄링
			
			실행(Running) : 해당 스레드 순서가 되면 cpu사용할수 있는 권한[명령어 전달 실행]
			
			일시정지	: 스레드가 실행대기가 아닌 잠시 정지된 상태
			
			종료(Terminated) : 스레드 종료
				- main메소드 , run메소드 종료시
			
			
	- 병렬(여러단위 흐름=다차선도로) 처리 vs 직렬(하나단위 흐름=1차선도로) 처리
		- 단일(직렬) 스레드 : main 함수만 있는 경우
		- 멀티(병렬) 스레드 : main에서 thread 추가하는 경우
	
		- 컴퓨터의 병렬 처리 방법
			- 소프트웨어[자바]는 직접적인 하드웨어[cpu , 메모리] 조작 x
			
*/
public class SumThread extends Thread {
	//필드
	private long sum;
	//생성자
	//메소드

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}
	// !! 작업스레드가 실행할 작업코드
	@Override
	public void run() { // 1부터 100이하까지 1씩 증가 누적합계
		for(int i=1; i<=100; i++) {sum+=i;}
	}
	
}
