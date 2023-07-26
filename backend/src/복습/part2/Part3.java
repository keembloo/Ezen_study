package 복습.part2;

import java.util.Scanner;

public class Part3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] 재고관리 = {"10,0,300,콜라","10,0,200,환타","10,0,100,사이다"};
		int sum =0;
		
		while(true) {
			System.out.println("1.콜라 2.환타 3.사이다 4.결제");
			int ch = scanner.nextInt();
			if (ch==1||ch==2||ch==3) {
				String 제품 = 재고관리[ch-1];
				int 재고 = Integer.parseInt(제품.split(",")[0]);
				int 바구니 = Integer.parseInt(제품.split(",")[1]);
				int 가격 = Integer.parseInt(제품.split(",")[2]);
				String 이름 = 제품.split(",")[3];
				
				if (재고>0) {
					재고--;
					바구니++;
					System.out.println(이름+"제품담았습니다");
				} else {
					System.out.println("재고부족");
				}
				재고관리[ch-1] = 재고+","+바구니+","+가격+","+이름;
			} else if (ch==4) {
				System.out.println("결제");
				System.out.printf("%5s %5s %10s \n","제품명","수량","가격");
				for (int i =0; i<재고관리.length; i++) {
				
					int 바구니 = Integer.parseInt(재고관리[i].split(",")[1]);
					int 가격 = Integer.parseInt(재고관리[i].split(",")[2]);
			
				
					String 이름 = 재고관리[i].split(",")[3];
					
					if( 바구니 > 0 ) { // 바구니에 수량이 있는경우만 출력 
						System.out.printf( "%10s %10s %10s \n" , 이름 , 바구니 , 바구니*가격 );
						sum += 바구니*가격;
					}
				}
				System.out.println("총가격 : "+sum);
			}
			
		} // while e
	} // main e
} // class e
