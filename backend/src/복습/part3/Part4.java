package 복습.part3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Part4 {
	public static void main(String[] args) throws IOException {
		System.out.println("입력할내용 : ");
		Scanner scanner = new Scanner(System.in);
		String memo = scanner.nextLine();
		byte[] outArray = memo.getBytes();
		
		FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day07/Ex1_테스트.txt" , true);
		fileOutputStream.write(outArray);
		
		FileInputStream fileInputStream = new FileInputStream("./src/java1/day07/Ex1_테스트.txt");
		byte[] inputArray = new byte[1000];
		fileInputStream.read(inputArray);
		
		String str = new String (inputArray);
		System.out.println(str);
	}
} // class e
