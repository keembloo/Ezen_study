
// 0. 카카오맵 옵션
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
    level : 11 // 지도의 확대 레벨
});

// 마커 클러스터러를 생성합니다
// 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
// 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
// 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
// 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
// 1. 카카오맵 클러스터[ 마커 여러개일때 집합모양 ]
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
    minLevel: 10, // 클러스터 할 최소 지도 레벨
    disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
});


// 1. 현재 보고 있는 지도의 동서남북 좌표 얻기
getInfo();

function getInfo() {
    // 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();
    console.log(bounds); // 남 , 서 , 북 , 동 순으로 필드가 저장
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    console.log(swLatLng);
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    console.log(neLatLng);
    
    // 영역정보를 문자열로 얻어옵니다. ((남,서), (북,동)) 형식입니다
    var boundsStr = bounds.toString();
    console.log(boundsStr);
    
    let 동 = neLatLng.getLat(); // 동
    let 서 = swLatLng.getLat(); // 서 
    let 남 = swLatLng.getLng(); // 남 
    let 북 = neLatLng.getLng(); // 북 
    
    console.log("동 : "+동);
    console.log("서 : "+서);
    console.log("남 : "+남);
    console.log("북 : "+북);
    // 
    findByLatLng( 동 , 서 , 남 , 북 ); // 2번 함수 실행 
}

// 2. 해당 동서남북 좌표 범위내 제품만 출력하기
function findByLatLng( east , west , south , north ){
	clusterer.clear(); // 클러스터내 모든 마커를 초기화
	$.ajax({
		url : "/jspweb/ProductInfoController",
		async : false , /* ajax 동기화 설정 [비동기 통신 anync : true ] / [동기통신 anync : false ] */
		method:"get",
		data:{ type: "findByLatLng" ,
				east : east , west : west , 
				south : south , north : north },
		success : jsonArray => {
			//console.log(jsonArray);
			
			// --------------------- 1. 마커를 생성해서 클러스터에 저장 --------------------------//
			 var markers = jsonArray.map( (p) => {
				console.log(p);
		        return new kakao.maps.Marker({
		            position : new kakao.maps.LatLng(p.plat, p.plng)
	        	});
	   		});
		    // 클러스터러에 마커들을 추가합니다
	    clusterer.addMarkers(markers); // 마커들을 클러스터 저장
	    
	    // --------------------2. 사이드바에 제품 출력-------------------------------------------------//
	    let sidebar = document.querySelector('.sidebar');
	    let html = ``;
	    	//
	    	jsonArray.forEach((p)=>{
				html += `<div class="card mb-3" style="max-width: 540px;"> 
						  <div class="row g-0"> 
						  
						    <div class="col-md-5"> 
						    	<a href="/jspweb/product/view.jsp?pno=${p.pno}">
						      	<img src="/jspweb/product/img/${ Object.values(p.imgList)[0]}" class="img-fluid rounded-start" alt="...">
						    	</a>
						    </div>
						    
						    <div class="col-md-7">
						      <div class="card-body">
						        <h5 class="card-title">${p.pname}</h5>
						        <p class="card-text">
						        	<div>${p.pcontent}</div>
						        	<div>${p.pprice.toLocaleString()}원</div>
						        </p>
						      </div>
						    </div>
						    
						  </div>
						</div>`;
			});
	    
	    sidebar.innerHTML = html;
	    
	    
	    
		}
	})
}


// 3. 카카오지도에서 드래그를 하고 끝났을때  1번함수 재실행
kakao.maps.event.addListener(map, 'dragend', function() {
    getInfo()
});




