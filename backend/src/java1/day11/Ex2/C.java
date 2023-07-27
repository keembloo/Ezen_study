package java1.day11.Ex2;

import java1.day11.Ex1.B;

public class C {

	// 1. 오류 A와 C 클래스는 다른 패키지니까
	// A a = new A();
	
	// 2. B와 C클래스는 다른 패키지이지만 B클래스 public이므로 가능
	B b = new B();
	
	private C() { // C클래스 생성자
		
	}
}
