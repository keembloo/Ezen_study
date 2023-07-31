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
		// 2. 객체를 배열에 저장 [ 빈공간을 찾아서 빈공간 저장
		// 2. 객체를 리스트에 저장
		BoardDao.getInstance().boardDtoList.add(boardDto);
		// 성공 [ true ] 또는 실패 [false]
		return true;
	}
	// 글출력 처리 기능함수 [ R ] 
	public BoardDto printLogic(int index) {
		// 1. 리스트안에 있는 객체 호출 .get(인덱스) : 해당 인덱스의 객체 호출
		BoardDto boardDto = BoardDao.getInstance().boardDtoList.get(index);
		// 2. 호출된 dto를 리턴하기
		return boardDto;
	}
	
	// 글수정 처리 기능함수 [ U ] : 수정할 게시물 인덱스, 수정할 내용 , 수정할 작성자"
	public void updateLogic() {
		
	}
	// 글삭제 처리 기능함수 [ D ] : 
	public boolean deleteLogic(int index) {
		// 1. 리스트 안에 있는 객체 삭제 .get(인덱스) : 해당 인덱스의 객체 호출
		BoardDao.getInstance().boardDtoList.remove(index);
		// 2. 삭제여부 반환
		return true;
	}
}
