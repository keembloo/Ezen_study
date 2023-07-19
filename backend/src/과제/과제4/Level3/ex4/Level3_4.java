package 과제.과제4.Level3.ex4;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level3_4 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_4 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
	
		/* 문제풀이 위치 */
		int count = 0;
		
		while (true) {
			System.out.println("정수를 입력하세요");
			int num = scanner.nextInt();
			if(num<0) {
				System.out.println("프로그램 종료");
				count =0;
				break;
			} else {
				count = num;
				for( int i =1; i<=count; i++) {
					System.out.println("■");
				} // for end
			}
		}
		/* ----------- */

	}
}
/* 
	[문제] 그림과 같이 계속입력한 수에 따라 누적으로 저장되어 저장된 수 만큼 '■' 를 출력하시오.
	[조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 만약에 누적값이 0 보다 작으면 종료됩니다.
*/
