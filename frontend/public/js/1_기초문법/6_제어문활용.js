/*

	  조건 : 반복문X 입력:prompt 출력 : console 
	   문제 1 : 2개의 정수 를 입력받아서 가장 큰수를 출력 
	   문제 2 : 3개의 정수 를 입력받아서 가장 큰수를 출력     [ max 함수 x ]
	   문제 3 : 4개의 정수 를 입력받아서 가장 큰수를 출력    [ max 함수 x ]
	   
	   문제 4 : 3개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
	   문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
	   
	   문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
	   문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
							80점이상 B등급 출력 
							70점이상 C등급 출력  
							그외 재시험
	   문제 8 : 아이디와 비밀번호 입력받기 
			 회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 
									 아니면 로그인실패 출력
									 
*/

/*
// 문제 1 : 2개의 정수 를 입력받아서 가장 큰수를 출력 
	// 1. 입력받아 변수에 저장
let num1 = Number(prompt('문제1_정수1를 입력하시오'));
let num2 = Number(prompt('문제1_정수2를 입력하시오'));
	// 2. if 이용한 논리제어
if (num1 == num2) {
	console.log('두수가 같다');
} else if (num1 > num2) {
	console.log(num1);
} else { console.log(num2);}


// 문제 2 : 3개의 정수 를 입력받아서 가장 큰수를 출력     [ max 함수 x ]
let num3 = Number(prompt('문제2_정수1를 입력하시오'));
let num4 = Number(prompt('문제2_정수2를 입력하시오'));
let num5 = Number(prompt('문제2_정수3을 입력하시오'));
let max1 = num3;

if( max1<num4 ) {max1=num4;}
if( max1<num5 ) {max1=num5;}
console.log(max1);


// 문제 3 : 4개의 정수 를 입력받아서 가장 큰수를 출력    [ max 함수 x ]
let num6 = Number(prompt('문제3_정수1를 입력하시오'));
let num7 = Number(prompt('문제3_정수2를 입력하시오'));
let num8 = Number(prompt('문제3_정수3을 입력하시오'));
let num9 = Number(prompt('문제3_정수4을 입력하시오'));
let max2 = num6;

if( max2<num7) {max2= num7;}
if( max2<num8) {max2= num8;}
if( max2<num9) {max2= num9;}
console.log(max2);


// 문제 4 : 3개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
let int1 = Number(prompt('문제4_정수1를 입력하시오')); //3
let int2 = Number(prompt('문제4_정수2를 입력하시오')); //5
let int3 = Number(prompt('문제4_정수3을 입력하시오')); //2
// 정렬 = 하나씩 비교해서 자리 교체

if(int1> int2) { // 조건1 : > 오른차순 	< 내림차순
		// * 스왑 
	let temp = int1; // 1. 임시변수에 3저장
	int1 = int2;	// 2. 3있던 변수에 5저장
	int2 = temp;	// 3. 5있던 변수에 3저장
}
if (int1 > int3) {
	let temp = int1;
	int1 = int3;
	int3 = temp;
}
if (int2 > int3) {
	let temp = int2;
	int2 = int3;
	int3 = temp;
}

console.log( int1 + ' ' + int2 + ' ' + int3 )


// 문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
let int4 = Number(prompt('문제5_정수4를 입력하시오')); //3
let int5 = Number(prompt('문제5_정수5를 입력하시오')); //5
let int6 = Number(prompt('문제5_정수6을 입력하시오')); //2
let int7 = Number(prompt('문제5_정수7을 입력하시오')); //2

if (int4> int5) {
	let temp = int4;
	int4= int5;
	int5 = temp;
}
if (int4 > int6) {
	let temp = int4;
	int4 = int6;
	int6 = temp;
}
if (int4 > int7) {
	let temp = int4;
	int4 = int7;
	int7 = temp;
}
if (int5 > int6) {
	let temp = int5;
	int5 = int6;
	int6 = temp;
}
if (int5 > int7) {
	let temp = int5;
	int5 = int7;
	int7 = temp;
}
if (int6 > int7) {
	let temp = int6;
	int6 = int7;
	int7 = temp;
}

console.log(int4 +' '+ int5 +' '+ int6 +' '+ int7)
*/

// 문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
let score = Number(prompt('점수 : ')) // 1. 입력받은 값을 변수에 저장

if (score >= 90) { console.log('합격'); }
else { console.log('탈락'); }

/*문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
							80점이상 B등급 출력 
							70점이상 C등급 출력  
							그외 재시험*/
// 문제6 입력값 그대로 사용
if (score >= 90) { console.log('A등급'); }
else if (score >= 80) { console.log('B등급'); }
else if (score >= 75) { console.log('C등급'); }
else { console.log('재시험'); }

/*문제 8 : 아이디와 비밀번호 입력받기 
			 회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 
									 아니면 로그인실패 출력*/
let id = prompt('아이디 : ')
let pw = prompt('비밀번호 : ')

if (id == 'admin') { // 조건1 : 아이디검사
	if (pw == '1234') {	 // 조건2 : 비번검사
		console.log('로그인 성공');
	} else {
		console.log('비밀번호가 틀렸습니다');
	}
} else { // 아이디가 다르면
	console.log('없는 아이디입니다');
}





















