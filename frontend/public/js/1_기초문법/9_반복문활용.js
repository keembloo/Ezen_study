

let output = ``; 	// 출력용 변수 [모든문제에서 사용]

/*
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
*/

/*
// 문제3) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
output = ``; // 공백으로 초기화
let value3 = prompt('문제3:');

for (let i = 1; i <= value3; i++) { // 1 
	for (let j = 1; j <= value3; j++) {
		output += `*`;
	}
	output += `\n`;
}
console.log(output);


// 문제4) 입력받은 줄 수 만큼 * 출력 [ ex) 5 ]
output = ``; // 공백으로 초기화
let value4 = prompt('문제4:');

for (let i = 1; i <= value4; i++) {
	for (let j = value4; j >= i; j--) {
		output += `*`;
	}
	output += `\n`;
}
console.log(output);



// 문제5) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
output = ``; // 공백으로 초기화
let value5 = prompt('문제5:');

for (let i = 1; i <= value5; i++) {
	output += `\n`;
	for (let j = value5-1; j >= i; j--) {
		output += ` `;
	}
	for (let k = 1; k <= i; k++) {
		output += `*`;
	}
}
console.log(output);


// 문제6) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
output = ``; // 공백으로 초기화
let value6 = prompt('문제6:');

for (let i = 1; i <= value6; i++) {
	output += `\n`;
	for (let k = 1; k < i; k++) {
		output += ` `;
	}
	for (let j = value6; j >= i; j--) {
		output += `*`;
	}
}
console.log(output);
*/

// 문제7) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]
output = ``; // 공백으로 초기화
let value7 = prompt('문제7:');


for (let i = 1; i <= value7; i++) { // 줄만들기
	output += `\n`;
	for (let k = value7; k >= i; k--) {  // 공백 만들기
		// 입력값과 같게 시작해서, 현재줄수 값보다 크거나 같을때까지, 공백은 줄어듬
		output += ` `;
	}
	for (let j = i; j <= (value7*2)-1; j+=2) { // 별찍기
		// 1부터 시작해서, (입력값의2배)-1다 작거나같아질때까지, 2씩 증가
		output += `*`;
	}
}
console.log(output);











