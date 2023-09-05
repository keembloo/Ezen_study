
// 1. 글쓰기 버튼을 클릭하면
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


/* 게시물 조회 조건 객체 */
let pageObject = {
	type : 1 , bcno : 0 , listsize : 3 , 
	page : 1 // * page : 조회할 페이지번호
}
	// * type: 1:전체출력, 2:개별조회
	// * bcno : 조회할 카테고리번호 [ 기본값은 전체보기 ]
	// * listsize : 하나의 페이지에 최대 표시할 게시물수 [ 기본값은 10개 ]
// 3. 카테고리 버튼을 클릭했을때
function onCategory(bcno){
	console.log('클릭된 카테고리 : '+bcno);
	pageObject.bcno = bcno; // 조회 조건객체내 카테고리번호를 선택한 카테고리로 변경
	onView(1);
} // f end

//4 .한페이지 최대 표시할 개수를 변경했을때
function onListSize(){
	pageObject.listsize = document.querySelector('.listsize').value; //선택된 게시물수를 조회조건객체 저장
	onView(1);
}





//2. 모든글 조회 [ js 열렸을때 1회 자동실행 ]
onView(1);
function onView(page){
	pageObject.page = page;
	// 클릭된 페이지번호를 조건객체에 대입

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
		data : pageObject ,
		success : r => { //console.log(r);
			// 배열명.forEach  // java -> , js => 
			r.boardList.forEach( b => {
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
			pageboxView(page , r);
		} , 
		error : e => {console.log(e);}		
	})
}

// 페이지 번호 출력 함수 
function pageboxView(page , r){
	//console.log('실행된다');
	//page : 조회한 페이지 번호 [ 현재 보고 잇는 페이지 번호 ]
	// 이전버튼 [page<=1? page: page-1] 만약에 1페이지에서 이전버튼 클릭시 1페이지로 고정하고 아니면 1차감
	let pagebox = document.querySelector('.pagebox');
	let html = ``;
	let before = `<button onclick="onView(${page<=1? page: page-1})" type="button"> < </button>`;
	// 페이지 번호 버튼 [ * 페이지 개수만큼 반복 ]
	for (let i=1; i <= r.totalpage ; i++){
		// 만약에 현재페이지와 i번째 페이지가 일치하면 버튼태그에 class="selectpage" 추가
		html += `<button class="${page==i ? 'selectpage' : '' }" onclick="onView(${i})" type="button"> ${i} </button>`;
	}
	// 다음버튼 [ page >= r.totalpage ? page : page+1 ] 만약에 현재페이지가 마지막페이지면 고정 아니면 1증가
	let after = `<button onclick="onView(${page >= r.totalpage ? page : page+1})" type="button"> > </button>`;
	
	//console.log("html + "+html);
	pagebox.innerHTML = before + html + after;
	
	// ----------------------------- 3. 게시물 수 출력 --------------------------- 
	let boardcount = document.querySelector('.boardcount');
	boardcount.innerHTML = `총 게시물 수 : ${r.totalsize}`;
	
}






















