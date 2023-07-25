package 과제.과제5;

import java.util.Arrays;
import java.util.Scanner;

public class 과제5_키오스크_배열 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] 재고관리 = { "10,0,300,콜라","10,0,200,환타","10,0,100,사이다" };
		int 총가격 =0;
		// 배열 선언하는 방법 : 선언시 크기/길이 줄이거나 늘릴 수 없음
			// 1. 타입[] 변수명 = { 값1, 값2, 값3, 값4 };
				// 배열 선언시 배열에 저장할 값을 알고 있는 상태
			// 2. 타입[] 변수명 = new 타입[길이];
				// 배열 선언시 배열에 저장할 값을 모르고 있는 상태 / 저장할 개수=[길이] 알고 있는 상태
		
		// 변수 : 하나의 값을 저장하는 공간 ( 스택영역에 하나의 데이터 저장 )
			// 데이터 종류 : 1.기본타입 데이터	2.참조타입 주소
			// 				8가지			클래스,배열,인터페이스,열거형
			//
		
		//		스택영역						힙영역
		//		*모든 변수는 스택
		//		String[] 재고관리 = 101번지	{ "10,0,300","100,0,200","10,0,100" } 101번지
		//		int ch = 10
		
		/* ----------- */
		
		
		
		/*
 		System.out.println("배열의 변수명 호출 : " + 재고관리 );  // @59a6e353
		System.out.println("배열내 데이터 호출 : " + Arrays.toString( 재고관리 ) );
		System.out.println("배열내 데이터 개수 : " + 재고관리.length );
		System.out.println("배열내 특정(인덱스)데이터 호출 : " + 재고관리[0] ); 
		 */

/* ----------- */
	
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
			if( ch == 1 || ch == 2 || ch==3  ) {	// 콜라 메뉴선택번호 = 1  // 콜라가 저장된 배열의 인덱스 = 0
				// 1. 배열변수명 호출 
				String product = 재고관리[ch-1];	
					System.out.println( ch+1 + " 번 제품 : " + product );
				// 2. 배열내 데이터[문자열] 분리
				int stock = Integer.parseInt( product.split(",")[0] );
				int basket = Integer.parseInt( product.split(",")[1] );
				int price = Integer.parseInt( product.split(",")[2] );
				String name =  product.split(",")[3] ;
				
				// 3. 유효성검사를 통한 상태 변경 
				if( stock > 0 ) { 
					stock--; 	basket++; System.out.println( name+ " 바구니 담았습니다.");
				}
				else {System.out.println(" 재고 부족 ");}
				// 4. 재고관리 업데이트 
				재고관리[ch-1] = stock+","+basket+","+price+","+name;
			}
			else if( ch == 4 ) {
				System.out.printf("%10s %10s %10s \n" , "제품명" , "수량" , "가격");
				for( int i = 0 ; i<재고관리.length ; i++ ) {
					int basket = Integer.parseInt( 재고관리[i].split(",")[1] );
					int price = Integer.parseInt( 재고관리[i].split(",")[2] );
					String name = 재고관리[i].split(",")[3];
					
					if( basket > 0 ) { // 바구니에 수량이 있는경우만 출력 
						System.out.printf( "%10s %10s %10s \n" , name ,  basket , basket*price );
						총가격 += basket*price;
					}
				}
				System.out.println("총가격 : "+총가격);
			}
			/* ----------- */
			
		} // while end 
	} // main end 
} // class end 







