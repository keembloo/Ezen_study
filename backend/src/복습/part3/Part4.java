package 복습.part3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Part4 {
	public static void main(String[] args) throws IOException {
		 Scanner scanner = new Scanner(System.in); 
		 
		 FileInputStream fileInputStream = new FileInputStream("./src/java1/day07/Ex1_테스트.txt");
		 File file = new File("./src/java1/day07/Ex1_테스트.txt");
		 
		 byte[] inArray = new byte[(int)file.length()]; 
		 fileInputStream.read(inArray); 
		 String str = new String(inArray);
		 
		while(true) {
			System.out.println(" -1: 재고등록  0:결제  "+str);
			int ch = scanner.nextInt();
			if ( ch == -1) {
				System.out.print("제품명 : ");
				String ch2 = scanner.nextLine();
				System.out.print("초기재고 : ");
				String ch3 = scanner.nextLine();
				System.out.print("가격 : ");
				String ch4 = scanner.nextLine();
				System.out.println("등록되었습니다");
				
				
				 
			} else if ( ch == 0 ) {

				 String instr = scanner.nextLine();
				 FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day07/Ex1_테스트.txt" , true); 
				 byte[] outArray = instr.getBytes(); 
				 fileOutputStream.write(outArray);
			}
			

			
			
		} // while e
		
	} // main e
} // class e
