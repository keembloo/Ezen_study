
// 1. list.js에서 클릭된 게시물 번호 호출 [세션]
let no = sessionStorage.getItem('no');
let boardList = JSON.parse(localStorage.getItem('boardList'));

console.log(no);

// 2. 클릭된 게시물번호의 게시물찾아서 출력
onView();
function onView(){
	// 식별자 : 인덱스[] , 게시물번호 = 인덱스 찾기
	// 1. 해당하는 게시물번호의 게시물찾기
	for(let i=0; i<boardList.length; i++){
		let b = boardList[i] // i번째 게시물을 꺼내ㅓ기
		if (b.no == no) {
			//만약에 i번째 게시물번호와 클릭된 게시물 번호와 같으면
			console.log(b);
			break;
		}
	} //for end
} //f end