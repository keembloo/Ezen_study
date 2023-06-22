

let output = ``; 	// 출력용 변수 [모든문제에서 사용]
// 문제1) 입력받은 수 만큼 * 출력 
let value1 = prompt('문제1:');
for (let i = 1; i <= value1; i++) { // for s
	// i는 1부터 입력받은수까지 1씩증가반복
	output += `*`;
} // for e

console.log(output);


// 문제2) 입력받은 수 만큼 * 출력 [  - 3줄(3배수)마다 줄바꿈 ]
output = ``; // 공백으로 초기화
let value2 = prompt('문제2:');
for (let i = 1; i <= value2; i++) { // for s
	output += `*`;
	if (i % 3 == 0) { // if s
		output += `\n`;
		// \ : 제어문자(이스케이프문자) \t : 들여쓰기 \n  : 줄바꿈
	} // if e
} // for e
console.log(output);


// 문제3) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
output = ``; // 공백으로 초기화
let value3 = prompt('문제3:');






















