package java2.day24_제네릭.Ex2;

public class Ex2_제네릭 {
	public static void main(String[] args) {
		
		// 1. Product 객체 만드는데 tv객체를 가지고 
			// 1. product 객체 만들때 필드에 사용할 타입 구체적으로 대입
		Product<Tv, String> product1 = new Product<>();
			// 2. product 객체 [Tv kind = null; String model=null;] 필드의 초기값 = 정수0 실수0.0 boolean false 클래스 null
		product1.setKind(new Tv());
		product1.setModel("스마트Tv");
			// 3. product 객체 [Tv kind = new Tv(); String model="스마트Tv";]
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();

		// --------------------- product객체<Tv, String> -> product객체<Car, String>
		// 다른 제네릭 타입의 객체 생성하고 싶을때 -> 객채 생성
		// 2. Product 객체 만드는데 car객체를 가지고 
			// 1. product 객체 만들때 필드에 사용할 타입 구체적으로 대입 
		Product<Car, String> product2 = new Product<>();
			// 2. product 객체 [Car kind = null; String model=null;] 필드의 초기값 = 정수0 실수0.0 boolean false 클래스 null
		product2.setKind(new Car());
		product2.setModel("SUV자동차");
			// 3. product 객체 [Tv kind = new Tv(); String model="스마트Tv";]
		Car car = product2.getKind();
		String carModel = product2.getModel();
	}
}
