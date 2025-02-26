//ex04.ts

//타입 별칭(Type Alias)
// 코드 수 줄임, 재사용성 높임
type User = {
  id: number
  name: string
  nickname: string
  birth: string
  location: string
  phone: string
}

let user1: User = {
  id: 1,
  name: '홍길동',
  nickname: 'hong',
  birth: '2000.01.01',
  location: '한양',
  phone: '010-1111-2222',
}

let user2: User = {
  id: 2,
  name: '사입당',
  nickname: 'dang',
  birth: '2000.01.01',
  location: '한양',
  phone: '010-1111-2222',
}

// 객체 리터럴
type CountryCodes = {
  Korea: string
  UnitedState: string
  UnitedKingdom: string
}

let countryCodes: CountryCodes = {
  Korea: 'ko',
  UnitedState: 'us',
  UnitedKingdom: 'uk',
  // countryCodes가 200개가 넘는다면... 다 일일히 쓸 수가 없음
  // => 인덱스 시그니처 사용
}

// 인덱스 시그니처
type CountryCodes2 = {
  //key도 string, value도 string이라는 뜻
  [key: string]: string
}
let countryCodes2: CountryCodes2 = {
  Korea: 'ko',
  UnitedState: 'us',
  UnitedKingdom: 'uk',
  // Japan: 123,  => 타입이 안 맞으면 오류 발생
}

//      인덱스 시그니처 확장
type CountryCodes3 = {
  [key: string]: string
  Korea: 'ko' // Korea는 꼭 있어야 함
}

let countryCodes3: CountryCodes3 = {
  Korea: 'ko', // 꼭 있어야 함. 없으면 오류 발생
}
