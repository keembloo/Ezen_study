package 과제.과제4.Level3.ex6;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Level3_6 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_6 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		/* 문제풀이 위치 */
		String 좌석1 = "[ ]";
		String 좌석2 = "[ ]";
		String 좌석3 = "[ ]";
		String 좌석4 = "[ ]";
		String 좌석5 = "[ ]";
		String 좌석6 = "[ ]";
	
		
		while (true) {
			System.out.println("1.예약하기 2.예약취소 3.예약현황");
			int ch = scanner.nextInt();
			if (ch ==1) { //예약하기시
				System.out.println("예약할 좌석을 선택하세요");
				int ch2 = scanner.nextInt();
				switch (ch2){
				case 1: // 1번좌석을 선택했을때
					if (좌석1 == "[ ]") {
						좌석1 = "[예약]";
						System.out.println("예약이 완료되었습니다");
					} else {
						System.out.println("예약실패 , 좌석1은 이미 예약중입니다.");
					}
					break;
					
				case 2: // 2번좌석을 선택했을때
					if (좌석2 == "[ ]") {
						좌석2 = "[예약]";
						System.out.println("예약이 완료되었습니다");
					} else {
						System.out.println("예약실패 , 좌석2은 이미 예약중입니다.");
					}
					break;
					
				case 3: // 3번좌석을 선택했을때
					if (좌석3 == "[ ]") {
						좌석3 = "[예약]";
						System.out.println("예약이 완료되었습니다");
					} else {
						System.out.println("예약실패 , 좌석3은 이미 예약중입니다.");
					}
					break;
					
				case 4: // 4번좌석을 선택했을때
					if (좌석4 == "[ ]") {
						좌석4 = "[예약]";
						System.out.println("예약이 완료되었습니다");
					} else {
						System.out.println("예약실패 , 좌석4은 이미 예약중입니다.");
					}
					break;
					
				case 5: // 5번좌석을 선택했을때
					if (좌석5 == "[ ]") {
						좌석5 = "[예약]";
						System.out.println("예약이 완료되었습니다");
					} else {
						System.out.println("예약실패 , 좌석5은 이미 예약중입니다.");
					}
					break;
					
				case 6: // 6번좌석을 선택했을때
					if (좌석6 == "[ ]") {
						좌석6 = "[예약]";
						System.out.println("예약이 완료되었습니다");
					} else {
						System.out.println("예약실패 , 좌석6은 이미 예약중입니다.");
					}
					break;
					
				default: 
					System.out.println("좌석을 다시 선택해주세요");
				}
				
			} else if (ch ==2) {  //예약취소시
				System.out.println("취소할 좌석번호를 입력해주세요");
				int cancle = scanner.nextInt();
				switch (cancle) {
					case 1 : 
						if (좌석1 =="[예약]") {
							좌석1 ="[ ]";
							System.out.println("예약이 취소되었습니다.");
						} else {
							System.out.println("예약취소 실패 , 예약되지 않은 좌석입니다.");
						}
						break;
						
					case 2 : 
						if (좌석2 =="[예약]") {
							좌석2 ="[ ]";
							System.out.println("예약이 취소되었습니다.");
						} else {
							System.out.println("예약취소 실패 , 예약되지 않은 좌석입니다.");
						}
						break;
						
					case 3 : 
						if (좌석3 =="[예약]") {
							좌석3 ="[ ]";
							System.out.println("예약이 취소되었습니다.");
						} else {
							System.out.println("예약취소 실패 , 예약되지 않은 좌석입니다.");
						}
						break;
						
					case 4 : 
						if (좌석4 =="[예약]") {
							좌석4 ="[ ]";
							System.out.println("예약이 취소되었습니다.");
						} else {
							System.out.println("예약취소 실패 , 예약되지 않은 좌석입니다.");
						}
						break;
						
					case 5 : 
						if (좌석5 =="[예약]") {
							좌석5 ="[ ]";
							System.out.println("예약이 취소되었습니다.");
						} else {
							System.out.println("예약취소 실패 , 예약되지 않은 좌석입니다.");
						}
						break;
						
					case 6 : 
						if (좌석6 =="[예약]") {
							좌석6 ="[ ]";
							System.out.println("예약이 취소되었습니다.");
						} else {
							System.out.println("예약취소 실패 , 예약되지 않은 좌석입니다.");
						}
						break;
						
					default :
						System.out.println("에러, 좌석을 올바르게 선택해주세요");
				}
			} else if (ch ==3) { //예약현황시
				System.out.println(좌석1+" "+좌석2+" "+좌석3+"\n"+좌석4+" "+좌석5+" "+좌석6);
			}
		}
		/* ----------- */

	}
}
/* 
	주제 : 예약 좌석 시스템
	실행결과는 제공하지 않습니다.
	
	- 변수 조건 
		1. 변수 : 6개의 좌석 은 변수를 이용합니다. [ 배열X ]
		2. 그외 자유롭게 사용. 배열/리스트 사용 금지 [ day1~day4 문법 이용 ]
	- 메뉴 조건
		0. 메뉴 : 1.예약하기 2.예약취소 3.예약현황 
	- 기능 조건 
	 	예약하기 출력예시 )
	 		1. 예약할 좌석을 선택한다.
	 		2. 만약에 비어 있으면 예약성공 아니면 예약 실패 
	 	예약취소 출력예시 )
	 		1. 예약할 취소할 좌석을 선택한다.
	 	예약현황 출력예시 )
	 		* 3개씩 2줄로 출력합니다.
			[ 예약 ]	[ ]	[ ]
			[ ] [예약] [ ]  
			- 예약이 되어 있는 좌석은 [예약] 예약이 없으면 [ ] 공란으로 출력합니다.
			
*/
