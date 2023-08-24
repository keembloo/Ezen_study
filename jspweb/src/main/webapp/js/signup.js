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
			
			예시 ]
				1. [a-z]	: 소문자A-Z 패턴
				2. [a-zA-Z] : 영문(대,소) 패턴
				3. [a-zA-Z0-9] : 영문 + 숫자 조합 패턴
				4. [a-zA-z0-9가-힣] : 영문 + 숫자 + 한글 조합 패턴
				5. [ac]			: a와c 패턴
				
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
				data : {mid : mid},
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