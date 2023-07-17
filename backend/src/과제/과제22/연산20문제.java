package 과제.과제22;
// java.lang 패키지 : System 클래스, Math 클래스, Integer 클래스 등등 import 생략
import java.util.Scanner; // Scanner 클래스를 사용하기 위한 클래스호출

public class 연산20문제 {
	
	public static void main(String[] args) {
		
		//------ 문제1 여기에 풀이-------//
		System.out.println("|\\_/|\n|q\0p|\0\0/}\n( 0 )\"\"\'\\\n|\"^\"`\0\0\0|\n||_/=\\\\_|");

		//------ 문제2 여기에 풀이-------//
		/*
		 //입력 
		 	//1. 입력객체 생성 { } 마다 하나의 객체 필요
		 Scanner scanner = new Scanner( System.in ); 
		 System.out.println("이름을 입력하세요");
		 	//2. 입력객체로부터 압력받은 데이터를 호출하기
		 String writer = scanner.next(); System.out.println("내용을 입력하세요"); 
		 String text = scanner.next(); System.out.println("날짜를 입력하세요"); 
		 String callendar =	 scanner.next();
		  
		 System.out.println("--------------방문록--------------------");
		 System.out.println("|\0순번\0\0|\0작성자\0|\0\0\0\0내용\0\0\0\0|\0\0\0\0날짜\0\0\0\0|"); 
		 System.out.println("|\0 1 \0\0|"+"\0"+writer+"\0|"+text+"\0\0\0\0|\0\0"+callendar+"\0\0\0|");
		 System.out.println("---------------------------------------");
		
		 // 간격맞출때는 printf 사용
		 
 		 System.out.printf("--------------방문록--------------------");
		 System.out.printf("|%4s|%5s|%10s|%4s|\n" , "순번 " , "작성자 ", "내용" ,"날짜 "); 
		 System.out.printf("|%4d|%5s|%10s|%4s|\n" , 1 , 작성자 , 내용 ,날짜); 
		 System.out.println("---------------------------------------");
		
		
		
		 //------ 문제3 여기에 풀이-------//
		  
		 Scanner scanner = new Scanner( System.in );
		 System.out.println("기본급(정수)을 입력해주세요"); int 기본급 = scanner.nextInt();
		 System.out.println("수당()을 입력해주세요"); int 수당 = scanner.nextInt();
		 
		 int 실수령액 = (int) (기본급 + 수당 - (기본급*0.1)); System.out.println("실수령액 :"+실수령액);
		  //리터럴(직접입력한)의 기본타입 : int
		  // int * double 연산시 -> 결과 double
		  // double은 long에 대입 x -> 강제형변환(캐스팅)필요
		 
		//------ 문제4 여기에 풀이-------//
		// 1. 입력
			// 1. 입력객체 : 상단
			// 2. 입력값 호출
		
		 Scanner scanner = new Scanner( System.in ); System.out.println("금액을 입력해주세요");
		 int 금액 = scanner.nextInt(); int 십만원 = (int) 금액/100000; 
		 int 만원 = (int)(금액/10000-십만원*10); int 천원 = (int)(금액/1000-십만원*100-만원*10); 
		 int 백원 = (int)(금액/100-십만원*1000-만원*100-천원*10);
		  
		 System.out.println("십만원권"+십만원+"장\n만원권"+만원+"장\n천원권"+천원+"장\n백원"+백원+"개");
		 
		 // String.valueOf(금액).charAt(5);
		
		//------ 문제5 여기에 풀이-------//
		 Scanner scanner = new Scanner( System.in ); System.out.println("숫자를 입력해주세요");
		 int num = scanner.nextInt();
		 String result = num %7 == 1 ? "X" : "O";
		 System.out.println(result);
		  
		//------ 문제6 여기에 풀이-------//
		 Scanner scanner = new Scanner( System.in ); System.out.println("숫자를 입력해주세요");
		 int num = scanner.nextInt();
		 String result = num %2 == 1 ? "O" : "X";
		 System.out.println(result);
		
		//------ 문제7 여기에 풀이-------//
		 Scanner scanner = new Scanner( System.in ); System.out.println("숫자를 입력해주세요");
		 int num = scanner.nextInt();
		 String result = num %7 ==0 && num%2 ==0 ? "O" : "X";
		 System.out.println(result);
		 
		 
		//------ 문제8 여기에 풀이-------//
		// 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]
		Scanner scanner = new Scanner( System.in ); System.out.println("숫자를 입력해주세요");
		int num = scanner.nextInt();
		String result = num%7 ==0 || num%2 ==1 ? "O" : "X";
		System.out.println(result);
		
		
		
		//------ 문제9 여기에 풀이-------//
		Scanner scanner = new Scanner( System.in ); System.out.println("정수1를 입력해주세요");
		int num1 = scanner.nextInt();
		System.out.println("정수1를 입력해주세요");
		int num2 = scanner.nextInt();
		int result = num1 > num2 ? num1 : num2;
		
		System.out.println(result);
				
		//------ 문제10 여기에 풀이-------//
		//반지름을 입력받아 원 넓이 출력하기 
		//계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]
		Scanner scanner = new Scanner( System.in ); System.out.println("반지름을 입력해주세요");
		int num = scanner.nextInt();
		double result = num * num * 3.14;
		System.out.println("원 넓이 : "+result);
		
		*/
		//------ 문제11 여기에 풀이-------//
		
		
		//------ 문제12 여기에 풀이-------//
		
		
		//------ 문제13 여기에 풀이-------//
		
		
		//------ 문제14 여기에 풀이-------//
		
		
		//------ 문제15 여기에 풀이-------//
		
		
		//------ 문제16 여기에 풀이-------//
		
		
		//------ 문제17 여기에 풀이-------//
		
		
		//------ 문제18 여기에 풀이-------//
		
		
		//------ 문제19 여기에 풀이-------//
		
		
		//------ 문제20 여기에 풀이-------//
		
		
		//------ 문제21 여기에 풀이-------//
		
		
		
	}

}


