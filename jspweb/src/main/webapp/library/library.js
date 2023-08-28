	console.log('js작동');
	let info = [ false , false , false , false ,
				false , false , false , false ];
	let click = -1;
	
	read();	
	//출력
	function read() { // 출력 
		$.ajax({
			url : "/jspweb/Library",
			method : "get" ,
			success : function f(r){ 
				console.log(r);
				let seatBox = document.querySelector('.seatBox');
				let html = ``;
	
				for (let i=0; i<r.length; i++){
					if (r[i].state >0 && i==click ) {
					html += `<div onclick = select(${i}) class="unusedselect seat">${i+1}</div>`;
					info[i] = false;
					} 
					else if (r[i].state >0 ) {
					html += `<div onclick = select(${i}) class="usedseat seat">X</div>`;
					info[i] = false;
					} 
					else if(i==click){
					html += `<div onclick = select(${i}) class="selectbutton seat">${i+1}</div>`;
					}
					else {
						html += `<div onclick = select(${i}) class="unusedseat seat">${i+1}</div>`;
						info[i] = {sstate : r[i].state, sno : r[i].sno}
					}
				} // for end
				seatBox.innerHTML = html;
			} ,
			error : function f(r){}
		})
	
	} // 출력 종료
	
	function enterseat(){ // 입실 함수
		let name = document.querySelector('.nameInput');
		let phone = document.querySelector('.phoneInput');
		
		console.log(info)
		console.log(click)
		if(info[click]==false){
			alert('이미 사용중인 좌석입니다.')
			return;
		}
		
		
		if(click==-1){
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
			data : {sno : click+1, name : name.value , phone : phone.value},
			success : function f(r){ 
				if (r){alert('입실완료! 자리에 앉아주세요');read();}
				else {alert('오류 ) 입실실패');}
				click = -1;
			} ,
			error : function f(r){}
		})
		
		name.value =''; phone.value='';
		
	}// 입실 종료
	
	
	
	function select(i){ // 버튼 번호 반환 함수
		read();
		click = i;
	
	} // 번호 반환 종료
	
	
	
	function outseat(){ // 퇴실 함수
		
		if(info[click]!=false){
			alert('사용중인 좌석이 아닙니다.')
			return;
		}
		
	   let phone = prompt('핸드폰번호를 입력하세요( - 포함 )');
	   if (phone=='' || phone==null) {alert('전화번호를 다시 입력해 주세요.'); return;}
	
	   $.ajax({
	      url : "/jspweb/Library",
	      method : "delete" ,
	      data : {sno : click+1 , phone : phone },
	      success : function f(r){ 
	         if (r==true){alert('퇴실성공! 안녕히가세요'); click = -1;  read();}
	         else {alert('전화번호가 일치하지 않습니다.');  click = -1;  read();}
	         
	         
	      } ,
	      error : function f(r){console.log(r);}
	  })
	  click = -1;
	  read();
} // 퇴실 종료 
	
	
