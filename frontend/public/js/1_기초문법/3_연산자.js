/*	- 연산자 [ 연산/계산 시 사용되는 특수문자 ]
		1. 산술연산자 : + 더하기 - 빼기 * 곱하기 / 나누기 % 나머지
			몫 : parseInt() : 정수로 변환 시켜주는 함수 [ 실수는 짤림 ]
			
		2. 연결연산자 : +연결연산자
			숫자+숫자 [ + 더하기 ]		변수1+변수2 [만약에 두 변수모두 숫자가 저장되어 있으면 더하기]
			숫자+'문자' [ + 연결연산자 ]
			'문자'+'문자' [ + 연결연산자]
			
		3. 비교연산자 : true or false 출력
				> 초과/크다		< 미만/작다
				>=이상/크거나같다	<=이하/작거나같다
				==같다[데이터비교]	===같다[데이터형/데이터 비교]
				!=같지않다/아니다	!==같지않다/아니다
				
		4. 관계연산자 : 주로 비교연산자 2개이상일때 사용, true or false 출력
				&& 이면서 면서 이고 모두 그리고 and [모두 참이면 true]
				|| 이거나 거나 또는 하나라도 or		[하나라도 참이면 true]
				! 반대 부정 not조건 		!true => false / !false => true
				
		5. 대입연산자 :
				= 대입	[오른쪽 데이터를 왼쪽 대입]
				+= [오른쪽 데이터를 왼쪽에 더한후에 왼쪽에 대입]
					1. 변수 = 10
					2. 변수 += 30 [ += 1.더하기를한다 (30+10 => 40) 2.대입한다.]
					3. console.log( 변수 )
				-= *= %=
								
		6. 증감연산자 :
				++ 1증가 [ 선위증가 : ++변수	/ 후위증가 : 변수++ ]
				-- 1감소	[ 선위감소 : --변수 / 후위감소 : 변수-- ]
		
		7. 삼항연산자 : 항 3개 존재하는 연산자 , true or false 출력
				조건 ? 참true : 거짓false
				- 만약에 조건이 true이면 참 실행
				- 만약에 조건이 flase이면 거짓 실행
				-- 중첩가능
				조건1 ? 참1 : 조건2 ? 참2 : 거짓
				
				*/

/*	
// 1. 산술연산자
console.log( '더하기 : ' + 10+3 )	//103
console.log( '더하기 : ' + (10+3)) //13
console.log( '빼기 : ' + (10-3)) //7
console.log( '곱하기 : ' + (10*3)) //30
console.log( '나누기 : ' + (10/3)) //3.3333...
console.log( '나머지 : ' + (10%3)) //1
*/
/*
   -문제1 : prompt 함수로 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점 출력 , 평균 출력
   -문제2 : prompt 함수 로 반지름 입력받아서 원넓이[ 반지름*반지름*3.14 ] 출력
   -문제3 : prompt 함수 로 두 실수를 입력받아서 앞실수의 값이 뒤실수의 값의 몇%인지 출력
*/
/*
// 문제1 
let 국어 = prompt('국어 점수를 입력하세요')
let 영어 = prompt('영어 점수를 입력하세요')
let 수학 = prompt('수학 점수를 입력하세요')
let 총합 = Number(국어)+Number(영어)+Number(수학)

console.log('총점 :' + 총합 + ', 평균 :' + (총합/3))		
		

// 문제2 
let 반지름 = prompt('반지름을 입력하세요')
console.log('원넓이 :'+ (Number(반지름)*Number(반지름)*3.14))
				
				
// 문제3
let 실수1 = 	prompt('실수1을 입력하세요')			
let 실수2 = 	prompt('실수2을 입력하세요')			
let 결과 = Number(실수1) / Number(실수2) * 100

console.log( Math.floor(결과) + '%')

*/			
				
