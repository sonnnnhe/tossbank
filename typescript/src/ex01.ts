// ex01.ts
// 기본 타입(Primitive type) : 하나의 값만 가지는 타입

// 타입스크립트는 아래 두가지 선언 다 허용
// 명시적 타입선언
// let myNum: number = 123;
// 암묵적 타입선언
// let myNum2 = 123;

// number
let num1: number = 123;

// string
let str1: string = "hello";

// boolean
// let bool1: boolean = "hello"; 시 오류 발생
let bool1: boolean = true;

// null
let null1: null = null;

// undefined
let unde1: undefined = undefined;

// 리터럴 타입
let lit1: 10 = 10; // 10이라는 값 외에는 넣지 못함

//"strictNullChecks": true,
// => null값을 변수에 할당하지 못하도록 한다.
let numA: number = null;
