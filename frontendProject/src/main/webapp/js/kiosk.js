console.log('키오스크js열림');

console.log('js열림');
//-------------------------샘플데이터 ------------------------//
// 1. 광고이미지 변경
	// 1. 광고 이미지 여러개 = 배열 
let bimgList = ['himg1.png', 'himg2.png', 'himg3.jpg', 'himg4.png', 'himg5.png'];
	// 1. 카테고리 여러개 저장하는 배열
let categoryList = ['신제품(NEW)' , '프리미엄' , '와퍼&주니어' , '치킨&슈프림거버' , '올데이킹&킹모닝'];
	// 1. 제품 여러개 저장하는 배열
		// 서로 다른 유형들의 데이터 여러개 저장 = 객체 { }
		// 동일한 유형들을 여러개 저장 = 배열/리스트 [ ]
		// 버거이름 , 버거가격, 버거 이미지, 버거카테고리
		// [{ 버거이름 , 버거가격, 버거 이미지, 버거카테고리 } , { 버거이름 , 버거가격, 버거 이미지, 버거카테고리 }]
		// 다른 배열이나 객체의 연관관계
		// 카테고리(상위) -- 제품(하위) // 카테고리 식별값 -- 제품에 저장 [pk-->fk]
let burgerList = [
				{ name : '헬로디아블로와퍼' , price : 9500 , img : '헬로디아블로와퍼.png' , category : 0 } ,
				{ name : '헬로릴리트와퍼' , price : 12500 , img : '헬로릴리트와퍼.png' , category : 0 } ,
				{ name : '치킨킹' , price : 8000 , img : '치킨킹.png' , category : 3 }
];

//-----------------------------------------------------------//





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
	if (viewhimg >= bimgList.length) {
		viewhimg = 0;}//만약에 마지막 인덱스 다음이면 처음 인덱스 이동
	himg.src = `../img/${bimgList[viewhimg]}`;
}, 2000);


// 2. 카테고리 출력 [어디에 무엇을 출력? ] 함수 

	// 2. 카테고리 출력 함수 정의 [실행조건 : 1. 페이지 열렸을때 ]
categoryPrint(0); // 최초1번실행 [ 가장 앞에있는 카테고리 선택 가정 ]
	
function categoryPrint( selectNo ) {
	// 1. 어디에 
	let categorymenu = document.querySelector('.categorymenu'); 
	// 2.무엇을
	let html = ``;
		//html 구성 : 배열내 모든 데이터를 (for) li 형식으로 출력
	for( let i = 0 ; i<categoryList.length ; i++ ){
		// 선택된카테고리(selectNo) 와 i 와 같으면 i번재 인덱스 선택된 카테고리 
		if( i == selectNo ){ html += `<li onclick="categorySelect( ${ i } )" class="categoryselect">${ categoryList[i] }</li>`  }
		else{ html += `<li onclick="categorySelect( ${ i } )" >${ categoryList[i] }</li>`  }
	}
	// 3. 구성된 html 출력
	categorymenu.innerHTML = html;
}


// 3. 카테고리 클릭 함수	[실행조건 : 1. li에서 클릭했을때]
function categorySelect(selectNo) {
	// li태그 여러개중 무엇을 선택했는지 식별
	console.log(selectNo);
	
	// 0. 카테고리의 모든 li호출 [quertySelctor 1개호출 = 객체1개 vs querySelectorAll 여러개호출 = 여러개객체(배열)]
	let categoryli = document.querySelectorAll('.categorymenu li'); // 해당 클래서 ul 안에 있는 li 호출
		console.log(categoryli);
	
	
	// 1. 해당 선택된 인덱스의 class 추가 // !!! JS에서 class추가 / 삭제 가능
	for(let i =0; i<categoryList.length; i++) {
		// 2. 선택된 인덱스[selectNo]의 i번째 카테고리찾기
		if(selectNo == i){
			// 해당 li에 class 추가	DOM객체명.classList.add('새로운클래스명)
			categoryli[i].classList.add('categoryselect');
		} else {
			// 해당 li에 class 삭제	DOM객체명.classList.remove('새로운클래스명)
			categoryli[i].classList.remove('categoryselect');
		}
	}
}

// 4. 제품 출력

// 5. 제품 선택 