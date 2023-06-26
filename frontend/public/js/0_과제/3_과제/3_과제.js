/*- 과제3 : 가계부 만들기 ( 과제3.HTML , 과제3.JS , 과제3.CSS )
요구사항
   - 1.배열 3개 사용 ( 날짜배열 , 항목배열 , 금액배열 ) / 객체X { }
   - 2.함수 3개 이상 정의해서 구현 
   - 3.총합계는 계산해서 테이블 가장 하단에 출력하시오.
   - 4. 해당 삭제 버튼 클릭시 해당 항목 제거 
   - 5. 출력시 숫자를 천단위 쉼표로 출력하시오. [ toLocaleString() 함수( 천단위쉼표가 있는 문자열로 변환)  ]
      - let 금액 = 1200000
      - 금액.toLocaleString( ) => '1,200,000'
   - 6. css 적절하게 적당히 꾸며서 제출해주세요.

ex) 입력 예시 [ input 3개 사용 ]
   날짜 : <input type="date" />
   항목 : <input type="text" />
   금액 : <input type="text" />

ex) 출력 예시 [ table 사용 ]
   날짜         항목      금액         비고
   2023-06-06   콜라      300        삭제버튼
   2023-06-05   노트북   1,200,000   삭제버튼
   2023-06-03   교통비   1,750       삭제버튼
      -총합계-         1,202,050    */  



//1. 빈배열 만들기
let 날짜배열 = [];
let 항목배열 = [];
let 금액배열 = [];

//2. 테이블 변수 만들기
let table = document.querySelector('.table'); // 테이블 지정
let date = document.querySelector('.dateitem'); // 날짜 지정
let list = document.querySelector('.listitem'); // 항목 지정
let price = document.querySelector('.priceitem'); // 가격 지정
		
		
function clickevent() { //클릭이벤트 함수 s

	console.log('클릭');	
	//유효성 검사
	if (date.value =='') {
		alert("날짜를 입력하지 않았습니다.")
	} else if (list.value =='') {
		alert("항목을 입력하지 않았습니다.")
	} else if (price.value =='') {
		alert("금액을 입력하지 않았습니다.")
		return; // 함수종료 이거 안쓰면 밑에코드실행되는데 나는 밑에코드를 안적음...ㅎ...
	} 
	
	//3. 항목 배열에 항목값 넣기
	날짜배열 += date.value;
	console.log(날짜배열);

	//4. 날짜 배열에 날짜 넣기
	항목배열 += list.value;
	console.log(항목배열);
	
	//5. 금액 배열에 금액 넣기
	금액배열 += price.value;
	console.log(금액배열);
	지정항목();

	//실행후 남아있는 인풋값 초기화
	date.value ='';
	list.value ='';
	price.value='';
} // 클릭이벤트 함수 e



	//값들을 테이블에 추가하기
function 지정항목(){ //지정항목 함수 s
		// 기존 값까지 같이 추가 되는데 이거 수정해야함....
	document.querySelector('.table').innerHTML += 
		`<tr>
			<th>${날짜배열}</th>
			<th>${항목배열}</th>
			<th>${금액배열}</th>
			<th>취소버튼</th>
		</tr>`;
	
} //지정항목 함수 e

























