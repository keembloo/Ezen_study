/*
----1페이지

1. 작성하기 버튼 누르면
2. 인풋값을 가져오기
3. 가져온 인풋값을 객체로 담기
- 작성자
- 비번
- 제목
- 내용
3. 배열을 만들어서 객체를 배열에 저장시키기 push
4. 작성이 완료되면 인풋값이 초기화됨


----2페이지

1. 1페이지에서 넘어온 배열(사용자인풋값)을 어디에 출력할건지 정하고 셀렉트지정
2. 추가될 html js에서 새로 작성
3. for문으로 html을 작성하기 버튼 누른만큼 추가로 생성시키기
4. 글을 누르는 횟수만큼 조회수가 카운트되서 올라감

글번호는 인덱스 ?

------3페이지

1. 2페이지에 게시글을 클릭하면 3페이지에 표시됨
2. 삭제 버튼을 누르면 비밀번호 확인창이뜸
3. 비밀번호가 맞으면 3페이지,2페이지에서 글이 삭제됨

*/

let 글정보 = [];
// 배열에 객체를 넣으면 글정보[4].작성자 <-이런식으로 빼오면됨

console.log (글정보.length); // 1

let 조회수 = 0;


function 작성하기() { 
	
	let name = document.querySelector('.input_name').value;
	let pw = document.querySelector('.input_pw').value;
	let title = document.querySelector('.input_title').value;
	let textBox = document.querySelector('.textbox').value;
	let 리스트 = {작성자 : name , 비밀번호 : pw , 제목 : title , 내용 : textBox , 날짜 : new Date()}
	console.log(리스트); // 확인용
	
	
	// 유효성 검사
	if (name =='' || pw =='' || title =='' || textBox =='' ) { alert('모두 빠짐없이 입력해주세요.'); return;} 
	if (pw.length <4) {alert('비밀번호는 4자 이상이어야합니다.'); return;}
		
	글정보.push(리스트);
	
	console.log('글정보배열 : '+글정보[0]); //확인용
	
	
	
	alert('작성되었습니다.');
	
	페이지생성();

/* 함축가능

	글정보.push(
		{
			작성자 : document.querySelector('.input_name').value , 
			비밀번호 : document.querySelector('.input_pw').value , 
			제목 : document.querySelector('.input_title').value , 
			내용 : document.querySelector('.textbox').value ,
			날짜 : new Date()
		});
*/
	
	//인풋값 초기화~
	document.querySelector('.input_name').value =``;
	document.querySelector('.input_pw').value = ``;
	document.querySelector('.input_title').value = ``;
	document.querySelector('.textbox').value = ``;
} // 작성하기 함수 e


console.log('글정보'+글정보);
console.log('글정보[0]'+글정보[0]);


function 페이지생성() {
	
	document.querySelector('#table').innerHTML =
		`<tr>
			<th>번호</th> <th>제목</th> <th>작성자</th> <th>작성일</th> <th>조회수</th>
		</tr>`
		
	for(let j=0; j<글정보.length; j++) { // 글정보의갯수만큼 html생성
	
		console.log(글정보[j]); //확인용
		console.log(글정보[j].날짜); // 확인용
		
		let 지금날짜 = 글정보[j].날짜.getFullYear()+"년"+( 글정보[j].날짜.getMonth()+1 ) +"월"
					+글정보[j].날짜.getDay()+"일"+글정보[j].날짜.getHours()+":"
					+글정보[j].날짜.getMinutes();

		document.querySelector('#table').innerHTML +=
		`<tr>
			<td>글번호</td> <td>제목</td> <td>${글정보[j].내용}</td> <td>${지금날짜}</td> <td>조회수값</td>
		</tr>`
	} //for e
} // 페이지생성 함수 e





