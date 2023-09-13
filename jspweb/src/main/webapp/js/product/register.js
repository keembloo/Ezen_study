

// 1. 제품 등록
function onRegister(){
	
	// 1. form dom객체 호출 
	let registerForm = document.querySelectorAll('.registerForm')[0];
	console.log('registerForm'+registerForm);
	// 2. formData 객체 생성 [ ajax 전송타입 : multipart/form-data ]
	let formData = new FormData(registerForm);
	console.log(formData);
	
	// 3. 
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "post" ,
		data : formData ,
		contentType : false , 
		processData : false , 
		success : result => {console.log(result);} ,
		error : e => {console.log(e);}
	})
}