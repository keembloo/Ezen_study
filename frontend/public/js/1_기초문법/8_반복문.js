/*
	
	반복문 : 어디서부터 어디까지
		1. 
		for( 1.초기값 ; 2.조건문 ; 4.증감식 ) {
			3. 실행코드;
		}
		
			1. 초기값 : 반복의 처음값
				; : 구역부분
			2. 조건문 : 조건 true이면 {}실행 아니면 {}실행 안함
				;
			3. 실행문 : 반복시 실행될 코드
			4. 증감식 : 반복변수 증가/감소 단위
			
			
		ex) 1부터 10까지 1씩증가 반복
			for( let i = 1 ; i<=10 ; i++ ){}
		ex) 1부터 100까지 홀수만 반복
			for( let i = 1 ; i<=100 ; i+=2 ){}
		
		
 */

// 1.
// let i = 0 ; // 1. 초기값 ( i는 반복시 사용되는 증감변수)
// i<10 ;	 // 2.조건문 ( 조건결과가 true이면 {} 실행되는 조건 )
// i++ 		// 3. 증감식 ( {}실행후 다음으로 증감변수 계산식 )

for (let i = 0; i < 3; i++) { // for start
	// i는 0부터 10미만까지 1씩증가 반복
	console.log('반복횟수 : ' + i);


	/* 순서도 = 알고리즘 != 자료구조 
    
		 1. let i = 0 	=> i = 0
		 2. i<3			=> true => { }
		 3. console.log( ); => 0 출력
		 -------
		 4. i++			=> i = 1
		 5. i<3			=> ture => {}
		 6. console.log(); => 1 출력
		 -------
		 7. i++			=> i = 2
		 8. i<3			=> true => {}
		 9. console.log(); => 2출력
		 -------
		 10. i++ 		=> i = 3
		 11. i<3			=> false => 못들어감
		 12. 반복문 종료
    
	*/
} 		// for end


// 2. 배열(인덱스)과 반복문
let 상자 = ['사과', '포도', '딸기']
//1.반복문이 없을때 [인덱스 다수일때 힘듬]
console.log(상자[0]);
console.log(상자[1]);
console.log(상자[2]);

//2.반복문을 사용할때 [i반복변수를 인덱스 대신 사용]
for (let i = 0; i < 상자.length; i++) { //for s
	console.log(상자[i]);
} // for e

// 예제1) i는 1부터 10이하까지 1씩 증가 반복 [한줄씩표시]
console.log('--------- ex1 --------- ');
for (let i = 1; i <= 10; i++) {
	console.log(i);
}

// 예제2) i는 1부터 10이하까지 1씩 증가 반복[한줄에 표시]
console.log('--------- ex2 --------- ');
let output = ``; // 문자열을 누적으로 저장할 변수 선언

for (let i = 1; i <= 10; i++) { // for s
	output += `${i}\t`  //  \t : 제어문자(들여쓰기)   (+=) i변수를 output변수에 추가
} // for e
console.log(output);


// 예제3) i는 1부터 10이하까지 1씩 증가 반복 [html 표시]
console.log('--------- ex3 --------- ');
output = ``; // 위에서 선언된 output변수를 재선언하지 않고 공백으로 대입(초기화)
for (let i = 1; i <= 10; i++) { //for s
	output += `<p>${i}</p>`;
} // for e
document.write(output);


// 예제4) i는 1부터 10이하까지 1씩 증가 반복 [ 누적합계 ]
console.log('--------- ex4 --------- ');
let sum = 0; // 1부터 10까지 누적으로 더한 값을 저장할 변수
for (let i = 1; i <= 10; i++) { // for s
	// 1. sum = sum+i
	// 2. sum += i
	sum += i // (+=) 기존 sum 변수에 i를 더한값을 sum에 대입


} // for e

console.log(sum);
/* 예제4 순서도

	초기값 i = 1 / sum = 0
	for 시작
		i					조건					실행				누계				증감
		i = 1				1<=10 T				sum+=1			0+1=>1			i++
		i = 2				2<=10 T				sum+=2			1+2=>3			i++
		i = 3				3<=10 T				sum+=3			3+3=>6			i++
		i = 4				4<=10 T				sum+=4			6+4=>10			i++
		i = 5				5<=10 T				sum+=5			10+5=>15		i++
		i = 6				6<=10 T				sum+=6			15+6=>21		i++
		i = 7				7<=10 T				sum+=7			21+7=>28		i++
		i = 8				8<=10 T				sum+=8			28+8=>36		i++
		i = 9				9<=10 T				sum+=9			36+9=>45		i++
		i = 10				10<=10 T			sum+=10			45+10=>55		i++
		i = 11				11<=10 F			반복문 종료

 */


// 예제5) i는 1부터 100까지 7배수 누적합계
console.log('--------- ex5 --------- ');
// 1. 7씩 증가방식
sum = 0;
for (let i = 0; i <= 100; i += 7) { // for s
	sum += i;
} // for e
console.log(sum);

// 2. if(값%7 == 0)
sum = 0;
for (let i = 1; i <= 100; i++) { // for s
	if (i % 7 == 0) { // if s
		sum += i;
	} // if e
} // for s
console.log(sum);


// 예제6) 구구단 2단 출력	(단 : 2[고정] 곱 : 1~9[증가변수])
console.log('--------- ex6 --------- ');
const 단2 = 2;

for (let i = 1; i < 10; i++) { // for s
	console.log(`${단2} * ${i} = ${단2 * i}`); // `문자열${변수}`
} // for e


// 예제7) 구구단 작성
console.log('--------- ex7 --------- ');
const 단 = 2;

for (let i = 2; i <= 9; i++) { // for1 s
	for (let j = 1; j <= 9; j++) { // for2 s
		console.log(`${i} * ${j} = ${i * j}`);
	} // for2 e
} // for1 e













