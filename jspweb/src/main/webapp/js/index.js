

// 1. n개 제품들을 최신순으로 출력
function findByTop( count ){
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method:"get",
		data:{ type: "findByTop" , count : count },
		success : jsonArray => {
			console.log(jsonArray);
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