
// 누구를~
// 1.조작 /제어할 html 태그 호출
// 1.입력 2.출력 3.이동
let userbox = document.querySelector('.userbox');

// 현재 유저의 위치 = x좌표  // 기본값 50
let u_left = 50;

//어떻게~ : 페이지전체(body)에서 키보드를 누를때 = keydown
//dom 객체명.addEventListener( '이벤트명' , ()=>{ })
document.body.addEventListener('keydown', (e) => {
	console.log('ㅁㅁㅁㅁ');
	// 1. 눌린 키 상태 확인 .keyCode
	console.log(e); // keydown 이벤트 상태 객체
	// 2. 만야겡 왼쪽/오른쪽 키를 눌렀을때 css left 변경
	if (e.keyCode == 37) {
		console.log("left");	// css left 차감
		userbox.style.left--;
		u_left -= 10;	// 10차감
		// * 유효성검사 [ 배경 밖 못나가게]
		if (u_left < 0) {
			u_left = 0; // 만약에 위치가 0보다 작으면 0으로 고정 그럼 안나가짐
		}
	} else if (e.keyCode == 39) {
		console.log('right');	// css left 증가
		userbox.style.left++;
		u_left += 10; // 10증가
		if (u_left > 900) {
			u_left = 900; // 만약에 위치가 900보다 크면 0으로 고정 
		}
		userbox.style.backgroundImage = `url(img/메타몽.png`
	} else if (e.keyCode == 65) {// 만약에 a키를 눌렀을때
		console.log('공격');
		userbox.style.backgroundImage = `url(img/캐릭터_머임.png` // 이미지 파일명 반대로됨 ㅎ...
	}
	// 3.현재 위치값을 대입
	userbox.style.left = `${u_left}px`
	// 확인출력
	console.log(userbox.style.left);
}); // f end


// 키 누르고 떼었을때 = keyup
document.body.addEventListener('keyup', (e)=>{
	// 원래 기본 이미지 변경
	userbox.style.backgroundImage = `url(img/캐릭터1.png`
});
