/*

문제1 : 강아지 console 출력
	|\_/|
	|q p|   /}
	( 0 )"""\
	|"^"`    |
	||_/=\\__|

문제2 : 입력받은 3개 데이터를 이용한 표 만들기 
	[입력변수]
		1. 작성자[문자열] , 내용[문자열] , 날짜[문자열] 입력받아 각 변수에 저장 
	[출력 예]
		   --------------방문록--------------------
		   | 순번  | 작성자  | 	내용 	| 날짜       |
		   |  1   | 강호동  |안녕하세요  |  09-28    |
		  ----------------------------------------
	
문제3 : 급여 계산
	[입력조건]
		기본급[정수] , 수당[정수]
	[ 조건 ] 
		 실수령액 = 기본급 + 수당 - 세금[기본급10%] 
	[출력조건] 
		실수령액 출력[ 소수점 없이  ]

문제4 : 지폐 세기 
	 [입력조건 ] 
		금액 
	 [조건 ] 
		 십만원 부터 백원 까지의 개수 세기 
	[ 출력조건 ]
		예) 356789 입력시 
		 십만원 3장 
		 만원 5장
		 천원 6장 
		 백원 7개

문제5 : 하나의 정수를 입력받아 7의 배수인지 출력[ 'O' 혹은 'X' 로 출력]

문제6 : 하나의 정수를 입력받아 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력]

문제7 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제9 : 두개의 정수를 입력받아 더 큰수 출력 

문제10 : 반지름을 입력받아 원 넓이 출력하기 
	계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]

문제11 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기 
	예) 54.5   84.3 실수 2개입력시 결과는   64.285714%

문제12 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 
	계산식) 사다리꼴 계산식 = > (윗변 + 밑변) * 높이 / 2

문제13: 키를 정수를 입력받아 표준체중 출력하기 
	계산식) 표준체중 계산식 = > (키 - 100) * 0.9

문제14: 키와 몸무게를 입력받아 BMI 출력하기 
	계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))

문제15: inch 를 입력받아 cm 로 변환하기 
	계산식) 1 inch -> 2.54cm

문제16:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오 
	계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %

문제17 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
	int x = 10;
	int y = x-- + 5 + --x;
	printf(" x의 값 : %d , y의값 :  %d ", x, y)

문제18 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기

문제19 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력

문제20 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력

문제21 : 세 정수를 입력받아 가장 큰수 출력 

  
 */
