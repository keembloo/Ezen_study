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
				
			/*-------------------------------------제품정보출력-----------------------------------------*/	
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.print("-1:제품등록 0:결제 ");
				// 2. 재고관리 배열에 있는 제품 정보만 출력 가능하도록 출력
				for (int i=0; i<재고관리.length; i++) { // 2. 재고관리 배열내 정보 출력 // 배열 하나씩 출력
					// String product = 재고관리[i];
					if(재고관리[i].equals("")) { // 배열내 데이터가 공백이 아니면 // 제품 존재
						String name = 재고관리[i].split(",")[0]; // 제품명
						int stock = Integer.parseInt(재고관리[i].split(",")[1]); // 재고
						int price = Integer.parseInt(재고관리[i].split(",")[2]); // 가격
						int basket = Integer.parseInt(재고관리[i].split(",")[3]); // 바구니
						if(stock == 0) { // 재고 없으면
							System.out.print((i+1) + ":" + name+"[재고없음] ");
						} else { // 재고가 있으면
							System.out.print((i+1) + ":" + name+"["+price+"] ");
						}
					} // if end
				}
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			
			/*-------------------------------------제품등록-----------------------------------------*/
			if( ch==-1 ) { // 만약에 -1번을 입력했으면 제품 등록 기능
				// 1. 추가할 제품의 정보를 입력받아 각 변수에 저장
				System.out.print("제품명 : ");		String name = scanner.next();
				System.out.print("초기재고 : ");	int stock = scanner.nextInt();
				System.out.print("가격 : ");		int price = scanner.nextInt();
													int basket = 0; // 바구니 0부터 시작
				// 2. 해당 변수들을 하나의 데이터 구성 [ CSV파일형식 : 제품구별 \n  	  제품내정보구분 ,
				String outStr = name+","+stock+","+price+","+basket+"\n";
				
				// 3. 파일에 내보내기 // 1. 파일출력스트림 객체(if밖에) 2.문자열-> 바이트열변환 3. 바이트배열 내보내기	!예외처리
				fileOutputStream.write(outStr.getBytes());	// 2, 3
				System.out.println("안내) 제품 등록이 되었습니다.");
			} // if end
			/*-------------------------------------선택한 제품을 바구니 담기-----------------------------------------*/
			else if(ch>0 && ch <=재고관리.length) { // 배열내 존재하는 제품만 선택
				// System.out.println(재고관리[ch-1].split(",")[0]+"를 선택했습니다");
				// 1. 선택한 제품번호의 각 정보 호출 : ch-1 : 선택한 제품의 인덱스
				String name = 재고관리[ch-1].split(",")[0]; // 제품명
				int stock = Integer.parseInt(재고관리[ch-1].split(",")[1]); // 재고
				int price = Integer.parseInt(재고관리[ch-1].split(",")[2]); // 가격
				int basket = Integer.parseInt(재고관리[ch-1].split(",")[3]); // 바구니
				// 2. 재고가 0보다 크면 재고/바구니 증감, 재고가 없으면 행동x
				if (stock >0 ) { stock--; basket++; System.out.println(name+"제품을 담았습니다.");}
				else { System.out.println(name+"제품의 재고가 부족합니다"); }
				// 3. 배열 상태 업데이트
				재고관리[ch-1] = name+","+stock+","+price+","+basket;
				// 4. 파일에 내보내기 // 파일내 제품들의 변화가 있으므로 업데이트	// 현재 재고관리배열 상태를 파일에 저장
				String outStr = "";
				for(int i =0; i<재고관리.length; i++) { // 배열내 모든 데이터를 하나의 문자열 변환
					outStr += 재고관리[i].split(",")[0]+","
							+재고관리[i].split(",")[1]+","
							+재고관리[i].split(",")[2]+","
							+재고관리[i].split(",")[3]+"\n";
				} // for end
				// 5. 재고관리 배열을 하나의 문자열로 변환된 문자열을 바이트배열로 변환후 내보내기
				FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);	// 이어쓰기x 새로쓰기o
				fileOutputStream.write(outStr.getBytes());
				// System.out.println("안내) 데이터베이스 상태 최신화");
				
			} // if end
			
			/*-------------------------------------결제-----------------------------------------*/
			/* ----------- */
			else if( ch == 0 ) {
				System.out.printf("%10s %10s %10s \n" , "제품명" , "수량" , "가격");
				for( int i = 0 ; i<재고관리.length ; i++ ) {
					int basket = Integer.parseInt( 재고관리[i].split(",")[3] );
					int price = Integer.parseInt( 재고관리[i].split(",")[2] );
					String name = 재고관리[i].split(",")[0];
					if( basket > 0 ) { // 바구니에 수량이 있는경우만 출력 
						System.out.printf( "%10s %10s %10s \n" , name ,  basket , basket*price );
					}
				}
			} // if end
		} // while end 
	} // main end 
} // class end 



