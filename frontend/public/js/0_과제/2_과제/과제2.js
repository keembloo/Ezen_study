


let arrayId = []; // 빈배열 만들기
let arrayPw = [];

function 회원가입() { //회원가입 함수
	let inputId = document.querySelector('.input_id').value // 아이디 값
	let inputPw = document.querySelector('.input_pw').value // 비번 값

	console.log(inputId);

	if (inputId == '') {
		alert('아이디를 다시 입력하세요');
	} else if (inputPw == '') {
		alert('비밀번호를 다시 입력하세요');
	} else if (inputId.length < 8 || inputPw.length < 8) {
		alert('아이디와 비밀번호는 8글자 이상이어야합니다');
	} else if (inputId != '' && inputPw != '') {
		arrayId.push(inputId);
		arrayPw.push(inputPw);
		alert('회원가입이 완료되었습니다');

		document.querySelector('.input_id').value = '';
		document.querySelector('.input_pw').value = '';}
	}//회원가입함수end

	function 로그인() { //로그인 함수
		let loginId = document.querySelector('.login_id').value // 아이디 값
		let loginPw = document.querySelector('.login_pw').value // 비번 값

		if (arrayId.indexOf(loginId) == -1) {
			alert('없는 아이디입니다');
		} else if (arrayPw.indexOf(loginPw) == -1) {
			alert('비밀번호가 틀렸습니다');
		} else {
			alert('로그인 성공');
			// location.href="../4_과제/4_과제.html";
			document.querySelector('.login_id').value = '';
			document.querySelector('.login_pw').value = '';

		}
	} //로그인 함수 end


