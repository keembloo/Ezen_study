console.log('스크립트실행');

function cwrite() {
	console.log('함수실행');
	let content = document.querySelector('.input_content');
	let price = document.querySelector('.input_price');
	let date = document.querySelector('.input_date');
	
	console.log("content"+content.value);
	console.log("price"+price.value);
	console.log("date"+date.value);
	//객체화
	let info = {
		content : content.value ,
		price : price.value ,
		date : date.value
	}; console.log(info);
	
	$.ajax({
		url : "/jspweb/Accountbook",
		method : "post" ,
		data : info ,
		success : function f(r){console.log('post성공')
			if (r == true ) {
				alert('등록완료'); 
				cread();
				content.value = '';
				price.value = '';
				date.value = '';
			 } else {console.log('등록실패')}
			},
		error : function f(r){console.log('등록실패')}
	})
}

cread();

function cread() {
	$.ajax({
		url : "/jspweb/Accountbook",
		method : "get" ,
		data : "",
		success : function f(r){ console.log(r); console.log('리드됨');
			let output = document.querySelector('.contentbox');
			let html = `<div class="boxinfo">
							<div class="text">내용</div>
							<div class="price">금액</div>
							<div class="date">날짜</div>
						</div>`;
			for (let i=0; i<r.length; i++){ // db기준으로작성해야함... 안그럼안된댜
				html += `<div class="productbox">
							<div class="text">${r[i].acontent}</div>
							<div class="price">${r[i].aprice}원</div>
							<div class="date">${r[i].adate}</div>
							<div class="btn_box">
								<button onclick="cudate(${r[i].ano})" class="btn_edit" type="button">수정</button>
								<button onclick="cdelete(${r[i].ano})" class="btn_delete" type="button">삭제</button>
							</div>
						</div>`;
			}
			output.innerHTML = html;
		} ,
		error : function f(r){console.log('불러올수없음')}
	})
	
}

function cudate(ano) {
	console.log('update함수실행'+ano);
	let acontent = prompt('수정할 내용 : ');
	let aprice = prompt('수정할 가격 : ');
	let adate = prompt('수정할 날짜 : ');
	
	let info = {
		ano : ano ,
		acontent : acontent ,
		aprice : aprice ,
		adate : adate
	}; console.log(info);
	
	$.ajax({
		url : "/jspweb/Accountbook",
		method : "put" ,
		data :  info,
		success : function f(r){ console.log(r); console.log('업데이트실행됨');
			if (r==true){alert('수정성공'); cread();}
			else {alert('수정실패');}
		},
		error : function f(r){console.log(r);}
		})
}

function cdelete(ano) {
	console.log('cdelete함수실행'+ano);
	$.ajax({
	url : "/jspweb/Accountbook",
	method : "delete" ,
	data : {ano : ano },
	success : function f(r){ console.log(r); console.log('들리트실행됨');
		if( r==true){alert('삭제성공'); cread();}
		else {alert('삭제실패')}
	},
	error : function f(r){console.log(r);}
	})
	
}