/*

//문제1 :
	// 1. 세 과목 입력받기
let 국어 = Number(prompt('국어 점수 : '))	// 입력후에 변수에 저장 안하면 사라지니까 변수에 저장/대입
let 영어 = Number(prompt('영어 점수 : '))	// Number('300') => 300
let 수학 = Number(prompt('수학 점수 : '))  // Number('숫자') => 숫자		
	//2. 세과목 총점연산
let 총점 = 국어 + 영어 + 수학
let 평균 = 총점 / 3
	//3. 연산 결과 출력
console.log( '총점 : ' + 총점 )			
console.log( '평균 : ' + 평균 )			
		
		
// 문제2 : 
	// 1. 반지름 입력받기
let 반지름 = prompt('반지름 : ')
	// 2. 연산
let 원넓이 = 반지름 * 반지름 * 3.14
	// 3. 연산 결과 출력
console.log( '원넓이 : ' + 원넓이 )	
				
				
//문자 연산 예시
console.log( 10*3 )
console.log( '10'*3 ) //30 더하기는 안되는데 곱하기는 됨


// 문제3
let 실수1 = prompt('실수1 :')
let 실수2 = prompt('실수2 :')
let 백분율 = ( 실수1/실수2 ) * 100

console.log( '두 실수간의 비율: ' + 백분율 + '%')




//2. 비교연산자
console.log('초과 : ' + ( 10>3 )) //true
console.log('미만 :' + ( 10<3 )) //false
console.log('이상 : '+ ( 10>=3 )) //true
console.log('이하 : '+ ( 10<=3 )) //false
console.log('같다 : '+ ( 10==3 )) //false
console.log('같지않다 : '+ ( 10!=3 )) //true

//3. 관계연산자
console.log( '이면서 : ' + (10>3 && 20>15))  // true and true => true
console.log( '이면서 : ' + (10>3 && 20>30))  // true and false => false
console.log( '이거나 : ' + (10>3 || 20>15))	// true or true => true
console.log( '이거나 : ' + (10>3 || 20>30))	// true or false => true
console.log( '부정 : ' + !(10>3))	// true => false


*/

/*
   -문제4 : prompt 함수 로 정수를 입력받아 홀수[true] / 짝수[false] 여부 출력
   -문제5 : prompt 함수 로 정수를 입력받아 7배수이면 true / 아니면 false 출력
   -문제6 : prompt 함수 로 십만원 단위의 금액을 입력받아 지폐 개수 세기 
         356789      결과 : 십만원3장 만원5장 천원6장 
   -문제7 : prompt 함수 로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 와 일치하면 
         결과 : true 출력 아니면 false 출력 
   -문제8 : prompt 함수로 정수를 입력받아 홀수 이면서 7배수이면 true 아니면 false 출력

*/


 /*
//문제4
let 정수 = prompt('정수를 입력하세요')
let 홀짝 = 정수%2
홀짝 == 1 ? console.log('홀수[true]') : console.log('짝수[false]')

//문제5
let 배수 = 정수%7
배수 == 0 ? console.log('true') : console.log('false')

//문제6
let 금액 = prompt('금액을 입력하세요')
let 십만원 = Math.floor(금액/100000)
let 만원 = Math.floor(금액/10000) - 십만원*10
let 천원 = Math.floor(금액/1000) - 십만원*100 - 만원*10
console.log('십만원'+십만원+'장 ' +'만원'+만원+'장 ' + '천원' +천원 +'장')

//문제7
let 아이디 = prompt('아이디를 입력하세요')
let 비밀번호 = prompt('비밀번호를 입력하세요')
아이디 == 'admin' && 비밀번호 == '1234' ? console.log('true') : console.log('false')

//문제8
let 정수2 = prompt('정수를 입력하세요')
let 홀수 = 정수2%2
let 배수2 = 정수2%7
홀수==1 && 배수2==0 ? console.log('true') : console.log('false')



//4. 대입연산자
let 데이터1 = 10 // let키워드(변수)로 '데이터1'이라는 변수명에 10을 저장
console.log(데이터1) // 10
데이터1 += 10 //1. 10+10 => 20 , 20 대입
console.log(데이터1) // 20
데이터1 -= 5 // 20-5 => 15 , 15 대입
console.log(데이터1) //15
데이터1 *= 2 // 15*2 => 30 , 30 대입
console.log(데이터1) // 30

	//예제1
	let html = '<h3> JS에서 작성된 HTML입니다.</h3>' // html언어를 문자열 안에서 작성한다.
	html += '<p>문단 추가했습니다. </p>'
	// html [<h3> JS에서 작성된 HTML입니다.</h3><p>문단 추가했습니다. </p>]
	document.write(html);	//document.write() // document.html문서 , write : 쓰다


//5. 증감연산자 [ data+1 , data+=1 , data++ ]
let 데이터2 = 10;
console.log('data : ' + 데이터2) //10
console.log('data : ' + (데이터2++)) //10에서 1증가?? //10 // 출력후 더하기함
console.log( 'data : ' + 데이터2) //11 // 그래서 그냥 출력하면 11나옴
console.log( 'data : ' (++데이터2)) //11에서 1증가 =>12 // 증가후 출력

console.log( 'data : ' + (데이터2--)); //12에서 1감소?? //12 // 출력후 감소
console.log( 'data : ' + 데이터2 ) // 11
console.log( 'data : ' + (--데이터2)) // 11에서 1감소 ?? //10 //감소후 출력


//6. 삼항연산자 [조건 ? 참 : 거짓 ( 만약에 조건이 true이면 참코드 실행 false이면 거짓코드 실행 )]
	//예제1
let 나이 = 38; // '나이' 변수에 38 저장했다.
let 연령구간 = 나이<=19 ? '청소년' : '성인';
			// 조건 (true/false 결과 갖는 논리 연산)
console.log( '38의 연령구간 : ' + 연령구간 )

	//예제2 [ 조건1 ? 참1 : 조건2 ? 참2 : 조건3 ? 참3 : 거짓]
let 점수 = 78
let 등급 = 점수 >= 90 ? 'A등급' : 
					점수 >= 80 ? 'B등급' : 
								점수 >= 70 ? 'C등급' : '탈락';

	// 조건1 ? '참' : 	조건2 ? '참2' : 	 조건3	? '참3' : '거짓'
console.log(' 점수의 등급 : ' + 등급 ) 

*/


