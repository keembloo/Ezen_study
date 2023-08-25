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
      success : function f(r){ 
         console.log(r);
         let seatBox = document.querySelector('.seatBox');
         let html = ``;

         for (let i=0; i<r.length; i++){
            if (r[i].state >0 && i==click ) {
            html += `<div onclick = select(${i}) class="unusedselect seat"></div>`;
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
               info[i] = {sstate : r[i].sstate, sno : r[i].sno}
            }
         } // for end
         seatBox.innerHTML = html;
      } ,
      error : function f(r){}
   })

}


function enterseat(){
   let name = document.querySelector('.nameInput');
   let phone = document.querySelector('.phoneInput');
   
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
         if (r){alert('입실완료! 자리앉아주세요');read();}
         else {alert('오류 ) 입실실패');}
         click = -1;
      } ,
      error : function f(r){}
   })
   
}

function select(i){
   read();
   click = i;
}





function outseat(){
	let phone = prompt('핸드폰번호를 입력하세요 -포함');
	if (phone=='') {alert('전화번호를 다시 입력해 주세요.'); return;}

	$.ajax({
      url : "/jspweb/Library",
      method : "delete" ,
      data : {sno : click+1 , phone : phone },
      success : function f(r){ 
         if (r==true){alert('퇴실성공! 안녕히가세요'); read();}
         else {alert('오류 ) 퇴실실패');}
         click = -1;
         
      } ,
      error : function f(r){console.log(r);}
   })
}

























