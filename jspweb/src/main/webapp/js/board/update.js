console.log('업데이트실행');

	// 2. 쿼리스트링(url주소상의변수)의 변수 가져오기
		// 쿼리스트링 : URL?변수명=값&변수명=값
		// new URL(location.href).searchParams.get("변수명");
	let bno = new URL(location.href).searchParams.get("bno");
	console.log(bno);
	
	
getBoard();
//1. 수정할 게시물의 기존정보를 보여주기

function getBoard(){

	// 3. ajax에게 bno 전달해서 게시물정보 가져오기
	$.ajax({
		url : "/jspweb/BoardInfoController" ,
		method : "get",
		data : {type : 2 , bno : bno} ,
		success : r=>{ console.log(r);
			// 응답 결과 html 대입
			document.querySelector('.bcno').value = `${r.bcno}`;
			document.querySelector('.btitle').value = `${r.btitle}`;
			document.querySelector('.bcontent').value = `${r.bcontent}`;
			document.querySelector('.oldfile').value = `${r.bfile}`;
		} ,
		error : e => {console.log(e);}
	})
} // f end

// 3. 게시물 수정 페이지로 이동 
function onUpdate(){
	console.log('업데이트함수 실행됨');
	// 1. 입력된(수정된) form 정보 한번에 가져오기
		// 1. form 가져오기
	let writeForm = document.querySelectorAll('.writeForm')[0];
		// 2. form 객체화
	let formdata = new FormData(writeForm);
			// 3. form 객체에 데이터 추가 [ bno ]
			// .set(속성명 , 값); // form에 데이터 속성 추가 
	formdata.set("bno", bno);
	console.log("formdata"+formdata);
	// 2. ajax 대용량 (첨부파일)
	$.ajax({
		url: "/jspweb/BoardInfoController" ,
		method : "put" ,
		data :  formdata,
		contentType : false ,
		processData : false , 
		success : r=> {console.log(r);
			if(r){alert('수정성공'); location.href=`/jspweb/board/view.jsp?bno=${bno}`;}
			else{alert('수정실패');}
		} ,
		error : e=> {console.log(e);}
	})
}