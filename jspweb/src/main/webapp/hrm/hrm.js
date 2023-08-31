//console.log('hrm js실행');

// 첨부파일 이미지 미리보기 
function preimg(object){
	
	// --- 해당 파일을 바이트코드 변환
	// 2. js파일클래스 선언
	let file = new FileReader(); // 파일 읽기 클래스 이용한 파일읽기객체 선언
	// 3. 파일 읽어오기 함수 제공 
	file.readAsDataURL(object.files[0]); // input에 등록된 파일리스트중 1개를 파일객체로 읽어오기
	//console.log(file);
	// 4. 읽어온 파일을 해당 html img태그에 load
	file.onload = e => { // onload() : 일겅온 파일의 바이트코드를 불러오기
		console.log(e);  // e : 이벤트 정보 
		console.log(e.target);  // e.target : onload() 실행한 fileReader 객체
		console.log(e.target.result); // 읽어온 파일의 바이트코드
		document.querySelector('.preimg').src = e.target.result; // img src 속성에 대입
	}
} // f end




// 직원 등록하기 함수
function signup(){
	//console.log('직원등록');
	
	let signupForm = document.querySelectorAll('.signupForm')[0];
	console.log(signupForm);
	let hlevel = document.querySelector('.levelselect').value;
	
	let signupData = new FormData(signupForm);
	signupData.append("hlevel", hlevel); // select value 객체에 추가 
	console.log("signupData"+signupData);
	
	$.ajax({
		 url: "/jspweb/HrmController" ,
		 method: "post" ,			// 첨부파일 form 전송은 무조건 post 방식 
		 data : signupData ,		// FormData 객체를 전송 
		 contentType : false ,		// form 객체 전송타입 		
		 processData : false ,
		 success : r => {				 
			 if (r){ // 회원가입 성공 [ 1. 알린다 2.페이지 전환]
				 alert('회원가입 성공');
				 view(); 
			 } else { // 회원가입 실패
				  alert('회원가입 실패[관리자문의]');
			 }
		 } ,
		 error : e => { console.log(e) } ,
	 })
}

view(); // 최초한번실행

// 출력하기 함수
function view(){
	$.ajax({
		url : "/jspweb/HrmController",
		method : "get" ,
		data : "",
		success : function f(r){ 
			
			let viewbox = document.querySelector('.viewbox');
			let html = ``;
			let setting = `<tr>
							<th>직원번호</th>
							<th>사진</th>
							<th>직원명</th>
							<th>직원전화번호</th>
							<th>직급</th>
							<th> 입사등록일</th>
						</tr>`;
						
			for(let i =0; i <r.length; i++){
				html += `<tr class="content">
					    <td>${r[i].hno}</td>
					    <td><img alt="등록사진" src="img//${r[i].himg}"></td>
					    <td>${r[i].hname}</td>
					    <td>${r[i].hphone}</td>
					    <td>${r[i].hlevel}</td>
					    <td>${r[i].hdate}</td>
					</tr>`;
			}
		
			viewbox.innerHTML= setting+html;
		 } ,
		error : e => { console.log(e) } ,
	})	
}
