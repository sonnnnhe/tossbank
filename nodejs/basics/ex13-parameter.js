//ex13-parameter.js
//라이트(URL) 파라미터로 동적 URL 처리하기

const express = require('express')
const app = express()
const port = 3000

// 인덱스 페이지 (시작 페이지)
app.get('/', (req, res) => {
  res.status(200)
  res.send('Hello Express~')
})
// 게시글 목록 조회
app.get('/posts', (req, res) => {
  res.status(200)
  res.send('게시물 목록 조회')
})
//게시글 단건 요청 - id 필요
// /:id => req.params에 저장됨. req.params.id 로 접근
//        만약 /:no이면 req.params.no로 접근하는 것
app.get('/posts/:id', (req, res) => {
  res.status(200)
  res.send(`게시글 단건 조회 ID: ${req.params.id}`)
})
//게시글 추가 post
app.post('/posts', (req, res) => {
  res.status(200)
  res.send('게시글 추가')
})
//게시글 수정 put - id 필요
app.put('/posts/:id', (req, res) => {
  res.status(200)
  res.send(`게시글 수정 ID: ${req.params.id}`)
})
//게시글 삭제 delete - id 필요
app.delete('/posts/:id', (req, res) => {
  res.status(200)
  res.send(`게시글 삭제 ID: ${req.params.id}`)
})

app.listen(port, () => {
  console.log(`${port}번 포트에서 서버 실행 중...`)
})
