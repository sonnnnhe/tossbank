console.log("Hello TypeScript");
//     : type  을 적어줘야 함
const a: number = 1;

// tsconfig.json에서
// strict: true 일 때 엄격한 타입 검사 실시
// message 뒤에 : type이름 명시 필수
const hello = (message: string) => {
  console.log(message);
};

// tsc src/index.ts 시 index.js 파일이 만들어짐(컴파일)
// tsc로 js 파일 생성 시 node로 js 파일을 실행해야 하는데
// 이 두가지 동작을 한번에 할 수 있는 명령어가 있다
//    : tsx 'ts파일경로'
//    => 컴파일과 실행을 한번에 수행
