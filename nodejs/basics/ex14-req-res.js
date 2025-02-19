// ex14-req-res.js

//익스프레스의 요청 객체와 응답 객체

// <요청객체의 주요 속성>
// req.body : 서버로 POST 요청할 때 넘겨준 정보를 담고 있다. JSON,File(Bin)
// req.cookies : 클라이언트에 저장된 쿠키 정보를 HTTP에 담아서 보낼때 쿠키정보를 담고 있음.
//              클라이언트에 저장된 임시값(장바구니-비회원) 저장하는 용도
// req.headers : 서버로 요청을 보낼 때 같이 보낸 헤더 정보를 담고 있음.
// req.params : URL 뒤에 파라미터가 포함되어 있는 경우에 파라미터 정보를 담고 있음.
//             localhost:3000/posts/100   ->   params.id = 100 로 읽힘
// req.query : 요청 URL의 포함된 질의 매개변수(query)를 담고 있음.
//            localhost:3000/login?id=hong&pw=1234 에서 ?id=hong&pw=1234가 query에 해당
//             { "id": "hong", "pw": "1234" } 로 읽힘

// <응답객체의 주요 속성>
// res.download : 파일을 다운로드할 때 사용함.
// res.end : 응답 프로세스를 종료한다.
// res.json : JSON 응답을 전송한다. Content-Type 헤더를 자동으로 생성함.
// res.jsonp : JSONP 지원을 통해 JSON응답을 한다.
//             JSONP란 CORS(크로스오리진)문제을 피하기 위해 별도의 방식으로 JSON을 가져오는 방식
// res.redirect : 요청 경로를 재지정하여 강제 이동한다.
//                응답 헤더의 setLoaction속성에 이동할 경로를 기술하면,
//                클라가 이 경로로 이동한다.
// res.render : 뷰 템플릿을 화면에 렌더링(그린다)한다.
// res.send : 어떤 유형이든 res.send() 괄호안에 내용(변수,객체)을 전달한다.
// res.sendFile : 지정한 경로의 파일을 읽어서 내용을 전송한다.
// res.sendStatus : 상태 메시지와 함께 HTTP 상태 코드를 전송한다.
// res.status : 응답의 상태 코드를 설정한다. (상태 메시지 X)

const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {
  res.status(200)
  // content-type : text/html; charset=utf-8
  // res.send('Hello Express~')

  // content-type : application/json; charset=utf-8
  // JS객체를 문자열로 변환하여(JSON.stringify) 응답함. 응답헤더도 json변경.
  res.json({ message: 'Hellow json~' })
})

// login으로 접속 시 join으로 경로 재지정 (강제 이동)
app.get('/login', (req, res) => {
  console.log('회원가입으로 이동합니다.')
  res.redirect('/join')
})
app.get('/join', (req, res) => {
  console.log('회원가입 폼입니다.')
})

app.listen(3000, () => {
  console.log(`${port}번 포터에서 서버 실행 중...`)
})
