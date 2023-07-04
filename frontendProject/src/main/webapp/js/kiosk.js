console.log('키오스크js열림');

console.log('js열림');

// 1. 광고이미지 변경
	// 1. 광고 이미지 여러개 = 배열 
let bimgList = ['himg1.png', 'himg2.png', 'himg3.jpg', 'himg4.png', 'himg5.png'];
// 2. 특정시간마다 이미지의 src 변경 하기
	// - setInterval (함수/기능, 밀리초)  함수 : 1/1000초
	// 1. function 함수()  2.function (){}  3. () => {}
	// setInterval( ()=>{실행코드} , 2000 ); // 2초마다 실행코드 주기적으로 실행
let viewhimg = 0; //현재 출력중인 광고 이미지 인덱스 저장하고 있는 변수
setInterval(() => {
	//1.어디에
	let himg = document.querySelector('.himg');
	// 2. 호출된 객체에서 src 속성 대입/바꿔치기
		// 배열내 이미지 하나씩 바꿔가면서 대입
	viewhimg++; // 인덱스 증가시킴 [ 다음이미지로 변경]
			//만약에 마지막 인덱스 다음이면 처음 인덱스 이동
	if (viewhimg >= bimgList.length) {
		viewhimg = 0;}
	himg.src = `../img/${bimgList[viewhimg]}`;
}, 2000);


// 2. 카테고리 출력 [어디에 무엇을 출력? ] 함수 
	// 1. 카테고리 여러개 저장하는 배열
let categoryList = ['신제품(NEW)' , '프리미엄' , '와퍼&주니어' , '치킨&슈프림거버' , '올데이킹&킹모닝']
	// 2. 카테고리 출력 함수 정의 [실행조건 : 1. 페이지 열렸을때 ]
categoryPrint(); // 최초1번실행
	
function categoryPrint() {
	// 1. 어디에 
	let categorymenu = document.querySelector('.categorymenu');
	// 2.무엇을
	let html = ``;
		//html 구성 : 배열내 모든 데이터를 (for) li 형식으로 출력
	for ( let i = 0; i<categoryList.length; i++){
		html +=`<li class="categoryselect">${categoryList[i]}</li>`;
	}
	// 3. 구성된 html 출력
	categorymenu.innerHTML = html;
}


// 3. 카테고리 클릭 함수


// 4. 제품 출력

// 5. 제품 선택 