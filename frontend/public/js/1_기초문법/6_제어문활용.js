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

console.log( int1 + '' + int2 + '' + int3 )



// 문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력 















