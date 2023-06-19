/*	- 연산자 [ 연산/계산 시 사용되는 특수문자 ]
		1. 산술연산자 : + 더하기 - 빼기 * 곱하기 / 나누기 % 나머지
		
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
				
// 1. 산술연산자
console.log( '더하기 : ' + 10+3 )	//103
console.log( '더하기 : ' + (10+3)) //13
console.log( '빼기 : ' + (10-3)) //7
console.log( '곱하기 : ' + (10*3)) //30
console.log( '나누기 : ' + (10/3)) //3.3333...
console.log( '나머지 : ' + (10%3)) //1

/*
   -문제1 : prompt 함수로 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점 출력 , 평균 출력
   -문제2 : prompt 함수 로 반지름 입력받아서 원넓이[ 반지름*반지름*3.14 ] 출력
   -문제3 : prompt 함수 로 두 실수를 입력받아서 앞실수의 값이 뒤실수의 값의 몇%인지 출력
*/

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
console.log( '10'*3 )


*/
