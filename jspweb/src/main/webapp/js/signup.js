console.log('된다');

// onchange : 포커스(커서) 변경될때 값이 다르면 실행
// onkeyup : 키보드에서 키를 누르고 떼었을때 실행
// onkeydown : 키보드에서 키를 눌렀을때 실행

/*
	정규표현식 : 문자열에 특정 규칙/패턴의 집합 표현할 때 사용되는 언어
		문법
			/^		: 정규표현식 시작 알림.
			$/		: 정규표현식 끝 알림
			[a-z]	: 소문자 a-z 패턴 
			[A-Z]	: 대문자 A-Z 패턴 
			[0-9]	: 숫자 0~9 패턴 
			[가-힣]	: 한글 패턴
			{ 최소길이 , 최대길이 } : 문자열 길이 패턴
			+ : 앞에있는 패턴 1개 이상 반복
			? : 앞에잇는 패턴 0개 혹은 1개 이상 반복
			* : 앞에있는 패턴 0개 반복
			
			예시 ]
				1. [a-z]			: 소문자A-Z 패턴
				2. [a-zA-Z] 		: 영문(대,소) 패턴
				3. [a-zA-Z0-9] 		: 영문 + 숫자 조합 패턴
				4. [a-zA-z0-9가-힣]	: 영문 + 숫자 + 한글 조합 패턴
				5. [ac]				: a와c 패턴
				6. (?=.*[패턴문자]) 	: 해당 패턴문자가 한개 이상 포함 패턴
					(?=.*[a-z])		: 소문자 한개이상 필수 
					(?=.*[A-Z])		: 대문자 한개이상 필수 
					(?=.*[0-9])		: 숫자 한개이상 필수 
					(?=.*\d)		: 숫자 한개이상 필수 (정수)
					(?=.*[!@#$%^&*]): 패턴문자내 특수문자 한개 이상 필수
					
				/^[A-Za-z0-9]{5,20}$/
				영대소문자 + 숫자 조합의 5~20글자 사이
				
				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{5,20}$/
				영대문자1개 + 영소문자1개 + 숫자 1개 + 특수문자 1개 이상 필수로 갖는 5~20글자 사이
				
			1. /^[a-z0-9]{5,30}$/	: 영문(소) + 숫자 조합 5~30글자 패턴
		
		패턴 검사
			"패턴".test(검사할데이터) : 해당 데이터가 패턴에 일치하면 true / 아니면 false
*/

// 1. 아이디 유효성 검사
function idcheck(){ /* 실행조건 : 아이디 입력창에 입력할때마다 */
	console.log('아이디체크함수실행');
	// 1. 값 호출
	let mid = document.querySelector('.mid').value;
	
	let idcheckbox = document.querySelector('.idcheckbox');
	// 2. 유효성검사
		// 제어문을 이용한 검사 : if(mid.length < 5 && mid.length >= 20){}
		// 1. 아이디는 5 ~ 30글자 사이이면서 영문 +숫자 조합
			// 1. 정규표현식 작성
		let midj = /^[a-z0-9]{5,30}$/
			// 2. 정규표현식 검사
		console.log(midj.test(mid))
		if( midj.test(mid)){ // 입력한 값이 패턴과 일치하면
			// -- 입력한 아이디가 패턴과 일치하면 아이디 중복 검사실행
			$.ajax({
				url : "/jspweb/MemberFindController",
				method : "get",
				data : { type: "mid" , data : mid},
				success : r => {
					if (r) {idcheckbox.innerHTML = '사용중인 아이디입니다';}
					else {idcheckbox.innerHTML = '사용 가능한 아이디입니다';}
				} ,
				error : r => {}
			})
			
		} else { // 입력한 값이 패턴과 일치하지 않으면
			document.querySelector('.idcheckbox').innerHTML = '아이디는 5 ~ 30글자 사이이면서 영문 +숫자 조합만 가능합니다';
		}
	// 3. 결과 출력
}

