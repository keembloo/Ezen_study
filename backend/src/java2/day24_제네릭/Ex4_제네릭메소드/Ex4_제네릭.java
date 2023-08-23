package java2.day24_제네릭.Ex4_제네릭메소드;

public class Ex4_제네릭 {
	
		// 제네릭메소드 선언
			// 메소드 선언부 <제네릭타입> : 함수내에서도 제네릭타입 사용할수 있다. 
	public static <T> Box<T> boxing( T t ) {
					// 매개변수에서 제네릭타입 사용하기 위한 <T> 선언부에 정의하면 사용가능
					// Integer t = 100
					// String t = "홍길동"
		Box<T> box = new Box<>();
			// Box<Integer> box = new Box<>();
			// Box<String> box = new Box<>();
		box.setT(t);
			// box객체[Integer t =100]
			// box객체[String t ="홍길동"]
		return box;
			// box객체[Integer t =100]
			// box객체[String t ="홍길동"]
	}
	
	// main 메소드
	public static void main(String[] args) {
		
		// 1. Box 객체 t필드를 Integer 타입으로 선정
		Box<Integer> box1 = boxing(100); // 타입 파라미터에 값 넣으면 (자동으로) 값의 타입으로 Integer 대체
			// box1 [Integer t]
		int intvalue = box1.getT();
		System.out.println(intvalue);
		
		// 2.
		Box<String> box2 = boxing("홍길동"); // 타입 파라미터에 값 넣으면 (자동으로) 값의 타입으로 string 대체
	}
}
