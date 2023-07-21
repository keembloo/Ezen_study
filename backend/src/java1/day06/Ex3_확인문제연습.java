package java1.day06;


import java.util.Arrays;
import java.util.Scanner;

public class Ex3_확인문제연습 { // class s
	public static void main(String[] args) { // main s
		
		Scanner scanner = new Scanner(System.in);
		int student=0;
		int[] scores = new int[student]; //배열선언 지금은 0임
		
		while (true) { // while s
		System.out.println("----------------------------------------------");
		System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		System.out.println("----------------------------------------------");
		System.out.print("선택> ");
		
		int ch1 = scanner.nextInt();
		if ( ch1 == 1) {
			System.out.println("학생수를 입력하세요");
			student = scanner.nextInt();
			System.out.println("입력한 학생수 : "+student);
			scores = new int[student]; // 입력한 값대로 배열길이에 추가
			System.out.println(Arrays.toString(scores));
		} else if (ch1 ==2) {
			for ( int i=0; i<scores.length; i++) {
				System.out.print("점수입력 scores["+i+"]> ");
				int 점수 = scanner.nextInt();
				scores[i] = 점수; // 각배열에 입력받은 점수 넣기
				System.out.println(Arrays.toString(scores));
			}
		} else if (ch1 ==3) {
			for (int i=0; i<scores.length; i++) {
				System.out.println("scores["+i+"]: "+scores[i]);
			}
		} else if (ch1 ==4) {
			int max=0;
			int sum=0;
			for (int i=0; i<scores.length-1; i++) {
				if( scores[i] > scores[i+1]) { // 최대값 구하기
					max= scores[i]; 
				} else {
					max=scores[i+1]; 
				}// if end
			} // for end
			for (int i=0; i<scores.length; i++) {
				sum += scores[i]; // 합계구하기
			}
				System.out.println("최고 점수: "+max);
				System.out.println("합계 점수: "+sum);
				System.out.println("평균 점수: "+(double)sum/student);
		} else if (ch1 ==5) {
			System.out.println("프로그램을 종료합니다");
			break;
		}	// if end
		
		
		}// while e
	} // main e
} // class e
