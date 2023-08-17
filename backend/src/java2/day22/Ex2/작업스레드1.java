package java2.day22.Ex2;

public class 작업스레드1 implements Runnable { //구현
	@Override
	public void run() {
		try {
			int count = 1;
			while (true) {
				Thread.sleep(5000); // 1초간 일시정지 [예외처리필수]
				Thread.currentThread().setName("스레드1");
				System.out.println(Thread.currentThread().getName() + "작업1 스레드 output" + count);
				count++;
			}
		} catch (Exception e) {System.out.println(e);}
		
	}
}
