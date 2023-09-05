
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

//2. 모든글 조회 [ js 열렸을때 1회 자동실행 ]
onView();
function onView(){
	let sample = `<tr>
				<th>글번호</th>
				<th>카테고리</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>글작성일</th>
			</tr>`;
	let html=``;
	let table = document.querySelector('.table');
	
	$.ajax({
		url : "/jspweb/BoardInfoController" , 
		method : "get" ,
		data : {type : 1},
		success : r => { console.log(r);
			// 배열명.forEach  // java -> , js => 
			r.forEach( b => {
				html+= `<tr>
							<td>${b.bno}</td>
							<td>${b.bcname}</td>
							<td> <a href="/jspweb/board/view.jsp?bno=${b.bno}"/> ${b.btitle} </a> </td>
							<td>${b.mid} <img src="/jspweb/member/img/${b.mimg}"/></td>
							<td>${b.bview}</td>
							<td>${b.bdate}</td>
						</tr>`;
			});
			//<img src="/jspweb/member/img/${b.mimg}"/>
			// 3. 구성된 html내용 출력 
			table.innerHTML = sample+html;
		} , 
		error : e => {}		
	})
}