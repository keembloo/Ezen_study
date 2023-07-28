package 복습.part4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Part4 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String path = "./src/java1/day07/Ex1_테스트.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(path , true);
			FileInputStream fileInputStream = new FileInputStream(path);
			
			File file = new File(path);
			byte[] inArray = new byte[(int)file.length()];
			fileInputStream.read(inArray);
			String str = new String(inArray);
			String[] 재고관리 = str.split("\n");
			
			System.out.println("-1:제품등록 0:결제 "+str);
			System.out.println("선택>>");
			int ch = scanner.nextInt();
			
			if( ch == -1) {
				scanner.nextLine();
				System.out.print("제품명 : ");
				String 제품 = scanner.nextLine();
				System.out.print("초기재고 : ");
				int 재고 = scanner.nextInt();
				System.out.print("가격 : ");
				int 가격 = scanner.nextInt();
				System.out.println("등록되었습니다");
				int 바구니 = 0;
				
				String addstr = 제품+","+재고+","+가격+","+바구니;
				fileOutputStream.write(addstr.getBytes());
				System.out.println("등록완료");
				
			} else if ( ch ==0) {
				
			}else if (ch >0) {
				
			}
			
		}// while e
	} // main e
} // class e
