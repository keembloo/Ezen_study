console.log('인포js');

// 1.로그인된 회원정보 호출
getInfo();
function getInfo(){
	
	$.ajax({
		url:"/jspweb/Memberinfocontroller" ,
		method : "get" ,
		data: {type : "info"},
		success : r=>{
			if(r==null){ //비로그인 -> 페이지 차단
				alert('회원전용 페이지입니다.[로그인]페이지로 이동');
				location.href="/jspweb/member/login.jsp";
			} else { //로그인상태 -> 마이페이지 구역에 정보 넣어주기
				document.querySelector('.preimg').src=`img/${r.mimg}`;
				document.querySelector('.mid').innerHTML = r.mid;
				document.querySelector('.memail').innerHTML = r.memail;
				
			}
		}
		
	})
}

// 2. 수정
function mupdate(){
	// 첨부파일 전송할때
		// 1. form 객체 가져오기
	let form = document.querySelectorAll('.signupForm')[0];
	console.log(form);
	// 2. form 데이터 객체화 하기
	let formdata = new FormData(form);
	//let mpwd = document.querySelector('.mpwd').value;
	//let newmpwd = document.querySelector('.newmpwd').value;
	console.log(formdata);
	
	// * form 전송 ajax
	$.ajax({
		url : "/jspweb/Memberinfocontroller" ,
		method : "put",
		data : formdata ,
		// 폼 전송타입 : 문자 x ,JSON x , 첨부파일o

		contentType : false ,  // 전송타입 form 
		processData : false ,
		success : r => {
			if (r){ 
				alert('수정성공[다시 로그인해주세요]');
				logout();
			} else {
				alert('수정실패');
			}
		} ,
		error : e => {}
	})
}




// 3. 탈퇴
function mdelete(){
	// 1. 탈퇴여부 확인	confirm() 확인/취소 버튼 알림창
	let dconfirm = confirm('정말 탈퇴하시겠습니까?');
	// 2. 확인버튼을 눌렀을때
	if(dconfirm){
		let mpwd = prompt('비밀번호 확인');
		// 3. ajax 삭제처리 [입력받은 패스워드 전송해서 로그인된 회원번호와 입력받은 패스워드와 일치하면 탈퇴]

		$.ajax({
			url:"/jspweb/Memberinfocontroller" ,
			method : "delete" ,
			data: { mpw : mpwd},
			success : r=>{
				if(r){
					alert('회원탈퇴 성공');
					logout();
				} else {
					alert('비밀번호가 일치하지 않습니다');
				}
			} ,
			error : e => {}
		})
		
		
		
		
	}
}



		/*
			HTTP 전송타입
				1. text/html			: 문자타입 [ 기본값 ]
				2. application/json 	: json타입
				3. multipart/form-data  : 대용량 form 전송 타입
					contentType : false ,
					processData : false ,
		*/






