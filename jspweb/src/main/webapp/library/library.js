console.log('js작동');
let info = [ false , false , false , false ,
			false , false , false , false ];
let click = -1;

read();	
//출력
function read() {
	$.ajax({
		url : "/jspweb/Library",
		method : "get" ,
		data : "",
		success : function f(r){ 
			console.log(r);
			let seatBox = document.querySelector('.seatBox');
			let html = ``;

			for (let i =0; i<r.length; i++){
				if (r[i].state >0 ) {
				html += `<div class="usedseat seat">${i+1}</div>`;
				info[i] = false;
				} else {
					html += `<div onclick=select(${i})class="unusedseat seat">${i+1}</div>`;
					info[i] = {sstate : r[i].sstate, sno : r[i].sno}
				}
			} // for end
			seatBox.innerHTML = html;
		} ,
		error : function f(r){}
	})

}


function enterseat(sno, sstate){
	let name = document.querySelector('.nameInput');
	let phone = document.querySelector('.phoneInput');
	
	if(click==0){
		alert('좌석을 선택해 주세요.')
		return;
	}
	
	if(name.value=='' || phone.value=='' ){
		alert('항목을 모두 입력해 주세요.');
		return;
	}
	
	$.ajax({
		url : "/jspweb/Library",
		method : "post" ,
		data : {sno : click, name : name.value , phone : phone.value},
		success : function f(r){ 
			if (r){alert('입실완료! 자리앉아주세요');}
			else {alert('오류 ) 입실실패');}
			click = -1;
		} ,
		error : function f(r){}
	})
}

function select(i){
	click = i+1;
	if(click!=-1){
	document.querySelectorAll('.unusedseat')[click-1].className = 'usedseat seat';}
}


