
// 1. list.js에서 클릭된 게시물 번호 호출 [세션]
let no = sessionStorage.getItem('no');
let boardList = JSON.parse(localStorage.getItem('boardList'));

console.log(no);

// 2. 클릭된 게시물번호의 게시물찾아서 출력
onView();
function onView(){
	// 식별자 : 인덱스[] , 게시물번호 = 인덱스 찾기
	// 1. 어디에
	let title = document.querySelector('.title');
	let writerdate = document.querySelector('.writerdate');
	let content = document.querySelector('.content');
	
	// 2. 무엇을?
	// 1. 해당하는 게시물번호의 게시물찾기
	for(let i=0; i<boardList.length; i++){
		let b = boardList[i] // i번째 게시물을 꺼내기
		if (b.no == no) {
			//만약에 i번째 게시물번호와 클릭된 게시물 번호와 같으면
			console.log(b);
			// 3. 대입
			title.innerHTML = b.title;
			writerdate.innerHTML = `작성자 : ${b.wirter} 작성일 : ${b.date}`;
			content.innerHTML = b.content;
			break;
		}
	} //for end
} //f end

// 3. 현재 보고있는 게시물 삭제하기 [실행조건 : 삭제하기 버튼을 클릭했을때]
function onDelete(){ // 인수 ?? 삭제할식별자 x 전역변수에 있기 때문에
	if(confirm('정말 삭제하겠습니까?')){
		
		console.log(no);
		console.log(boardList);
		// 1. 게시물번호와 같은 번호를 가진 인덱스를 찾기
		for (let i=0; i<boardList.length; i++){
			//2. 클릭된 게시물(현재보고있는 게시물)와 i번재 게시물과 번호가 같으면
			let b = boardList[i]
			if (b.no == no) {
				// 배열에서 삭제
				boardList.splice(i, 1);
					// 배열에 변화된 결과를 쿠키/세션 [ js메모리 x ]에 반영
					localStorage.setItem('boardList' , JSON.stringify(boardList) );
					// 클릭된 게시물 삭제했으면 클릭된 게시물 번호는 세션에서 삭제
					sessionStorage.removeItem('no'); 
					//페이지전환
					location.href="list.jsp"
				// 4. 삭제후 다음 인덱스는 확인할 필요가 없다
				break;
			}
		} // for end
		
		
	} // if end
} // f end


























