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
				{ name : '치킨킹' , price : 8000 , img : '치킨킹.png' , category : 3 }];

	// 1. 카트(장바구니) 배열 / 선택 버거들이 저장되는 배열
		// 1. 버거객체 2. 버거의식별 = 중복x -> 버거 제품번호대신 배열 인덱스
let cartList = [];
	// 1. 주문(주문내역) 배열										[ 정해져있는 데이터들은 숫자로 저장 => 권장 ]
		/* 주문 { 주문번호 : , 주문날짜 : , 결제금액 : , 주문제품 : [] , 상태 : 0[주문요청] 1[주문완료] 2[주문취소] } */	
let orderList = [
	{ ono : 1 , date : '2023-07-05 13:30' , pay : 30000 , products : [ 0 , 0 , 2] , state : 1 }];


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
	productPrint( selectNo );
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
	productPrint( selectNo );
}

// 4. 제품 출력 함수 [ 실행 조건 : 1. 카테고리 클릭(변경)되면 -> 2번,3번함수에서 호출 ]
function productPrint( categoryNo ){ // 어떤 카테고리의 제품 출력할건지 ?? 인수 판단
	// 1. 어디에
	let productbox = document.querySelector('.productbox');
	// 2. 무엇을 [ 선택된 카테고리에 맞는 제품들만 출력 ]
	let html = ``;
		// html 구성
		for( let i = 0; i<burgerList.length; i++){ //모든 버거리스트 열어서 하나씩 확인
			// i번재 버거의 카테고리와 선택한 카테고리가 같으면 html 구성 / 아니면 구성x
			if(burgerList[i].category == categoryNo){
				html += `<div onclick="productSelect(${i})" class="product">
							<img src="../img/${burgerList[i].img}"/>
							<div class="pinfo">
								<div class="pname">${burgerList[i].name}</div>
								<div class="pprice">${burgerList[i].price.toLocaleString()}원</div>
							</div>
						</div>`;
			} // 
		} // f end
		
	// 3. 출력[대입]
	productbox.innerHTML = html;
} // f end

// 5. 제품 선택해서 카트에 담는 함수 [ 실행 조건 : 1. 제품 구역 클릭하면 ]
function productSelect( productNo ){ // 어떤 제품을 카트에 담을건지?? 인수 판단
	console.log( burgerList[productNo].name );
	// 1. 선택된 버거의 인덱스를 배열에 저장 [버거 모든 정보를 저장할 필요가 없음]
	cartList.push(productNo);
	console.log(cartList);
	//2. 카트에 저장했으면 카트화면 출력
	cartPrint();
} // f end
	
	
// 6. 카트내 버거들을 출력 함수 [실행조건 : 1. 카트내 제품등록되면(5함수 하단 호출) 2.카트내 제품 취소되면(7,8함수 하단 호출)]
function cartPrint() { // 인수판단 : 모든 카트내 제품 출력

	// 1. 어디에
	let cartbottom = document.querySelector('.cartbottom');
	// 2. 무엇을? 카트내[배열내] 모든 제품 출력
	let html =``;
		let totalPrice = 0; // 카트내 버거들의 가격을 모두 더한 값을 저장 변수
		for( let i=0; i<cartList.length; i++){
			// 1. 카트내 버거의 인덱스
			let burgerIndex = cartList[i];
			console.log(burgerIndex);
			// 2. i번재 제품을 html 구성	
			html += `<div class="citem">
						<div class="iname">${burgerList[burgerIndex].name}더블비프 불고기버거</div>
						<div class="iprice">${burgerList[burgerIndex].price.toLocaleString()}원</div>
						<span onclick="productCancel(${i})" class="icancel">X</span>
					</div>`;
			// 3. i번재 가격을 누적합계
			totalPrice += burgerList[burgerIndex].price;
		} // for end
	
	// 3. 대입/출력
	cartbottom.innerHTML = html;
	// 카트내 제품수
	document.querySelector('.ccount').innerHTML = `${cartList.length}`;
	// 카트내 제품 총 가격
	document.querySelector('.ctotal').innerHTML = `${totalPrice.toLocaleString()}원`;	
	// 만약에 카트내 제품이 많아서 가로 스크롤 생성 되었을때 자동으로 가장 오른쪽으로 이동
	cartbottom.scrollLeft = 10000;										
} // f end

// 7. 카트내 버거 부분 취소 함수 [ 실행조건 : x버튼을 클릭했을때 ]
function productCancel(cartIndex){ // 전체취소:인수x 부분취소 : 인수o
	// 1. 선택된 카트배열내 인덱스 삭제
	cartList.splice(cartIndex , 1);
	alert('버거 취소 했습니다');
	
	// 2. 카트 화면 업데이트
	cartPrint();
} // f end

// 8. 카트내 버거 전체 취소 함수 [ 실행조건 : 취소하기 버튼을 클릭했을때]
function cartCancel(){ // 전체취소 : 모두취소 : 인수x 
	cartList.splice( 0 ); // 배열내 모든 요소 삭제 
	cartPrint(); // 2. 카트 화면 업데이트
} // f end

/* 주문 { 주문번호 : , 주문날짜 : , 결제금액 : , 주문제품 : [] , 상태 : 0[주문요청] 1[주문완료] 2[주문취소] } */	
// 9. 카트내 저장된 버거 주문(등록) 함수  [ 실행조건 : 주문하기 버튼을 클릭했을때]
function productOrder(){
	alert('주문했습니다.');
	// 주문번호 만들기 // 마지막 인덱스 : 배열명.length-1
	let ono = orderList[orderList.length-1].ono; // 주문배열내 마지막주문의 번호
	// 카트(전역변수)에 있던 버거인덱스를 새로운 배열에 저장
	let products = []; //주문이 들어가는 버거들인덱스
	let totalPrice = 0;
	for( let i = 0; i<cartList.length ; i++){
		products.push(cartList[i]); // i번째 버거의 인덱스를 새로운 배열에 저장
		totalPrice += burgerList[cartList[i]].price;
	}
	//1. 주문객체 생성해서
	let order = {
		ono : ono+1 , 		// 주문번호 생성해서 저장 [ 마지막 주문번호 +1 ] 
		date : new Date() , // 현재날짜/시간 구해주는 함수 이용해서 자동으로 대입
		pay : totalPrice , 			// 카트내 제품들의 총가격
		products : products ,		// 카트에있던 모든 제품들 // 전역변수 [cartList] 대입시 문제 발생
		state : 0			// 주문 객체 생성시 주문요청으로 상태 초기로 사용
	}
	//2. 주문배열에 저장하기
	orderList.push( order ); alert('주문이 들어갔습니다.');
		
	//카트초기화
	cartCancel(); // 전체취소 함수로 동일하기 때문에 재호출
	//주문리스트확인
	console.log(orderList);
} // f end




















