package 과제.과제5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 과제5_키오스크_파일처리 {

	public static void main(String[] args) throws IOException {
		
		
		/* ----------- */
		
		while(true) { // 프로그램 무한루프
			
			Scanner scanner = new Scanner(System.in);
			String filePath = "./src/과제/과제5/재고파일.txt";	// 파일경로
			FileOutputStream fileOutputStream = new FileOutputStream(filePath,true); // 파일출력객체
			FileInputStream fileInputStream  = new FileInputStream(filePath); // 파일입력객체
			File file = new File(filePath); 	// 파일정보객체 (용량, 경로, 파일명 등등) 메소드 제공
			
			/* --------- 파일내 제품 정보 ----스트림[바이트]----> 배열로 옮기기 --------> 문자열 변환 ---------- */
			byte[] inByteArray = new byte[(int)file.length()]; // 파일의 용량만큼의 배열 선언
			fileInputStream.read(inByteArray);	// 읽어온 바이트를 바이트배열에 저장
			String fileInfo = new String (inByteArray); // 바이트배열 --> 문자열 변환
				System.out.println(fileInfo);
				
			/*-----------파일내 제품정보 문자열 ---> 각 제품별 배열 저장---------------------*/
			// 1. 하나 문자열로 모든 제품의 문자열을 각 제품별로 분리
			String[] 재고관리 = fileInfo.split("\n"); System.out.println("제품별 분리 : "+ Arrays.toString(재고관리));
			// 2. 각 제품별로 각 필드/정보 분리
				
				
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.print("-1:제품등록 0:결제 ");
				// 2. 재고관리 배열에 있는 제품 정보만 출력 가능하도록 출력
				for (int i=0; i<재고관리.length; i++) {
					String product = 재고관리[i];
					String name = product.split(",")[0]; // 제품명
					
					int stock = Integer.parseInt(재고관리[i].split(",")[1]); // 재고
					int price = Integer.parseInt(재고관리[i].split(",")[2]); // 가격
					int basket = Integer.parseInt(재고관리[i].split(",")[3]); // 바구니
					
					if(stock == 0) { // 재고 없으면
						System.out.print((i+1)+" "+name+" "+"[재고없음]");
					} else { // 재고가 있으면
						System.out.print((i+1)+" "+name+" "+"["+price+"]");
					}
				}
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			if( ch==-1 ) { // 만약에 -1번을 입력했으면 제품 등록 기능
				// 1. 추가할 제품의 정보를 입력받아 각 변수에 저장
				System.out.print("제품명 : ");		String name = scanner.next();
				System.out.print("초기재고 : ");	int stock = scanner.nextInt();
				System.out.print("가격 : ");		int price = scanner.nextInt();
													int basket = 0; // 바구니 0부터 시작
				// 2. 해당 변수들을 하나의 데이터 구성 [ 제품 구별 \n  /		제품내정보구분 , ]
				String outStr = name+","+stock+","+price+","+basket+"\n";
				
				// 3. 파일에 내보내기 // 1. 파일출력스트림 객체(if밖에) 2.문자열-> 바이트열변환 3. 바이트배열 내보내기	!예외처리
				fileOutputStream.write(outStr.getBytes());	// 2, 3
				
				System.out.println("안내) 제품 등록이 되었습니다.");
			}
			
			
			/* ----------- */
			
		} // while end 
	} // main end 
} // class end 



