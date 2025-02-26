//ex05.ts

//열거형 타입
//  여러가지 값들에 각각 이름을 부여해 열거해두고 사용하는 타입

// 자동차 게임
let myCarType = 0 // 0 세단, 1 스포츠카, 2 SUV, 3 지프카...
//                   위 주석이 없으면 0이 어떤 의미인지 알 수 없음

// 훨씬 가독성이 좋은 코드
enum CarType {
  //      시작값 지정 가능
  Sedan = 10, //기본값 0  (0부터 자동으로 하나씩 증가된 수가 할당되는 것)
  Sport,
  SUV,
  Jeep,
}
myCarType = CarType.Sedan // 기본값 0,   10으로 설정 시
myCarType = CarType.Sport //        1         11

// 문자열도 설정 가능
enum Lang {
  korean = 'ko',
  english = 'en',
}

let user = {
  name: '홍길동',
  lang: Lang.korean,
  car: CarType.Sedan,
}

// 타입스크립트에만 있는 변수 타입 (자바스크립트에는 X)
// unknown, any(가급적 사용하지 말 것), void, never(그 어떤 값도 가질 수 없는 타입), enum, tuple
