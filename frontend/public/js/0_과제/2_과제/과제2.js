

let inputId = document.querySelector(".input_id").value // 아이디 값
let inputPw = document.querySelector(".input_pw").value // 비번 값
let arrayId = []; // 빈배열 만들기

/*
function 회원가입() { //회원가입 함수
	
	if ( inputId.value != '') { // 1. 아이디가 공백이아니면
		if (inputPw.value != '') { 	// 1-1. 비번이 공백이 아니면
			console.log(arrayId.push(inputId));
			alert('회원가입이 완료되었습니다');
		} else { 	//1-2. 아이디가 공백이 아니지만 비번이 공백이면
			alert('비밀번호를 입력하지 않았습니다')
		}
	} else	// 2. 아이디가 공백이면
		{alert('아이디를 입력하지 않았습니다')}
		
		
	}//회원가입함수end

*/


function 회원가입() { //회원가입 함수
	console.log(arrayId.push(inputId));
	
	if (inputId == '김') {
		console.log('하이');
	} else { console.log('다름'); }
}//회원가입함수end