// 2. 비밀번호 유효성검사 [ 1. 정규표현식 검사 2. 비밀번호와 비밀번호확인 일치여부 ]
function pwcheck(){
	console.log('패드워드입력중');
	
	let pwcheckbox = document.querySelector('.pwcheckbox');
	
	// 1. 입력 값 호출
	let mpwd = document.querySelector('.mpwd').value; console.log('mpwd: '+mpwd);
	
	// 2. 유효성검사
		// 1. 정규표현식 만들기 [ 영대소문자 + 숫자 조합 5~10글자 사이 ]
		let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
		let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
		
		if (mpwdj.test(mpwd)){ // 1.비밀번호 정규표현식 검사
			// 2.비밀번호 확인 정규표현식 검사
			if(mpwdj.test(mpwdconfirm)){
				// 3.비밀번호와 비밀번호 확인 일치여부
				if(mpwd== mpwdconfirm){
					pwcheckbox.innerHTML=`사용가능한 비밀번호`;
				} else {
						pwcheckbox.innerHTML=`비밀번호가 일치하지 않습니다`;
				}
			} else {
				pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 조합 5~20글자 사이로 입력해주세요.`;
			}
		} else {
			pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 조합 5~20글자 사이로 입력해주세요.`;
		}
}


// 3. 이메일 유효성검사 [ 1. 정규표현식 2. 중복검사 ]
function emailcheck(){
	let emailcheckbox = document.querySelector('.emailcheckbox');
	// 1. 입력된 값 호출
	let memail = document.querySelector('.memail').value;
	
	// 2. 이메일 정규 표현식 [ @기준으로 이메일 앞부분(영대소문자,숫자,_- @  ) ]
		// asdf@kakao.com
		// 1. asdf		: 이메일 아이디부분은 영대소문자 , 숫자 , _-
		// 2. @			: +@ 	@앞에 패턴이 1개이상 필수
		// 3. 도메인
			// 회사명		: @ 뒤에 그리고 . 앞에 패턴은 a-zA-Z0-9_-
			// .		: +\. : . 앞에 패턴이 1개이상 필수
			// 도메인		: . 뒤에 패턴은 a-zA-Z
			
	//let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+{5,30}$/
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/
	
	// 3. 유효성검사
	if(memailj.test(memail)){
		$.ajax({
			url : "/jspweb/MemberFindController" ,
			method : "get" ,
			// type을 사용하는 이유 : 서로 다른 ajax가 동일한 서블릿과 동일한 get메소드를 사용할때 제어하려고
			data : {type: "memail" , data : memail } ,
			success : r => {
				if(r){
					emailcheckbox.innerHTML = `사용중인 이메일입니다.`;
				} else {
					emailcheckbox.innerHTML= `사용가능한 이메일입니다.`;
				}
			} ,
			error : r=> {console.log(r);}
		})
		
		console.log('이메일통과');
	} else{
		console.log('이메일 실패');
	}
} // f end


// --. 회원가입 메소드
function signup(){
	
	// 1. html에 가져올 데이터의 tog객체 호출 [ dom객체 : html 태그를 객체화 ]
	let midInput = document.querySelector('.mid');
	let mpwdInput = document.querySelector('.mpwd');
	let mpwdconfirmInput = document.querySelector('.mpwdconfirm');
	let memailInput = document.querySelector('.memail');
	let ecodeInput = document.querySelector('.ecode');
	let mimgInput = document.querySelector('.mimg');
	
	
	// 2. (객체화)
	let info ={
		mid : midInput.value ,
		mpwd : mpwdInput.value ,
		memail : memailInput.value ,
		mimg : mimgInput.value	
	}
	console.log(info);
	// 3. 유효성검사
	
	
	
	// 4. AJAX메소드를 이용한 Servlet와 통신
	$.ajax ({
		url : "/jspweb/Memberinfocontroller",
		method : "post" ,
		data : info,
		success : r => {
			if( r== true){
				alert('회원가입성공');
			} else {
				alert('회원가입실패');
			}
		} ,
		error : e => {alert('통신실패');}
	})
	// 5. Servlet 의 응답에 따른 제어 
}