package java1.day14.Ex3_부모메소드호출;

import javax.swing.plaf.SeparatorUI;

public class Ex3_실행 {
	public static void main(String[] args) {
		
		// 1. 자식객체
		SupersonicAirplane sa = new SupersonicAirplane();
				
				// 2.
		sa.takeoff(); // 부모
		sa.hashCode(); // 부모->부모
		sa.fly(); 		// 부모메소드 오버라이딩 [본인 우선]
		sa.land();		// 부모
		sa.toString(); // 부모 -> 부모 메소드 오버라이딩[봄인 우선]
		
		
	}
}
