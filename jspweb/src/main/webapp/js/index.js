
findByTop(5); // 테스트 메인페이지에 최신등록된 제품 5개 출력
//findByPno(3); // 테스트
//findByAll(); // 테스트 
// 1. n개 제품들을 최신순으로 출력
function findByTop( count ){
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method:"get",
		data:{ type: "findByTop" , count : count },
		success : jsonArray => {
			console.log(jsonArray);
			let productBox = document.querySelector('.productBox');
			let html = '';
			
				jsonArray.forEach((p)=>{
					// 대표 이미지 출력하기 [첫번째 이미지] / Object.keys(객체명) : 해당 객체내 모든 속성명/필드명/키 를 리스트로 반환
					//console.log(p.imgList); 	// 제품별 이미지 객체
					//console.log(Object.keys(p.imgList)); 	// 제품별 이미지 객체의 속성명 리스트
					//console.log(Object.keys(p.imgList)[0]); 	// 제품별 이미지 객체의 속성명 리스트 중에 첫번째 속성명
					//console.log(p.imgList[Object.keys(p.imgList)[0]]); 	// 제품별 이미지 객체의 속성명 리스트 중에 첫번째 속성명의 사진이름
					
					let firstImg = p.imgList[Object.keys(p.imgList)[0]];
					html += `<div class="col">
								<div class="card">
									<img src="/jspweb/product/img/${firstImg}" class="card-img-top" alt="...">
									<div class="card-body">
										<h5 class="card-title">${p.pname}</h5>
										<p class="card-text">
											<div> ${p.pcontent}</div>
											<div> ${p.pprice.toLocaleString()}원</div>
										</p>
									</div>
								</div>
							</div>`;
				})
			
			productBox.innerHTML = html;
		}
	})
	
}

//2. 현재 카카오지도내 보고있는 동서남북 기준내 제품들을 출력 함수
function findByLatLng( east , west , south , north ){
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method:"get",
		data:{ type: "findByLatLng" , east : east , west : west , south : south , north : north },
		success : jsonArray => {
			console.log(jsonArray);
		}
	})
	
}

//3.
function findByPno( pno ){
		$.ajax({
		url : "/jspweb/ProductInfoController",
		method:"get",
		data:{ type: "findByPno" , pno : pno },
		success : jsonObject => {
			console.log(jsonObject);
		}
	})
	
}

//4.
function findByAll() {
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method:"get",
		data:{ type: "findByAll" },
		success : jsonArray => {
			console.log(jsonArray);
		}
	})
}

/*

	자바스크립트 객체
		형태 : let 변수명 = { 키 : 데이터 , 키 : 데이터 , 키 : 데이터 }
			- 데이터 : 데이터(상수/변수) , 함수 , 배열/리스트 등등
			추가 : 객체명.새로운필드명 = 데이터
			삭제 : delete 객체명.삭제할속성명			사용자정의 함수(개발자가 만드는함수)중에 delete 라는 이름으로 선언 불가능
			호출 : 객체명.속성명	or	객체명['속성명']
				- Object.keys( 객체명 ) : 객체내 모든 키를 배열로 반환
				- Object.values( 객체명 ) : 객체내 모든 데이터를 배열로 반환
				
				
	자바스크립트 배열/리스트
		형태 : let 변수명 = [ 데이터, 데이터, 데이터 ]
			추가 : 배열명.push(데이터)
			삭제 : 배열명.splice(인덱스,개수)
			호출 : 배열명[인덱스]
				- 배열명.length : 배열의 길이
				
*/