/*
   문제9 : 정수 2개를 입력받아 더 큰수 를 출력
   문제10 : 정수 3개를 입력받아 가장 큰수 를 출력 
   문제11 : 정수 3개를 입력받아 오름차순 으로 출력    [ 7 5 9 -> 5 7 9]
*/

// 문제9
/*
let 정수1 = prompt('정수1을 입력하세요')
let 정수2 = prompt('정수2을 입력하세요')

정수1 > 정수2 ? console.log(정수1) : 정수2 > 정수1 ? console.log(정수2) : console.log('두 정수가 같다')
*/


/*
// 문제10
let 정수1 = prompt('정수1을 입력하세요')
let 정수2 = prompt('정수2을 입력하세요')
let 정수3 = prompt('정수3을 입력하세요')
let 최대값 = 0;

정수1 > 정수2 ? 최대값=정수1 : 정수2 > 정수3 ? 최대값=정수2 : 최대값=정수3
console.log(최대값);
*/

//문제11
let 정수1 = prompt('정수1을 입력하세요')
let 정수2 = prompt('정수2을 입력하세요')
let 정수3 = prompt('정수3을 입력하세요')
let max = 0;
let mid = 0;
let min = 0;

정수1 > 정수2 && 정수1 > 정수3 ? max=정수1 : 정수2 > 정수3 ? max=정수2 : max-정수3 > 0 ? max=max : max=정수3 // max
정수1 < 정수2 && 정수1 <정수3 ? min=정수1 : 정수2 < 정수3 ? min=정수2 : 정수1 > 정수3 ? min=정수3 : min=정수1 // min
max > 정수1 && 정수1>min ? mid=정수1 : 
		max > 정수2 && 정수2>min ? mid=정수2 :
				max > 정수3 && 정수3>min ? mid=정수3 : mid=정수1  //mid

console.log('최대값'+ max +'중간값' + mid + '최소값' + min)

//문제12










