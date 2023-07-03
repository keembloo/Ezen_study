
// 누구를~
// 1.조작 /제어할 html 태그 호출
	// 1.입력 2.출력 3.이동
let userbox = document.querySelector('.userbox');


//어떻게~ : 페이지전체(body)에서 키보드를 누를때
	//dom 객체명.addEventListener( '이벤트명' , ()=>{ })
document.body.addEventListener('keydown' , (e)=>{
	console.log('ㅁㅁㅁㅁ');
	// 1. 눌린 키 상태 확인 .keyCode
	console.log(e); // keydown 이벤트 상태 객체
	// 2. 만야겡 왼쪽/오른쪽 키를 눌렀을때 css left 변경
	if(e.keyCode == 37) {
		console.log("left");	// css left 차감
		userbox.style.left--;
		
	} else if(e.keyCode == 39) {
		console.log('right');	// css left 증가
		userbox.style.left++;
	}
	// 확인출력
	console.log(userbox.style.left);
});