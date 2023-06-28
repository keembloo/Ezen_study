console.log('JS실행');


// 모든 함수에 접근할수 있는 배열 (member 객체 여러개를 저장하는) 선언
let 회원리스트 = [];
// 이 배열을 쓰지 않으면, 회원가입시 입력한 값이 저장이되지않음. 
// 이 배열을 함수내에 쓸경우도 함수실행 뒤 데이터가 사라짐
// 함수 밖에 저장시켜서 로그인할때 입력한 값이랑 같은지 비교해야함.

// 1. 등록함수 [실행조건 : 회원가입 버튼을 클릭했을때]
function 등록(){
	console.log('등록실행')
	// 1. 입력값 가져오기
    	// 1. document.querySelector('.class').value
    	// 2. document.querySelector('#id').value
	let mid = document.querySelector('#mid').value;
	let mpwd = document.querySelector('#mpwd').value;
	
	// 유효성검사하기1
	if (mid=='' || mpwd =='') { alert('회원가입실패 : 회원정보 모두 입력해주세요'); return;} // 입력값이 하나라도 공백이면 함수강제종료 ~! 
	
	//유효성검사하기2
	if(mid.length <8 || mpwd.length <8) {// 입력값이 하나라도 길이가 8미만이면
		alert('회원가입실패 : 아이디나 비밀번호는 8자이상이어야합니다'); return;}
	
	
	// ----------------------------- 등록 -----------------------------
	//2. 객체담기 // 입력된 데이터(mid,mpwd)를 {} 안에서 속성명(아이디,비밀번호)붙여서 저장
	let member = { 아이디 : mid , 비밀번호 : mpwd };
		// 필드 = 상태
		// 속도(속성명) = 현재속도수치
	console.log(member);
	
	//3. 등록할때(함수 실행될) 마다 객체 생성되고 '}' 끝나면 다 사라짐 = 지역변수!!!
	// 밖에 전역변수 만들어서 거기에 저장하자!! 객체 여러개(배열)
	// {} 안에서 선언된 객체를 전역 배열에 저장하자
	회원리스트.push(member);
	console.log(회원리스트);
	
	/* 아래코드로 줄일 수 있음
		회원리스트.push(
			{ 아이디 : document.querySelector('#mid').value , 
			비밀번호 : document.querySelector('#mpwd').value }
			);
	*/ 
	
	// ----------------------------- input 입력상자 초기화 -----------------------------
	document.querySelector('#mid').value = ``;
	document.querySelector('#mpwd').value = ``;
} // 등록함수 e  // mid,mpwd,member 초기화/사라짐



// 2. 로그인 [실행조건: 로그인 버튼을 클릭했을때]
function 로그인(){
	let mid2 = document.querySelector('#mid2').value; console.log(mid2);
	let mpwd2 = document.querySelector('#mpwd2').value; console.log(mpwd2);
	// 2. 입력된 값이 존재하는지 검사
		// - 회원리스트(전체) 중에서 회원1명(1개씩) 꺼내서 검사하는데 아이디와 비밀번호 일치 찾기
	
		
	let login = false; // 로그인 상태 저장 변수
		
	for(let i = 0; i<회원리스트.length ; i++){
		// i는 0부터 마지막인덱스까지 1씩 증가 반복 -> 회원리스트(전체) 중에서 회원1명(1개씩) 꺼내서
		let member = 회원리스트[i]; //i번째 인덱스의 객체1개 꺼내기
		if (member.아이디 == mid2) { // i번째 객체의 아이디가 입력한 아이디와 같으면
			if(member.비밀번호 == mpwd2 ) { // i번째 객체의 비밀번호가 입력한 비밀번호와 같으면
				login = true; // i번째 객체는 로그인 성공했다는 '증거'를 변수에 저장 
				// 로그인 성공 1회성이기 때문에 로그인 성공시 다음 객체는 볼 필요 없음 // 반복문종료
				i=회원리스트.length; // 방법1. 조건을 false 만들자
				break;				// 방법2. break;(가장 가까운)반복문 강제종료
			}
		}
	} // if 2 조건 모두 충족했을때 login 변수는 true값으로 변경

	
	// 판단 : 로그인 상태 저장 변수
	if (login == true ){alert('로그인성공');}
	else {alert('로그인실패')};

	// ----------------------------- input 입력상자 초기화 -----------------------------
	document.querySelector('#mid').value = ``;
	document.querySelector('#mpwd').value = ``;
	
} // 로그인함수 e




























