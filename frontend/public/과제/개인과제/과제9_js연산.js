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
let player1 = prompt('플레이어1의 값 0, 1, 2 중 입력하세요')
let	player2 = prompt('플레이어2의 값 0, 1, 2 중 입력하세요')


player1 == player2 ? console.log('무승부입니다') : 
	player1 > player2 && player1 !=2 && player2 !=0 ? console.log('플레이어1승리') : 
		player2 > player1 && player2 !=2 && player1 !=0 ? console.log('플레이어2승리') :
				player1 == 2 && player2 == 0 ? console.log('플레이어2승리') :
				player2 == 2 && player1 == 0 ? console.log('플레이어1승리') :
						player1 > player2 ? console.log('플레이어1승리') : console.log('플레이어2승리')
						

