// ex11-express-server.js

const express = require('express')
const app = express() // 관용적으로 많이 씀
const PORT = 3000

// get메소드를 지원하는 서버를 생성
app.get('/', (req, res) => {
  res.status(200) // 상태코드를 200(Ok)으로 설정
  res.send('Hello express~') // 화면에 hello express~가 출력됨
})

app.listen(PORT, () => {
  console.log(`${PORT}번 포트에서 실행 중...`)
})
