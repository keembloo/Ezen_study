console.log('update.js실행');

// 1. 썸머노트 실행할때 사용되는 코드
$(document).ready(function() {
//  $('#summernote').summernote( {설정객체});
	$('#summernote').summernote({
		lang : 'ko-KR' , // 한글적용 [ 한글.JS CDN 필요]
		height: 500 ,
		placeholder: '여기에 내용작성'
	});
});
//------------------------------------------

// 2. 수정할 게시물 = 클릭된 게시물 = 현재 보고 있는 게시물 [게시물 번호 = 세션]
let no = sessionStorage.getItem('no');	console.log( no );
let boardList = JSON.parse(localStorage.getItem('boardList'));	console.log( boardList );
onView();

// 2. 수정할 게시물 출력
function onView(){
	// 1. 어디에 [ input , textarea ]
	let title = document.querySelector('.title');
	let content = document.querySelector('#summernote');
	// 2. 무엇을[ 클릭된 게시물의 정보 1개 ]
	for(let i=0; i<boardList.length; i++){
		let b = boardList[i];
		if( b.no == no){
			//3. 출력/대입
			title.value = b.title;
			content.value = b.content;
			break;
		}
	}
} // F end


// 3. 수정 함수 [ 실행조건 : 등록버튼 클릭했을때 ]
function onUpdate(){
	let title = document.querySelector('.title').value;
	let content = document.querySelector('#summernote').value;
	// 세션에도 저장시키고
	console.log(title);
	console.log(content);

	
	
	
	// 게시판으로 페이지 이동
	// location.href="list.jsp"
}; // f end























