

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

		// 날짜 양식으로 출력
		let now = new Date(); // 1. 현재 시스템(pc)의 날짜/시간 호출
		let year = now.getFullYear(); // 현재연도
		let month = now.getMonth(); // 현재월 [0 : 1월  / 1 : 2월]
		let week = now.getDay(); 	// 현재 일 [ 0:일요일 1:월요일 2:화요일 ~ 6:토요일 ]
		let day = now.getDate();	//  
		let hour = now.getHours();	// 현재 시
		let minute = now.getMinutes(); //현재 분
		let second = now.getSeconds(); //현재 초
		
		
	// 2. 게시물1개당 = 객체1개 선언/ 만들기 = 각 input으로 입력받은 값들을 각 속성명별로 대입해서 객체 생성
	let board = { writer : writerValue , password : passwordValue ,
					 title : titleValue , content : contentValue ,
					 date : `${now.getFullYear()}년 ${now.getMonth()+1}월 ${now.getDay()}일
					 		${now.getHours()} : ${now.getMinutes()} : ${now.getSeconds()}` , 
					 view : 0 }
					 
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
		
		let board = boardlist[i]; // i번째 배열 인덱스의 객체 호출
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
				<button onclick="onDelete(${index})">삭제</button>
				<button>수정</button>`;
	
	//3. 대입
	viewbox.innerHTML = html;
	
	// 조회수 증가시키기 (js변경)
	boardlist[index].view++;
	// 그리고 새로고침 (html 변경)
	onPrint();

} // onView 함수 e


// 4. 삭제함수
function onDelete(index){ console.log('삭제함수실행'+index);
	
	// 1. 배열내 삭제할 인덱스의 객체 호출
	let board = boardlist[index];
	
	// 2.prompt()함수로 입력받은 값을 password 변수에 저장
	let password = prompt('비밀번호 : ');
	
	// 3. 비교 [삭제할 객체내 비밀번호와 입력받은 비밀번호와 일치하면 삭제 성공]
	if(board.password == password){
		// 4. 배열내 해당 객체 삭제
		boardlist.splice(index , 1); // 삭제할 인덱스번호부터 1개 삭제
		// 5. 화면 새로고침
		onPrint(); // 전체 게시물 출력 화면 새로고침
		
		document.querySelector('#viewbox').innerHTML = ``;
		 // 현재 개별 게시물 출력 화면 없애기
		
		alert('[삭제성공] 게시물이 삭제되었습니다.');
		
	} else { //일치하지 않으면
		alert('[삭제실패] 비밀번호가 일치하지 않습니다.');
	}
} // onDelte 함수 e



















