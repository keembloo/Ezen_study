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
					if (r) {idcheckbox.innerHTML = '사용중인 아이디입니다'; checkList[0]=false;}
					else {idcheckbox.innerHTML = '사용 가능한 아이디입니다'; checkList[0]=true;}
				} ,
				error : e => {}
			})
			
		} else { // 입력한 값이 패턴과 일치하지 않으면
			document.querySelector('.idcheckbox').innerHTML = '아이디는 5 ~ 30글자 사이이면서 영문 +숫자 조합만 가능합니다';
			checkList[0]=false;
		}
	// 3. 결과 출력
}

// 2. 비밀번호 유효성검사 [ 1. 정규표현식 검사 2. 비밀번호와 비밀번호확인 일치여부 ]
function pwcheck(){
	//console.log('패드워드입력중');
	
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
					pwcheckbox.innerHTML=`사용가능한 비밀번호`;checkList[1]=true;
				} else {
						pwcheckbox.innerHTML=`비밀번호가 일치하지 않습니다`; checkList[1]=false;
				}
			} else {
				pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 조합 5~20글자 사이로 입력해주세요.`; checkList[1]=false;
			}
		} else {
			pwcheckbox.innerHTML = `영대소문자1개이상+숫자1개이상 조합 5~20글자 사이로 입력해주세요.`; checkList[1]=false;
		}
}


// 3. 이메일 유효성검사 [ 1. 정규표현식 2. 중복검사 ]
function emailcheck(){
	let emailcheckbox = document.querySelector('.emailcheckbox');
	let authReqBtn = document.querySelector('.authReqBtn');
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
					authReqBtn.disabled = true; //disabled 해당버튼의 disabled 속성 해제 
					checkList[2]=false;
				} else {
					emailcheckbox.innerHTML= `사용가능한 이메일입니다.`;
					authReqBtn.disabled = false; //disabled 해당버튼의 disabled 속성 해제 
				}
			} ,
			error : r=> {console.log(r);}
		})
	} else{
		emailcheckbox.innerHTML = `이메일 형식에 맞게 입력해주세요.`;
		authReqBtn.disabled = true; //disabled 해당버튼의 disabled 속성 해제 	
		checkList[2]=false;
	}
} // f end

// 4. 인증요청 버튼을 눌렀을때
function authReq(){
	// -------------------테스트용 -------------------//
	// 1. authbox div 호출
			let authbox = document.querySelector('.authbox');
	
			// 2. auth html 구성
			let html = `<span class="timebox">02:00</span>
						<input class="ecode" type="text">
						<button onclick="auth()" type ="button">인증</button>`;
			// 3. auth html 대입
			authbox.innerHTML = html;
			
			// 4. 타이머 실행
			authcode = '1234'; 	// 인증 코드 '1234' 테스트용 
			//authcode = r;  //[ Controller(서블릿)에게 전달받은 값이 인증코드]
			timer = 120; 	 // 인증 제한시간 10초 테스트용
			settimer();		 // 타이머실행 
	/*		
	// -------------------------이메일 인증 보냇을때 -----------------------//
	// -- 인증요청시 서블릿통신 [ 인증코드 생성 , 이메일전송 ]
	$.ajax({
		url : "/jspweb/AuthSendEmailController",
		method : "get" ,
		data : { memail : document.querySelector('.memail').value } ,
		success : r => { console.log(r);
			// 1. authbox div 호출
			let authbox = document.querySelector('.authbox');
	
			// 2. auth html 구성
			let html = `<span class="timebox">02:00</span>
						<input class="ecode" type="text">
						<button onclick="auth()" type ="button">인증</button>`;
			// 3. auth html 대입
			authbox.innerHTML = html;
			
			// 4. 타이머 실행
			// authcode = '1234'; 	// 인증 코드 '1234' 테스트용 
			authcode = r;  //[ Controller(서블릿)에게 전달받은 값이 인증코드]
			timer = 120; 	 // 인증 제한시간 10초 테스트용
			settimer();		 // 타이머실행
		} ,
		error : e => {console.log(e);}
	})
	*/
} // f end

// 4,5,6번 함수에서 공통적으로 사용할 변수 [전역변수]
let authcode= ''; // 인증코드
let timer = 0; // 인증시간 (초) 변수
let timerInter; // setInterval() 함수를 가지고있는 변수 [ setInterval 종료시 필요 ]

// 5. 타이머 함수 만들기
function settimer(){
	// setInterval( 함수명 , 실행간격[밀리초]) : 특정시간마다 함수를 실행 함수
	 timerInter = setInterval( ()=>{ 
		// 시간 형식 만들기
			// 1. 분 만들기 [ 초/60] =>분 / [초%60] => 나머지 초
		let m = parseInt(timer / 60); // 1분 계산
		let s = parseInt(timer % 60); // 초 계산 [나머지]
			// 2. 두자리수 맞춤 3 -> 03
		m = m < 10 ? "0" + m : m; // 만약에 분이 한자리수이면 0을 붙이고 아니면 안붙임
		s = s < 10 ? "0" + s : s;
		 
		document.querySelector('.timebox').innerHTML =`${m}:${s}`; // 현재 인증시간 (초) html 대입
		timer--; // 1씩 차감 
		
		// 만약에 타이머가 0보다 작으면 [ 시간 끝 ]
		if(timer<0){
			// 1. setInterval 종료 [ 누구를 종료할건지 식별자 필요 / 변수선언 = timerInter]
			clearInterval(timerInter);
			// 2. 인증실패 알림
			document.querySelector('.emailcheckbox').innerHTML = `인증실패`;
			checkList[2]=false;
			// 3. authbox 구역 html 초기화
			document.querySelector('.authbox').innerHTML = ``;
		 }
	}, 1000);
} // f end

// 6. 인증요청후 인증코드를 입력하고 인증하는 함수
function auth(){
	//console.log('auth 오픈');
	// 1. 입력받은 인증코드
	let ecode = document.querySelector('.ecode').value;
	
	// 2. 비교 [ 인증코드와 입력받은 인증코드 ]
	if(authcode==ecode){
		// 1. setInterval 종료 
		clearInterval(timerInter);
		// 2. 인증성공 알림
		document.querySelector('.emailcheckbox').innerHTML = `인증성공`;
		// 3. authbox 구역 html 초기화
		document.querySelector('.authbox').innerHTML = ``;
		checkList[2]=true;

	} else {
		// 1. 인증코드 불일치 알림
		document.querySelector('.emailcheckbox').innerHTML = `인증코드 불일치`; checkList[2]=false;
	}
} // f end

// 7. 첨부파일에 등록된 사진을 html 표시하기 <등록된 사진을 미리보기 기능>
function preimg(object){
	console.log('사진 선택 변경');
	console.log(object); // 이벤트 발생시킨 태그의 dom객체를 인수로 받음
	console.log(document.querySelector('.mimg'));
	// 1. input태그의 속성 [ type , class , onchange , name 등등 ]
	// 1. input태그이면서 type="file"이면 추가적인 속성 .files
		// .files : input type = "file"에 선택한 파일 정보를 리스트로 받음
	console.log(object.files);
	console.log(object.files[0]); // 리스트중에서 하나의 파일만 가져오기
	
	// --- 해당 파일을 바이트코드 변환
	// 2. js파일클래스 선언
	let file = new FileReader(); // 파일 읽기 클래스 이용한 파일읽기객체 선언
	// 3. 파일 읽어오기 함수 제공 
	file.readAsDataURL(object.files[0]); // input에 등록된 파일리스트중 1개를 파일객체로 읽어오기
	console.log(file);
	// 4. 읽어온 파일을 해당 html img태그에 load
	file.onload = e => { // onload() : 일겅온 파일의 바이트코드를 불러오기
		console.log(e);  // e : 이벤트 정보 
		console.log(e.target);  // e.target : onload() 실행한 fileReader 객체
		console.log(e.target.result); // 읽어온 파일의 바이트코드
		document.querySelector('.preimg').src = e.target.result; // img src 속성에 대입
		
	}
} // f end

let checkList = [false , false , false ] // [0] : 아이디통과여부 , [1] : 패스워드통과여부 , [2] : 이메일통과여부
	// true 통과 , false 비통과
	
// 8 . 회원가입 메소드
function signup(){
	
	// 1. 아이디/비밀번호/이메일 유효성검사 통과 여부 체크
	console.log(checkList);
	if(checkList[0] && checkList[1] && checkList[2] ){ // checkList에 저장된 논리가 모두 true이면
		console.log('회원가입 진행가능');
		
		// 2. 입력받은 데이터를 한번에 가져오기 form 태그 이용
			// <form> 각종 input/button </form>
		 	// 1. form 객체 호출 document.querySelectorAll(폼태그식별자)
		 	let signupForm = document.querySelectorAll('.signupForm')[0];
		 	console.log(signupForm);
		 	// 2. form 데이터 객체화
		 		// 일반객체로 첨부파일 전송 불가능 -> FormData 객체 이용시 첨부파일 전송가능
		 	let signupData = new FormData(signupForm); // 첨부파일시 필수		 	
		 	console.log(signupData);
		 	
		 	// 3. AJAX에게 첨부파일[대용량] 전송하기
		 		// 1. 첨부파일 없을때
		 		/*
		 	$.ajax({
				 url: "" ,
				 method : "" ,
				 data : "" ,
				 success : r => {console.log(r)} , 
				 error : e => {console.log(e)}
			 })
			 */
			// 2. 첨부파일 있을때 [ 기존 json형식의 전송x form객체 전송 타입으로 변환 ]
			$.ajax({
				 url: "/jspweb/Memberinfocontroller" ,
				 method: "post" ,			// 첨부파일 form 전송은 무조건 post 방식 
				 data : signupData ,			// FormData 객체를 전송 
				 contentType : false ,		// form 객체 전송타입 		
				 processData : false ,
				 success : r => {				 
				 
					 if (r){ // 회원가입 성공 [ 1. 알린다 2.페이지 전환]
						 alert('회원가입 성공');
						 location.href ='/jspweb/member/login.jsp';
					 } else { // 회원가입 실패
						  alert('회원가입 실패[관리자문의]');
					 }
				 
				 } ,
				 error : e => { console.log(e) } ,
			 })
		
	} else {
		alert('정상적으로 입력 안된 내용이 있습니다.');
	}
}

// --. 유효성검사가 없는 회원가입 메소드
/*
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
}// f end
*/


/*

	setInterval() : 특정시간마다 함수를 실행하는 함수
		1. 정의
			let 변수명 = setInterval( function 함수명(){} , 밀리초 )
			let 변수명 = setInterval( function (){} , 밀리초 )
			let 변수명 = setInterval( () => {} , 밀리초 )
			let 변수명 = setInterval( 함수명() , 밀리초 )
		2. 종료
			clearInterval( setInterval변수명 )	

 */