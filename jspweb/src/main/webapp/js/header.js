//console.log('헤더js');


// 1. 현재 로그인된 회원정보 요청
let loginState = false; // 로그인 상태 확인하는 변수 true:로그인중 false:비로그인
let loginMid = ''; // 로그인 성공된 아이디를 가지고 있는 변수
getMemberInfo();

function getMemberInfo() {
	
	// 1. ajax 이용한 서블릿세션 정보 가져오기
	$.ajax({
		url : "/jspweb/Memberinfocontroller" , 
		method : "get" ,
		async : false, /* 동기화(기본값=false), 비동기화(기본값=true) 설정하는 속성 (우선적인 ajax실행 응답이 필요할때) */
		data : {type : "info"} ,
		success : r => {
			console.log("r : "+r);
			
			let submenu = document.querySelector('.submenu');
			let html = ``;
			if (r == null){ //비로그인
				loginState = false; loginMid = '';
				html += `<li> <a href="/jspweb/member/signup.jsp">회원가입</a></li>
						 <li> <a href="/jspweb/member/login.jsp">로그인</a></li>`;
			}else { //로그인
				loginState = true; loginMid = r.mid;
					html += `<li>${r.mid}님</li>
							<li> <img class="hmimg" src="/jspweb/member/img/${r.mimg}"></li>
							<li> <a href="/jspweb/member/payment.jsp">포인트</a></li>
							<li> <a href="/jspweb/product/wishlist.jsp">찜목록</a></li>
							<li> <a href="/jspweb/member/info.jsp">마이페이지</a></li>
							<li> <a onclick="logout()" href="#">로그아웃</a></li>`;
							
				if(r.mid == "admin"){ // 관리자 로그인
				}
			}
			// 구성된 html 대입
			submenu.innerHTML = html;
		} ,
		error : e=> {}
	})
} // f end

// 2. 로그아웃 함수 [ 서블릿에 세션을 삭제 그리고 로그아웃 성공시 메인페이지로 이동 ]
function logout() {
	$.ajax({
		url : "/jspweb/Memberinfocontroller" , 
		method : "get" ,
		data : {type : "logout"} ,
		success : r => {
				alert('로그아웃되었습니다');
				loginState = false;
				location.href="/jspweb/index.jsp";
			},
		error : e => {}
	})
} // f end




