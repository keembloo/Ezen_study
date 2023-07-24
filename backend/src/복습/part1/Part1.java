package 복습.part1;

import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
	    int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
	    int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
	    int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
	    
	    while(true) {
	    	System.out.println("------------------------------");
	    	System.out.println("1. 콜라 2.사이다 3.환타 4.결제");
	    	System.out.println("------------------------------");
	    	System.out.print("선택>>");
	    	int ch1 = scanner.nextInt();
	    	if (ch1==1) {
	    		if(콜라재고>0) {
	    			콜라재고--;
	    			콜라바구니++;
	    		} else {
	    			System.out.println("콜라재고부족");
	    		}
	    	} else if (ch1==2) {
	    		if(사이다재고>0) {
	    			사이다재고--;
	    			사이다바구니++;
	    		} else {
	    			System.out.println("사이다재고부족");
	    		}
	    	} else if (ch1==3) {
	    		if(환타재고>0) {
	    			환타재고--;
	    			환타바구니++;
	    		}else {
	    			System.out.println("환타재고부족");
	    		}
	    	} else if (ch1==4) {
	    		System.out.printf("%3s %3s %5s \n","제품명" , "수량", "가격");
	    		if (콜라바구니>0) {
	    			System.out.printf("%3s %3d %5d \n", "콜라",콜라바구니,콜라바구니*콜라가격);
	    		}
	    		if (사이다바구니>0) {
	    			System.out.printf("%3s %3d %5d \n", "사이다",사이다바구니,사이다바구니*사이다가격);
	    		}
	    		if (환타바구니>0) {
	    			System.out.printf("%3s %3d %5d \n", "환타",환타바구니,환타바구니*환타가격);
	    		}
	    		int sum = 콜라바구니*콜라가격+사이다바구니*사이다가격+환타바구니*환타가격;
	    		System.out.println("총가격 : "+sum);
	    		System.out.println("1.결제 2.취소");
	    		int ch2 = scanner.nextInt();
	    		if(ch2==1) {
	    			System.out.println("금액을 투입하세요");
	    			int ch3 = scanner.nextInt();
	    			if (ch3>=sum) {
	    				System.out.println("거스름돈: "+(ch3-sum));
	    				콜라바구니=0;
	    				사이다바구니=0;
	    				환타바구니=0;
	    			} else {
	    				System.out.println("결제가 취소됩니다");
	    				콜라재고+=콜라바구니;
	    				사이다재고+=사이다바구니;
	    				환타재고+=환타바구니;
	    				콜라바구니=0;
	    				사이다바구니=0;
	    				환타바구니=0;
	    			}
	    		} else {
	    			System.out.println("결제가 취소됩니다");
    				콜라재고+=콜라바구니;
    				사이다재고+=사이다바구니;
    				환타재고+=환타바구니;
    				콜라바구니=0;
    				사이다바구니=0;
    				환타바구니=0;
	    		}
	    	}
	    	
	    }
	} // main e
} // class e
