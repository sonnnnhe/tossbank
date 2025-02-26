// ex09.ts
// 타입 좁히기

function func1(value: number | string) {
  // value.toFixed() // toFixed(): number타입에서 실수형으로 바꾸기
  //                            value가 string타입일 수도 있기 때문에 오류 발생
  // value.toUpperCase() // string타입에만 한해 대문자로 바꾸기
  //                        value가 number타입일 수도 있기 때문에 오류 발생
  if (typeof value === 'number') {
    value.toFixed()
  } else if (typeof value === 'string') {
    value.toUpperCase()
  }
}
