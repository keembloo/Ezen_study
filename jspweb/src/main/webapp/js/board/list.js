
// 1. 글스기 버튼을 클릭하면
function onWrite(){
	if(loginState){
		location.href="/jspweb/board/write.jsp";
	} else{ // - 로그인이면 쓰기 페이지로 이동
		alert('로그인후 글쓰기 가능합니다.')
		location.href="/jspweb/member/login.jsp"
	}
	// 만약에 비로그인이면
	// 로그인이면
}

//
onView();
function onView(){
	let sample = `<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>글작성일</th>
			</tr>`;
	let html=``;
	let table = document.querySelector('.table');
	
	$.ajax({
		url : "/jspweb/BoardInfoController" , 
		method : "get" ,
		data : {},
		contentType : false , 
		processData : false ,
		success : r => {} , 
		error : e => {}		
	})
}