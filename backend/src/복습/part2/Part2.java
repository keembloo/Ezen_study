package 복습.part2;

import java.util.Scanner;

public class Part2 { //class s
	public static void main(String[] args) { // main s
		Scanner scanner = new Scanner(System.in);
		String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n";
		int sum =0;
		
		String 콜라 = 재고관리.split("\n")[0];
		String 사이다 = 재고관리.split("\n")[1];
		String 환타 = 재고관리.split("\n")[2];
		
		int 콜라재고 = Integer.parseInt(콜라.split(",")[0]);
		int 사이다재고 = Integer.parseInt(사이다.split(",")[0]);
		int 환타재고 = Integer.parseInt(환타.split(",")[0]);
		
		int 콜라바구니 = Integer.parseInt(콜라.split(",")[1]);
		int 사이다바구니 = Integer.parseInt(사이다.split(",")[1]);
		int 환타바구니 = Integer.parseInt(환타.split(",")[1]);
		
		int 콜라가격 = Integer.parseInt(콜라.split(",")[2]);
		int 사이다가격 = Integer.parseInt(사이다.split(",")[2]);
		int 환타가격 = Integer.parseInt(환타.split(",")[2]);
		
		while (true) {
			System.out.println("1. 콜라 2.사이다 3.환타 4.결제");
			System.out.print("입력>>");
			int ch1 = scanner.nextInt();
			
			if (ch1==4) {
				System.out.printf("%3s %3s %5s \n","콜라","사이다","환타");
				if (콜라바구니>0) {
				System.out.printf("%3s %3d %5d \n","콜라",콜라바구니,콜라가격*콜라바구니);
				}
				if (사이다바구니>0) {
					System.out.printf("%3s %3d %5d \n","사이다",사이다바구니,사이다가격*사이다바구니);
				}
				if (환타바구니>0) {
					System.out.printf("%3s %3d %5d "
							+ "\n","환타",환타바구니,환타가격*환타바구니);
				}
				sum = 콜라가격*콜라바구니+사이다가격*사이다바구니+환타가격*환타바구니;
				System.out.println("총가격 : "+sum);
				System.out.println("1. 결제 2.취소");
				int ch2 = scanner.nextInt();
				if (ch2==1) { // 결제시
					System.out.println("금액을 넣어주세요");
					int pay = scanner.nextInt();
					if (pay>= sum) {
						System.out.println("거스름돈 : "+(pay-sum));
						콜라바구니=0;
						사이다바구니=0;
						환타바구니=0;
					} else {
						System.out.println("금액이부족합니다 결제가 취소됩니다");
						콜라재고 += 콜라바구니;
						사이다재고 += 사이다바구니;
						환타재고 += 환타바구니;
						콜라바구니=0;
						사이다바구니=0;
						환타바구니=0;
					}
				} else {
					System.out.println("결제취소");
					콜라재고 += 콜라바구니;
					사이다재고 += 사이다바구니;
					환타재고 += 환타바구니;
					콜라바구니=0;
					사이다바구니=0;
					환타바구니=0;
				}
			} else if (ch1==1) {
				if(콜라재고>0) {
					콜라재고--;
					콜라바구니++;
					System.out.println("콜라"+콜라바구니);
				} else { System.out.println("재고부족");}
			} else if (ch1==2) {
				if(사이다재고>0) {
					사이다재고--;
					사이다바구니++;
					System.out.println("사이다"+사이다바구니);
				} else { System.out.println("재고부족");}
			} else if (ch1==3) {
				if(환타재고>0) {
					환타재고--;
					환타바구니++;
					System.out.println("환타"+환타바구니);
				} else { System.out.println("재고부족");}
			}
			
		}
	} // main e
} // class e
