package java2.day24_제네릭.Ex1;

import 과제.과제11.model.dto.MemberDto;

public class Ex1_제네릭 {
	public static void main(String[] args) {
		
		/* 목적 : 하나의 필드 여러타입의 데이터를 저장하고 싶을 때 */
		
		// 1. [p.570] 제네릭을 사용하지 않을때 => Object
		Box2 box2 = new Box2();
		// 1. 자식객체는 부모객체로 대입 [ 자동타입변환 ] : 무조건 가능
		//box2.content = 1; // 1[int] --> Object[최상위클래스]
		//box2.content = "1"; // 1[String] --> Object[최상위클래스]
		box2.content = new MemberDto(); // Dto[객체] --> Object[최상위클래스]
		// ----------------------------------------- //
			// box2.content.getMid(); ->사용불가능
		// 2. 저장하는 부모클래스로 가능하지만 부모는 자식의 멤버를 사용할수 없다 [형변환] : 부모-> 자식 [ 강제타입변환 ]
			// 강제타입변환 하는 방법 2가지
				// 1. 타입 알고 있을때 (형변환할타입)
		MemberDto dto = (MemberDto)box2.content;
		dto.getMid();
				// 2. instanceof 타입 조사후 사용
		if (box2.content instanceof MemberDto) {	}
			// 권장하지 않는 방법 !!! 
		
		// 2. [p.572] 제네릭을 사용할때
		Box<String> box1 = new Box<>();
			// 1. Box 클래스에 넣을 타입 선정 <>
				// vs 함수명() : 함수에 넣을 매개변수 선정
		
		box1.content = "안녕하세요";
		String str = box1.content;
		System.out.println(str);
		
		Box<Integer> box3 = new Box<>();
			// 1. Box 클래스에 넣을 타입 선정 <>
				// Integer content;
		box3.content = 100;
		int value = box3.content;
		System.out.println(value);
		
		// ----------------------------------------- //
		
		Box<MemberDto> box4 = new Box<>();
		box4.content = new MemberDto();
		MemberDto dto2 = box4.content;
		System.out.println(dto2);
	}
}
