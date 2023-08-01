package 복습.part3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Part4 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String path = "./src/복습/part4/제품정보.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			FileInputStream fileInputStream = new FileInputStream(path);
			
			File file = new File(path);
			byte[] text = new byte[(int)file.length()];
			fileInputStream.read(text);
			
			String 품목 = new String(text);
			String[] 재고관리 = 품목.split("\n");
			System.out.println("-1:제품등록 0:결제 1:제품선택");
			System.out.print("선택>");
			int ch = sc.nextInt();
			
			if(ch==-1) {
				System.out.print("제품이름 : "); 
				String 제품명 = sc.next();
				System.out.print("재고 : ");
				int 재고 = sc.nextInt();
				System.out.print("가격 : ");
				int 가격 = sc.nextInt();
				int 바구니 = 0;
				
				String str = 제품명+","+재고+","+바구니+","+가격+"\n";
				fileOutputStream.write(str.getBytes());
				System.out.println("등록완료");
			} else if (ch==0) {
				System.out.println("제품명\t수량\t가격");
				for(int i=0; i< 재고관리.length;i++) {
					String 제품 = 재고관리[i].split(",")[0];
					int 바구니 = Integer.parseInt(재고관리[i].split(",")[2]);
	    			int 가격 = Integer.parseInt(재고관리[i].split(",")[3]);
	    			if(바구니 > 0) {
	    				System.out.println(제품 + "\t" + 바구니 + "\t" + (바구니*가격));
	    			}
	    		} // for e
	    	}else if(ch == 1) {
	    		for(int i = 0; i < 재고관리.length; i++) {
	    			String 제품 = 재고관리[i].split(",")[0];
	    			int 재고 = Integer.parseInt(재고관리[i].split(",")[1]);
	    			if(재고 > 0) {
	    				System.out.println((i+1) + ". " + 제품 + "[" + 재고 + "]");
	    			}else{
	    				System.out.println((i+1) + ". " + 제품 + "[재고없음]");
	    			}
	    		}// for e
	    		System.out.println("선택 >>> ");
	    		ch = sc.nextInt();
	    		for(int i = 0; i < 재고관리.length; i++) {
	    			if(ch == (i+1)) {
		    			String 제품 = 재고관리[i].split(",")[0];
		    			int 재고 = Integer.parseInt(재고관리[i].split(",")[1]);
		    			int 바구니 = Integer.parseInt(재고관리[i].split(",")[2]);
		    			int 가격 = Integer.parseInt(재고관리[i].split(",")[3]);
	    				if(재고 > 0) {
	    					재고--;
	    					바구니++;
	    					재고관리[i] = 제품 + "," + 재고 + "," + 바구니 + "," + 가격;
	    					
	    					String str = "";
	    					for(int j = 0; j < 재고관리.length; j++) {
	    						str += 	재고관리[j].split(",")[0] + "," +
	    								재고관리[j].split(",")[1] + "," +
	    								재고관리[j].split(",")[2] + "," +
	    								재고관리[j].split(",")[3] + "," + "\n";
	    					}
	    					FileOutputStream fileOutputStream2 = new FileOutputStream(path);
	    					fileOutputStream2.write(str.getBytes());
	    					System.out.println(제품 + "를 담았습니다.");
	    					break;
	    				}else {
	    					System.out.println("재고가 없습니다.");
	    				}
	    			} // if end
	    		} // for end
	    	}//if end
		}// while e
	} // main e
} // class e
