

// 1. 로또 구매 함수 정의
function 로또구매(){
	console.log('실행됨');
	// 1. 1~45개의 button 생성
	let buttonHTML =``;
	
	for(let i=1; i<=45; i++){ // for s
		// i는 1부터 45까지 1씩증가 반복
		
		//버튼 하나씩 변수에 추가
		buttonHTML +=
		`<button onclick="숫자버튼(${i})"> ${i} </button>` // i번째 버튼생성
			// i로 출력된 숫자(1~45 사이 1개)중 클릭된 숫자를 숫자버튼함수에게 전달
		
		if(i%5 == 0) {
			buttonHTML += `<br/>`
		}
	} // for e

	// 2. 
	document.querySelector('.btns').innerHTML = buttonHTML;
}	// F END


//2. 숫자 (선택) 버튼 함수 정의
function 숫자버튼( 선택된번호 ){
	console.log( 선택된번호 + '숫자버튼을 클릭했군요.')
}