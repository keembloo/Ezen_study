
//1.

$.ajax({
	url : "/jspweb/Sample",
	data:{ type: 1 },
	method:"get",
	success : r => {
		console.log('성공');
	}
})

//2.
$.ajax({
	url : "/jspweb/Sample",
	data:{ type: 2 , slat , slng , elat , elng },
	method:"get",
	success : r => {
		console.log('성공');
	}
})

//3.
$.ajax({
	url : "/jspweb/Sample",
	data: { type: 3 , pno : pno },
	method:"get",
	success : r => {
		console.log('성공');
	}
})

//4.
$.ajax({
	url : "/jspweb/Sample",
	data: {type: 4 , page : 1 , listsize : 5 },
	method:"get",
	success : r => {
		console.log('성공');
	}
})