package 과제.과제5;

import java.util.Scanner;

public class 과제5_키오스크 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String 재고관리 = "";
		/* 재고관리 변수 샘플  */
		재고관리 = "콜라,300,0,10-환타,200,0,10-사이다,100,0,10";
		/* ----------- */
		
		
		String cok = 재고관리.split("-")[0];
		//System.out.println(cok);
		String fanta = 재고관리.split("-")[1];
		//System.out.println(fanta);
		String sida = 재고관리.split("-")[2];
		//System.out.println(sida);
		
		
		int cokPoket = Integer.parseInt(cok.split(",")[2]); //콜라 바구니
		int fanPoket = Integer.parseInt(fanta.split(",")[2]); //환타 바구니
		int sidaPoket = Integer.parseInt(sida.split(",")[2]); //사이다 바구니
		
		int cokCount = Integer.parseInt(cok.split(",")[3]); //콜라 재고
		int fanCount = Integer.parseInt(fanta.split(",")[3]); //환타 재고
		int sidaCount = Integer.parseInt(sida.split(",")[3]); //사이다 재고
		
		int cokGold = Integer.parseInt(cok.split(",")[1]); //콜라 가격
		int fanGold = Integer.parseInt(fanta.split(",")[1]); //환타 가격
		int sidaGold = Integer.parseInt(sida.split(",")[1]); //사이다 가격
		
		int total = 0; //총합계
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
			if (ch == 4) { // 결제눌렀을때
				System.out.println("----------------------------------");
				System.out.printf("%3s %3s %5s \n" , "제품명" , "수량" , "가격");
				if (cokPoket > 0) {System.out.printf("%3s %3d %7d \n" ,  cok.split(",")[0], cokPoket , cokPoket*cokGold);}
				if (fanPoket > 0) {System.out.printf("%3s %3d %7d \n" ,  fanta.split(",")[0], fanPoket , fanPoket*fanGold);}
				if (sidaPoket > 0) {System.out.printf("%3s %3d %7d \n" ,  sida.split(",")[0], sidaPoket , sidaPoket*sidaGold);}
				total = cokPoket*cokGold+fanPoket*fanGold+sidaPoket*sidaGold;
				System.out.println("총가격 : "+total);
				System.out.println("1. 결제 2.취소");
				int ch2 = scanner.nextInt();
				while(true) { // 금액부족시 전단계로 돌리기위한 while문
					if (ch2 == 1) { // 결제시
						System.out.println("금액을 넣어주세요");
						int pay = scanner.nextInt();
						if(pay>=total) { // 금액있을시
							int change = pay-total;
							System.out.println("거스름돈 : "+change);
							cokPoket = 0;
							fanPoket = 0;
							sidaPoket = 0;
							break;
						}else { // 금액부족시
							System.out.println("금액이 부족합니다...");
						}
					}else { // 결제 취소시
						System.out.println("결제 취소되었습니다");
						cokCount +=cokPoket;
						fanCount +=fanPoket;
						sidaCount +=sidaPoket;
						cokPoket=0;
						fanPoket=0;
						sidaPoket=0;
						break;
					}
				}//while end
			} else if (ch ==1) { // 콜라 선택시
				if(cokCount>0) {
					cokPoket++;
					cokCount--;
					System.out.println(cokPoket);
				} else { System.out.println("콜라 재고 없음");}
			} else if (ch ==2) { // 환타 선택시
				if(fanCount>0) {
					fanPoket++;
					fanCount--;
					System.out.println(fanPoket);
				} else { System.out.println("환타 재고 없음");}
			} else if (ch ==3) { // 사이다 선택시
				if(sidaCount>0) {
					sidaPoket++;
					sidaCount--;
					System.out.println(sidaPoket);
				} else { System.out.println("사이다 재고 없음");}
			}
			/* ----------- */
			
		} // while end 
	} // main end 
	
} // class end 

/*

	 주제 : 키오스크(변수버전)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
			// 샘플 : 
					이름 : 콜라 , 환타 , 사이다
					가격 : 300 , 200 , 100
					바구니 : 0 , 0 , 0
			
		2. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
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







