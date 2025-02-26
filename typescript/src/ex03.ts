//ex03.ts

//객체의 타입
let user1: object = {
  id: 1,
  name: "홍길동",
};
// 오류 발생 : 'object' 형식에 'id' 속성이 없습니다.
// user1.id
// 해결) object 타입이 아닌 객체 리터럴 타입으로 선언

// 객체 리터럴 타입
let user2: {
  id: number;
  name: string;
} = {
  id: 1,
  name: "홍길동",
};
// (porperty) id: number
user2.id; // 오류 안 남

let user3: {
  id?: number; // 속성 이름 뒤에 ? => 선택적 프로퍼티. 해당 속성 생략 가능
  name: string;
} = {
  // id: 1,
  name: "홍길동",
};

let config: {
  readonly apiKey: String; // 읽기 전용 속성 => 수정 불가능
} = {
  apiKey: "MY API KEY",
};
// config.apiKey = "1223234"; 읽기 전용 속성이기 때문에 수정 불가능. 오류 발생.
