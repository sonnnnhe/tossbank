//ex10-express.js
// express(익스프레스) 프레임워크 소개

// response : html, json, xml

//웹서버를 구현하기 위해 필요한 여러 기능을 제공한다.
//1. 라우팅 - URI 경로에 따른 처리
//2. 미들웨어 : 요청과 응답을 처리하는 중간에 들어가는 여러기능을 담당하는 모듈들
//3. 뷰 템플릿 엔진 : 동적인 html파일을 생성하기 위해 data-binding을 제공함.
//                    (응답이 html로 온다고 가정한 상태)
//4. 정적인 파일 지원 : html, css, js, 이미지(png, jpg, svg), 동영상(mp4)

//익스프레스 모듈 설치
//1. npm init  : node 모듈 초기화
//2. npm i express : express 모듈 설치
//* --save : 모듈을 설치하고 나서, package.json > dependency에 모듈명을 기록하는 옵션.
//         -> 요즘은 default로 설정되어있기 때문에 안 써도 됨 (예전에는 써야 기록됐음)

//맥os
//1. sudo npm init
//2. sudo npm i express

//node ex01.js => 그냥 실행. 코드 수정 시 재실행 필요
//nodemon ex01.js => 백그라운드에서 계속 돌고 있음. 코드 수정 시 자동으로 재구동

// 노드몬(nodemon) 모듈 설치
// 노드몬 : 노드 서버 코드 변경시(저장) 자동으로 서버 재구동해줌.
// npm i -g nodemon  (-g : PC 전체 설치)

// node 코어모듈에 있는 http 모듈을 사용한 간단한 웹서버
const http = require('node:http')
//                    node 모듈에 있는 http 모듈을 사용한다는 뜻

// 요청 발생시 해야할 일을 콜백함수에 등록한다.
//                  createServer(콜백함수)
const server = http.createServer((req, res) => {
  console.log('HTTP 요청 발생') // req : 요청에 대한 정보를 담고 있는 객체
})

// 3000번 포트에서 서버 실행
//     listen(Port, 콜백함수)
//          다른 포트번호로 바꿀 수 있음
server.listen(3000, () => {
  console.log('3000번 포트에서 서버 실행 중...222')
})

//node ex10-express.js
// => 무한루프... 웹브라우저에서 localhost:3000 으로 이동시 "HTTP 요청 발생" 출력 (= 응답한 것)
//nodemon ex10-express.js
// => 무한루프... 코드 수정 시 자동으로 재구동. 개발 시에는 편함]
// WB localhost:3000

// 리액트 CRA-3000, VITE-5176
// 노드 3000
