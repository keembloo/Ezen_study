package 과제.과제5;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

import javax.print.attribute.SetOfIntegerSyntax;

public class 과제5_주차요금정산기 { // class s
	public static void main(String[] args) { // main s
		String[] carList = new String[9]; // 9개 차량번호 리스트 임의배열 선언
		String[] carStage = new String[9]; // 9개 임의 상태배열 선언 "주차가능" "주차중" 
		int count = 0;
		
		for (int i=0; i<carStage.length; i++ ) { //carStage 배열을 초기에"주차가능"으로 표시
			if(carStage[i]==null) {
				carStage[i]="주차가능";
			}
		}
		
		while (true) {
			System.out.println("------------------------------------------");
			System.out.println("1.입차 2.출차(요금지출) 3.입출차현황 4.매출");
			System.out.println("------------------------------------------");
			System.out.print("선택>>> ");
			
			Scanner scanner = new Scanner(System.in);
			int ch = scanner.nextInt();
			// System.out.println(ch);
			if ( ch==1 ) { // 1.입차선택시
				System.out.println("차량번호를 입력하세요.");
				scanner.nextLine();
				String carNum = scanner.nextLine();
				for (int i=0; i<carList.length; i++) {
					if(carList[i]==null) {
						carList[i] = carNum;
						carStage[i] = "주차중";
						System.out.println("차량번호 : "+carList[i]+"가 등록되었습니다.");
						// System.out.println(carManage[i]);
						break;
					} // if e
				} // for e
			} else if (ch==2) { //2.출차선택시
				System.out.println("출차할 차량번호를 입력하세요.");
				scanner.nextLine();
				String carNum = scanner.nextLine();
				System.out.println(carList[0]);
				for (int i=0; i<carList.length; i++) {
					if(carList[i].equals(carNum) ) {
						SimpleDateFormat day1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Calendar now = Calendar.getInstance();
						String nowTime1 = day1.format(now.getTime());
						
						System.out.println("입차시간 : "+nowTime1);
						System.out.println("정산하실 금액은000입니다. 금액을 넣어주세요.");
						carList[i] = null;
						carStage[i] = "주차가능";
						break;
					} else {
						System.out.println("등록된 차량번호가 아닙니다.");
						break;
					}// if e
				}// for e
				System.out.println(Arrays.toString(carList));
				System.out.println(Arrays.toString(carStage));
				
			} else if (ch==3) { //3.입출차현황
				System.out.println("3번");
				for (int i=0; i<carList.length; i++) {
					if(carList[i] != null) {
						count++;
					}
				}
				System.out.println(Arrays.toString(carList));
				System.out.println(Arrays.toString(carStage));
				System.out.println("주차 가능한 차량수 : "+(9-count));
				System.out.println("주차중인 차량수 : "+count);
			} else if (ch==4) { //4.매출
				System.out.println("4번");
			}
			
		} // while e
	} // main e
} // class e
