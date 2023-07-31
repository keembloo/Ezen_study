package java1.day13.Ex2.controller;

import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class BoardController {
	// --------------------- 싱글톤 ------------------------- //
	// 싱글톤(공유)O : 게시물마다가 아닌 모든 게시물이 하나의 객체를 통해 동일한 기능 수행
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() {
		return boardController;
	}
	private BoardController() {	}
	// ------------------------------------------------------//
	
	// 글등록 처리 기능함수 [ C ]
	public boolean writeLogic( String content , String writer) {
		// 1. 매개변수로부터 전달받은 content , writer 를 하나의 객체로 선언
		BoardDto boardDto = new BoardDto(content, writer);
		// 2. 객체를 배열에 저장 [ 빈공간을 찾아서 빈공간 저장]
		for (int i =0; i<BoardDao.getInstance().boardDtoArray.length; i++) {
			if(BoardDao.getInstance().boardDtoArray[i] == null) {
				BoardDao.getInstance().boardDtoArray[i] = boardDto;
			} // if e
		} // for e
		// 2. 객체를 리스트에 저장
		BoardDao.getInstance().boardDtoList.add(boardDto);
		
		// 성공 [ true ] 또는 실패 [false]
		return false;
	}
	// 글출력 처리 기능함수 [ R ] 
	public void printLogic() {System.out.println("글보기 컨트롤까지도착");}
	// 글수정 처리 기능함수 [ U ]
	public void updateLogic() {System.out.println("글수저정 컨트롤까지도착");}
	// 글삭제 처리 기능함수 [ D ]
	public void deleteLogic() {System.out.println("글삭제 컨트롤까지도착");}
}
