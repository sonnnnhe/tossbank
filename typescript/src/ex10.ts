// ex10.ts
// 함수 타입

function func1(a: number, b: number): number {
  return a + b
}

// 반환값은 타입 생략해도 됨. 타입 추론 가능
function func2(a: number, b: number): number {
  return a + b
}

function func3(name: string = '홍길동') {
  return name
}
console.log(func3())

// 선택적 매개변수
function func4(name: string, age?: number) {
  return name
}
func4('홍길동')

// 나머지 매개변수
function getSum2(a: number, b: number, c: number) {}
function getSum(...rest: number[]) {
  let sum = 0
  rest.forEach((value) => (sum += value))
  return sum
}
getSum(1, 2, 3) // 1, 2, 3이 number[] 배열에 들어감

// 함수 타입 선언식
const add = (a: number, b: number) => a + b
const sub = (a: number, b: number) => a - b
const mul = (a: number, b: number) => a * b
const div = (a: number, b: number) => a / b

type Operation = (a: number, b: number) => number
const add2: Operation = (a, b) => a + b
const sub2: Operation = (a, b) => a - b

// 호출 시그니처
//  : 객체 안에 type 시그니처를 적어줌
type Operation2 = {
  (a: number, b: number): number
}
const add3: Operation2 = (a, b) => a + b
