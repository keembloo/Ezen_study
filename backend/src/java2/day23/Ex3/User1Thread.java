package java2.day23.Ex3;

public class User1Thread extends Thread {
	private Calculator calculator; // 필드
	public User1Thread() {setName("User1");} // 생성자
	public void setCalculator ( Calculator calculator ) {
		this.calculator = calculator; 
	}  // [setter]메소드
	
	@Override
	public void run() {
		calculator.setMemory1(100);
	}
}
