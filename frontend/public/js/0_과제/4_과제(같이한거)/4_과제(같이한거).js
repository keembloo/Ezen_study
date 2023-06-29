

// * 배열 = 여러개 객체(게시물)을 저장하는 배열
let boardlist = [];

// 1. 등록 이벤트 함수 [ 실행조건 : 등록 버튼을 클릭했을때 ]

function onWrite(){
	console.log('onWrite()함수');

	// 1. 입력받은 데이터 호출
		// 1. document.querySelector(식별자).value
	let writerValue = document.querySelector('#writer').value; 
	let passwordValue = document.querySelector('#password').value; 
	let titleValue = document.querySelector('#title').value; 
	let contentValue = document.querySelector('#content').value; 


	// 2. 게시물1개당 = 객체1개 선언/ 만들기 = 각 input으로 입력받은 값들을 각 속성명별로 대입해서 객체 생성
	let board = { writer : writerValue , password : passwordValue ,
					 title : titleValue , content : contentValue ,
					 date : new Date()  , view : 0}
					 
	 console.log(board); //확인용
	 
	 // 등록전에 유효성검사 자리 ----------------------------
	 
	 // ------------------------------------------
	 
	 // 3. 현재 { } 안에서 선언된 board는 } 끝나면 사라짐[지역변수] --> 전역변수/배열에 저장하자.
	 boardlist.push(board);
	 console.log(boardlist); // 확인용
	 
	 // * 새로운 게시물이 등록 되었으니까 게시물 출력 화면 업데이트
	 onPrint();
} //onWrite 함수 e 


// 2. 출력함수 [ 실행조건 : 1.스크립트 열렸을때  2. 등록할때마다  3.삭제될때마다  4.수정될때마다 5.조회수증가할때마다 ]
function onPrint(){ console.log('onPrint()함수실행');
	
	// 1. 어디에 출력할건지 ? 
	let boardTable = document.querySelector('#boardTable');
	
	// 2. 테이블 무엇을 대입/출력 할건지? 객체에 정보들을 객체 1개당 한줄씩<tr> 출력
	let html = `<tr>
					<th>번호</th> <th>제목</th> <th>작성일</th> <th>작성일</th> <th>조회수</th>
				</tr>`
	
	// 3. 대입
	boardTable.innerHTML = html;
	
	//배열내 순차적으로 하나씩 열어보자
	for( let i = 0; i<boardlist.length; i++) {
		
		let board = boardlist[i]; // i번재 배열 인덱스의 객체 호출
		html += `<tr> 
					<td> ${i+1} </td>
					<td onclick="onView(${i})"> ${board.title}</td>
					<td> ${board.writer}</td>
					<td> ${board.date}</td>
					<td> ${board.view}<td>
				</tr>`
	} // for end
	boardTable.innerHTML = html;
} // onPrint 함수 e


function onView(index) {console.log('뷰함수실행'+index);

	// 1. 어디에
	let viewbox = document.querySelector('#viewbox');
	
	// 2. 무엇을
	let html = `<div>제목 : ${boardlist[index].title}</div>
				<div>내용 : ${boardlist[index].content} </div>
				<div>작성자 : ${boardlist[index].writer}</div>
				<button>삭제</button>
				<button>수정</button>`;
	
	//3. 대입
	viewbox.innerHTML = html;
	
	// 조회수 증가시키기 (js변경)
	boardlist[index].view++;
	// 그리고 새로고침 (html 변경)
	onPrint();

} // onView 함수 e






















