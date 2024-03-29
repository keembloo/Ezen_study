

// 1. 제품 등록
function onRegister(e){
	
	// 1. form dom객체 호출 
	let registerForm = document.querySelectorAll('.registerForm')[0];
	console.log('registerForm'+registerForm);
	// 2. formData 객체 생성 [ ajax 전송타입 : multipart/form-data ]
	let formData = new FormData(registerForm);
	console.log(formData);
	
		// *** 카카오지도에서 선택된 좌표 사용했을때
		if (현재경도 ==0 || 현재위도 == 0){
			alert('제품위치를 선택해주세요');
			return;
		}
		formData.set('plat' , 현재위도);
		formData.set('plng' , 현재경도);
		
		// *** 드랍앤드랍을 사용했을때
			// 현재 드랍된 파일들을 form에 같이 추가하기 [드랍된 파일은 input태그 드랍된 파일이 아니므로]
		if(fileList.length >= 1){ // 드랍된 파일이 1개 이상이면
			fileList.forEach(f=>{
				// 폼데이터객체에 데이터를 추가하는 방법
				// formData.set('fileList' , f);
				// 폼데이터객체.set('키/필드명/속성명' , 값);	
				// : 만약에 기존의 동일한 키가 있으면 덮어쓰기 되므로 기존 사라짐
				formData.append('fileList' , f);
				// : 만약에 기존의 동일한 키가 있으면 해당 키에 데이터 추가
				// 폼데이터객체.delete('키'); : 폼데이터객체내 데이터 삭제
			});
		}
	// 3. 
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "post" ,
		data : formData ,
		contentType : false ,  // ajax 전송타입 :  multipart/form-data 
		processData : false , 
		success : result => {
		
			if( result == true ){
				alert('제품등록성공');
				location.href="/jspweb/index.jsp";
			}else{
				alert('제품등록실패');
			}
		}
	})
} //f end 

// 2. 드래그 앤 드랍
	// 1. 드래그 앤 드랍할 구역 dom 객체 호출
let fileDropBox = document.querySelector('.fileDropBox');

	// 2. 해당 dom객체에 구역내 드래그가 들어왔을때
fileDropBox.addEventListener("dragenter" , (e)=>{
	console.log('드래그들어옴');
	e.preventDefault();
});
	// 3. 해당 dom객체에 구역내 드래그가 올렸을때
fileDropBox.addEventListener("dragover" , (e)=>{
	console.log('현재구역에 드래그가 위치중임');
	fileDropBox.style.backgroundColor = '#e8e8e8';
	e.preventDefault();
});
	// 4. 해당 dom객체에 구역내 드래그가 나갔을때
fileDropBox.addEventListener("dragleave" , (e)=>{
	console.log('드래그나감');
	fileDropBox.style.backgroundColor = '#ffffff';
	e.preventDefault();
});
	// 5. 해당 dom객체에 구역내 드래그가 드랍(마우스 놓았을때)했을때
fileDropBox.addEventListener("drop" , (e)=>{
	console.log('해당 드래그가 드랍했어');
	console.log(e);
	
	// 브라우저 자체적으로 'drop' 이벤트 우선적으로 실행되므로 해당 이벤트 실행 불가능
	// - 해결방안 : 기존 상위(브라우저) 이벤트 무시
	e.preventDefault(); // 상위 이벤트 무시하고 현 이벤트 우선 적용
	
	// ---------------- 드랍된 정보 ? ------------------- //
		// 1. 드랍된 데이터 정보를 이벤트 결과에서 찾기
		console.log(e.dataTransfer);
		console.log(e.dataTransfer.files);
		console.log(e.dataTransfer.files[0]);
		console.log(e.dataTransfer.files[0].name);
		// 2. 드랍된 파일들을 특정 리스트에 저장
		let files = e.dataTransfer.files;
		for( let i =0; i<files.length; i++){
			if(files[i] != null && files[i] != undefined){
				// 드랍된 파일의 정보가 존재하면 [null 그리고 undefined 아닌 상태]
				fileList.push(files[i]);
			}
		}
		// 3. 배경색 초기화
		fileDropBox.style.backgroundColor = '#ffffff';
		// 4. 현재 드랍된 파일의 정보를 드래그앤드랍 구역에 표시
		fileListPrint();
}); //f end

