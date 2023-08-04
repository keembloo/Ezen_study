package 과제.과제11;

import 과제.과제11.view.MainPage;

public class AppStart {
	public static void main(String[] args) {
		MainPage.getInstance().mainView();
		// 1. MainPage.getInstance() : MainPage 싱글톤객체 호출 ( 해당 객체의 메소드 호출 )
			// 반환 => mainPage.mainView()객체가 반환된다. 
			// 2. mainPage.mainView()
			// getInstance()에서 반환된 객체(싱글톤객체)가 mainView() 함수를 호출 
	} // main e 
} // class e
