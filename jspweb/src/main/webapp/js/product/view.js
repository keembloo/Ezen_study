// 게시판 상세 페이지 , 제품 상세페이지 등등에서는 클릭된 [식별자]
// url(인터넷주소)에서 매개변수 가져오기 
let pno = new URL(location.href).searchParams.get("pno");
// new URL(location.href).searchParams.get("키");
// <a href="/jspweb/product/view.jsp?키=값&키=값&키=값">

// 1. pno에 해당하는 제품1개 호출
findByPno(pno);
function findByPno(pno){
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method:"get",
		data:{ type: "findByPno" , pno : pno },
		success : jsonObject => { console.log(jsonObject);
		
			// ------ 캐러셀에 이미지 여러개 대입
			let imgbox = document.querySelector('.imgbox');
			let html =``;
			Object.values(jsonObject.imgList).forEach( (img,i)=>{
				// 첫번째 이미지에만 active 클래스 삽입
				html += `<div class="carousel-item ${i==0 ? 'active' : '' }">
					      <img src="/jspweb/product/img/${img}" class="d-block w-100" alt="...">
					    </div>`;
			})
			
			imgbox.innerHTML = html;
		}
	})	
}

