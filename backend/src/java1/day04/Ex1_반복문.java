package java1.day04;

public class Ex1_반복문 { // class s
	public static void main(String[] args) { // main s
		
		// [p.124] 1부터 10까지 누적합계 (for 없이)
		int sum = 0;
		sum = sum+1;	sum+=2; sum+=3; sum+=4; sum+=5; sum+=6; sum+=7; sum+=8; sum+=9; sum+=10;
		
		// 1부터 10까지 누적합계 (for 이용)
		int sum2 = 0;
		for( int i=1; i<=10; i++) { sum2 += i; }
			// i는 1부터 10까지 1식 증가 반복
			
		// [p.125] 1부터 10까지 출력
		// for 이용
		for (int i=1; i<=10; i++) {System.out.println(i + " ");}
		
		// [p.126] 초기값 변수는 for에서 선언시 지역변수이다.
		inr sum3 = 0;
		for (int 반복변수 = 1; 반복변수<=10; 반복변수++ ) {
			sum3 += 반복변수;
		}
		System.out.println(반복변수); // x = for ()에서 선언된 변수는 for{} 밖에서 사용불가
		
		int sum4= 0; int i;
		for (i =1; i<=100; i++) { sum4 += i;}
		System.out.println("1~" + (i-1)+"합 : " + sum4);
		
		// [p.127] 실수		// 소수점뒤에 f 사용이유 : (직접 작성한) 리터럴 소수점 = double
		for( float x = 0.1f; x<=1.0f; x+=0.1f) {System.out.println(x + " ");}
		for( double x = 0.1; x<=1.0; x+=0.1) {System.out.println(x + " ");}
	} // main e
} // class e


/*
 for문
 	for(1.초기값; 2.조건식; 4.증감식;){
 			3. 실행문;
 	}
 	
 	1. 초기값이 실행된다.
 	2. 조건식 판단해서 true이면 {} 들어감 , false {} 건너뜀/종료
 	3. true이면 실행문 실행
 	4. 초기값이 들어있는 변수에 증감식
 	5. 조건식 판단해서 ~~~ 2,3,4,2,3,4 반복
 	
 */