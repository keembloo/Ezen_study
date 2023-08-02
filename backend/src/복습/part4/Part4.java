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
		Scanner sc = new Scanner(System.in);
		while(true) {
			
		    String filePath = "./src/복습/part4/제품정보.txt";
	
		    FileOutputStream fileOutputStream = new FileOutputStream( filePath ,true); 
	
		    FileInputStream fileInputStream = new FileInputStream( filePath ); 
	
		    File file = new File( filePath );
			
		    byte[] textInfo = new byte[(int)file.length()];
		    fileInputStream.read(textInfo);
		    
		    String products = new String(textInfo);
		    String[] 재고관리 = products.split("\n");
	    
	    	System.out.println("---------------메뉴-------------");
	    	System.out.println("-1:제품등록 0:결제 1:제품선택");
	    	int ch = sc.nextInt();
	    	
	    	if(ch == -1) {
	    		System.out.print("제품이름 >>> "); String Pname = sc.next();
	    		System.out.print("초기재고 >>> "); int 재고 = sc.nextInt();
	    		System.out.print("제품가격 >>> "); int price = sc.nextInt();
	    		int basket = 0;
	    		
	    		String outStr = Pname +"," + 재고 + "," + basket + "," + price + "\n";
	    		fileOutputStream.write(outStr.getBytes());
	    		System.out.println("제품등록 완료");
	    	}	// if end
	    	
	    	else if(ch == 0) {
	    		System.out.println("제품명\t수량\t가격");
	    		for(int i = 0; i < 재고관리.length; i++) {
	    			String name = 재고관리[i].split(",")[0];
	    			int 바구니 = Integer.parseInt(재고관리[i].split(",")[2]);
	    			int 가격 = Integer.parseInt(재고관리[i].split(",")[3]);
	    			if(바구니 > 0) {
	    				System.out.println(name + "\t" + 바구니 + "\t" + (바구니*가격));
	    			}
	    		}
	    		
	    	}else if(ch == 1) {
	    		for(int i = 0; i < 재고관리.length; i++) {
	    			String name = 재고관리[i].split(",")[0];
	    			int 재고 = Integer.parseInt(재고관리[i].split(",")[1]);
	    			if(재고 > 0) {
	    				System.out.println((i+1) + ". " + name + "[" + 재고 + "]");
	    			}else{
	    				System.out.println((i+1) + ". " + name + "[재고없음]");
	    			}
	    		}
	    		
	    		System.out.println("선택 >>> ");
	    		ch = sc.nextInt();
	    		for(int i = 0; i < 재고관리.length; i++) {
	    			if(ch == (i+1)) {
		    			String name = 재고관리[i].split(",")[0];
		    			int 재고 = Integer.parseInt(재고관리[i].split(",")[1]);
		    			int 바구니 = Integer.parseInt(재고관리[i].split(",")[2]);
		    			int 가격 = Integer.parseInt(재고관리[i].split(",")[3]);
	    				if(재고 > 0) {
	    					재고--;
	    					바구니++;
	    					재고관리[i] = name + "," + 재고 + "," + 바구니 + "," + 가격;
	    					
	    					String outStr = "";
	    					for(int j = 0; j < 재고관리.length; j++) {
	    						outStr += 	재고관리[j].split(",")[0] + "," +
	    									재고관리[j].split(",")[1] + "," +
	    									재고관리[j].split(",")[2] + "," +
	    									재고관리[j].split(",")[3] + "," + "\n";
	    					}
	    					FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);
	    					fileOutputStream2.write(outStr.getBytes());
	    					System.out.println(name + "를 담았습니다.");
	    					break;
	    				}else {
	    					System.out.println("재고가 없습니다.");
	    				}
	    			} // if end
	    		} // for end
	    		
	    	} //else if end
	    } // while end
	} // main e
} // class e
