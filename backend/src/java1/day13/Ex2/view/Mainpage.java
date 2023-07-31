package java1.day13.Ex2.view;

import java.util.Scanner;

public class Mainpage {
	// --------------------- 싱글톤 ------------------------- //
	// 싱글톤(공유)O : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	// 1. 현재클래스안에 현재클래스로 객체 선언 [private static]
	private static Mainpage mainpage = new Mainpage();
	// 2. 외부로부터 간접적으로 싱글톤이 호출되도록 하는 함수
	public static Mainpage getInstance() {
		return mainpage;
	}
	// 3. 외부로부터 객체 생성 차단
	private Mainpage() { }
	// ------------------------------------------------------//
	
	// 입력객체 필드
	private Scanner sc = new Scanner(System.in);
	
	// 메인페이지 입출력 함수
	public void MainView() {
		while(true) {
			System.out.println("\n\n -----------방문록 프로그램------------");
			System.out.print("1.글등록 2.글보기 3.글삭제 4.글수정 선택> ");
			int ch = sc.nextInt();
			if( ch==1) {}
			if( ch==2) {}
			if( ch==3) {}
			if( ch==4) {}
		} // while e
	} // f e
	
	// 글등록 페이지 입출력 함수
	
	// 글출력 페이지 입출력 함수
	
	// 글삭제 페이지 입출력 함수
	
	// 글수정 페이지 입출력 함수
	
}
