package 과제.과제4;

import java.util.Scanner;

public class 과제4_3_키오스크 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int 콜라재고 = 10 ; 	int 환타재고 = 10 ; 	int 사이다재고 = 10;
		
		int 콜라바구니 = 0 ; 	int 환타바구니 = 0 ; 	int 사이다바구니 = 0;
		
		int 콜라가격 = 300 ;	int 환타가격 = 200 ;	int 사이다가격 = 100 ; 
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
			if(ch==4) {
				System.out.println("----------------------------------");
				System.out.printf("%3s %2s %3s \n" , "제품명" , "수량", "가격");
				if (콜라바구니>0) {System.out.printf("%3s %3d %5d \n" , "콜라" , 콜라바구니 , 콜라바구니*콜라가격);} 
				if (사이다바구니>0) {System.out.printf("%3s %3d %5d \n" , "사이다" , 사이다바구니 ,사이다바구니*사이다가격);}
				if (환타바구니>0) {System.out.printf("%3s %3d %5d \n", "환타" , 환타바구니 , 환타바구니*환타가격);}
				

				int 총가격 =0;
				총가격 = (콜라바구니*콜라가격)+(사이다바구니*사이다가격)+(환타바구니*환타가격);
				System.out.println("총가격 : "+총가격);
				System.out.println("결제하시겠습니까? 1.결제 2.취소");
				System.out.print(">>>>>> 선택 : ");
				int pay = scanner.nextInt();
				if (pay==1) {
					System.out.println("금액을 넣어주세요");
					int gold = scanner.nextInt();
					if (gold>총가격 || gold==총가격) {
						int 반환 = gold-총가격;
						System.out.println("거스름돈 :"+반환);
						콜라바구니=0;
						사이다바구니=0;
						환타바구니=0;
					} else {
						System.out.println("금액이 부족합니다 결제취소");
						콜라재고 += 콜라바구니;
						사이다재고 += 사이다바구니;
						환타재고 += 환타바구니;
						콜라바구니=0;
						사이다바구니=0;
						환타바구니=0;
					}
				} else {
					콜라재고 += 콜라바구니;
					사이다재고 += 사이다바구니;
					환타재고 += 환타바구니;
					콜라바구니=0;
					사이다바구니=0;
					환타바구니=0;
				}
				
			} else {
				switch (ch) {
				case 1:
					if(콜라재고==0) {
						System.out.println("재고부족");
					}else {
						콜라재고--;
						콜라바구니++;
					} break;
				case 2:
					if(환타재고==0) {
						System.out.println("재고부족");
					}else {
						환타재고--;
						환타바구니++;
					} break;
				case 3:
					if(사이다재고==0) {
						System.out.println("재고부족");
					}else {
						사이다재고--;
						사이다바구니++;
					} break;	
				default:
					break;
				}
			}
						
			
			
				
			
			
			/* ----------- */
			
				
		} // while end 
	} // main end 
	
} // class end 

/*

	 주제 : 키오스크(변수버전)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격
			int 콜라가격 = 300 ;	int 환타가격 = 200 ;	int 사이다가격 = 100 ; 
		
		2. 제품 초기 재고
			콜라 10개	, 사이다 10개 , 환타 10개      * 판매시 재고 차감되고 다시 채우기 안됩니다.
			int 콜라재고 = 10 ; 	int 환타재고 = 10 ; 	int 사이다재고 = 10;
			
		3. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
			1. 콜라 2.사이다 3.환타 4.결제
			[ 1~3 선택시 ]
				- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력
				 
			[ 4 선택시 ] 
				- 현재 장바구니 현황 표시 목록 
				----------------------------------
				제품명	수량	가격
				사이다	1	400
				환타		2	1000
				총가격 : 1400
				- 결제메뉴 표시
					1. 결제 2.취소 
					[결제]
						- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
						- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
					[취소]
						- [ 장바구니 초기화 / 재고 다시 되돌리기 ]
 
 */







