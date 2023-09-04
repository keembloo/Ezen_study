
// write , update , delete : js 내장함수들 존재하기 때문에 충돌

//console.log('글쓰기 실행');
function bwrite(){
	//1.form 가져오기
	//console.log('실행중');
		// querySelectorAll() : 배열타입으로 여러개 dom 객체
		// querySelector() : 객체타입으로 한개 dom 객체
 	let writeForm = document.querySelectorAll('.writeForm')[0];
 	//console.log(writeForm);
 	// 2. form 데이터 객체화
 		// 일반객체로 첨부파일 전송 불가능 -> FormData 객체 이용시 첨부파일 전송가능
 	let writeData = new FormData(writeForm); // 첨부파일시 필수		 	
 	//console.log(writeData);
		 	
	$.ajax({
		url : "/jspweb/BoardInfoController" , 
		method : "post" ,
		data : writeData ,
		contentType : false , 
		processData : false ,
		success : r => {
			console.log(r);
			if (r) {
				alert('글등록완료');
				location.href="/jspweb/board/list.jsp";
			}
			else {alert('글등록실패');}
		} ,
		error : e=> {console.log(e)}
	})
	
	// 2.form 객체화 하기
	
	
	// 3. ajax로 대용량 form전송하기
	
	
}