let fileList = []; // 현재 드래그앤드랍으로 등록된 파일들

// 3. 현재 드랍된 파일들의 정보를 구역에 표시하는 함수
function fileListPrint(){
	// 1. fileDropBox 에 [ fileDropBox dom객체가 함수밖에 존재하므로 재호출X ]
	//2. html 구성
	let html = ``;
		fileList.forEach((f,i)=>{
			console.log("f : "+f);
			let fname = f.name; // 파일의 이름
			let fsize = (f.size/1024).toFixed(1); // 파일의 용량 [ 바이트 단위 ] kb 변환 
					// .toFixed(소수점단위) : 소수점 자르기
			html += `<div>
						<span>${fname}</span>
						<span>${fsize}</span>
						<span><button onclick="fileDelete(${i})" type="button">삭제</button></span>
					</div>`;
			})
		//3. 대입
		fileDropBox.innerHTML = html;
	} //f end
	// 4. 현재 드랍된 파일들 중에 삭제버튼 클릭시 해당 파일 제거
	function fileDelete( i ){
		fileList.splice(i , 1);
		fileListPrint();
}

// 제품등록은 회원제이므로 비로그인시 접근 제한
if (loginState == false){
	alert('로그인후 사용가능한 페이지');
	location.href="/jspweb/member/login.jsp";
}


// 6. ------------------- 카카오 지도 표시 ----------------------- //

	// 1. 현재 접속한 클라이언트[브라우저]의 위치 좌표 구하기
navigator.geolocation.getCurrentPosition( e => {
	console.log(e);
	console.log(e.coords);
	console.log(e.coords.latitude); // 위도
	console.log(e.coords.longitude); // 경도
	let currentlat = e.coords.latitude;
	let currentlng = e.coords.longitude;
	
	


var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(currentlat, currentlng), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 지도를 클릭한 위치에 표출할 마커입니다
	var marker = new kakao.maps.Marker({ 
	    // 지도 중심좌표에 마커를 생성합니다 
	    position: map.getCenter() 
	}); 
	// 지도에 마커를 표시합니다
	marker.setMap(map);
	
	// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
	    
	    // 클릭한 위도, 경도 정보를 가져옵니다 
	    var latlng = mouseEvent.latLng; 
	    
	    // 마커 위치를 클릭한 위치로 옮깁니다
	    marker.setPosition(latlng);
	    
	    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
	    message += '경도는 ' + latlng.getLng() + ' 입니다';
	    
	    var resultDiv = document.getElementById('clickLatlng'); 
	    resultDiv.innerHTML = message;
	    
	    현재위도 = latlng.getLat(); // 위도와 경도를 전역변수로 이동후 제품등록시 사용
	    현재경도 = latlng.getLng();
	    
	});
}); // getCurrentPosition end 

let 현재위도 = 0; 	// 현재 카카오지도에서 선택한 좌표 초기값 0
let 현재경도 = 0;


/*

	dom객체 이벤트 추가하는 방법 2가지
		가정 : 특정 구역에 클릭(onclick) 이벤트 추가
		1. HTML 속성 이벤트 사용하는 방법
		   <button onclick="함수" type="button"></button>
		   
		2. .addEventListener( '이벤트명', 함수 ) 사용하는 방법
		   let button = document.querySelector('.button');
		   button.addEventListener( 'onclick' , 함수 );
		   
	이벤트
	   
		종류 : click , keyup , keydown , drop 등등
	   	- 정의 : 특정 조건(자동)을 충족하면 발생하고 발생한 이벤트의 결과물 반환 해주는 구조
	    
	   	
	   	드래그 앤 드랍 관련 이벤트
	   		1. dragenter	:
	   		2. dragover		:
	   		3. dragleave	:
	   		4. drop			:
*/















