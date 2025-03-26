let express = require("express");
let app = express();
let mysql = require("mysql");
const cors = require("cors");
const { log } = require("console");

//모듈 설치
//npm i nodemon express mysql
//npm i cors

//CORS 허용
app.use(
  cors({
    origin: "*", // 모든 출처 허용 옵션. true 를 써도 된다.
  })
);

const port = process.env.PORT || 3030;

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

//connect mysql database
let conn = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "mysql123",
  database: "mydb",
});

conn.connect(); // mysql 연결하기

app.get("/", (req, res) => {
  return res.json({
    error: false,
    message: "Welcome to dashboard node js.",
  });
});

// 게시글 목록 조회
app.get("/posts", (req, res) => {
  conn.query("SELECT * FROM post", (error, results) => {
    if (error) throw error;

    let message = "";
    if (results === undefined || results.length == 0) {
      message = "post table is empty";
    } else {
      message = "Successfully retrived all post";
    }

    return res.json(results);
  });
});
// 게시글 단건 조회
app.get("/posts/:id", (req, res) => {
  try {
    conn.query(
      `SELECT post.*
              ,JSON_ARRAYAGG(
                JSON_OBJECT(
                  'id', comment.id,
                  'content', comment.content
                )
              ) AS comments
      FROM post
      LEFT OUTER JOIN comment
      ON post.id = comment.post_id
      WHERE post.id=${req.params.id}`,
      (error, results) => {
        if (error) throw error;

        const jsonResult = results.map((post) => {
          return {
            ...post,
            comments: JSON.parse(post.comments),
          };
        });

        return res.json(jsonResult);
      }
    );
  } catch (err) {
    console.error("server error:", err);
  }
});
// 게시글 추가
app.post("/posts", (req, res) => {
  try {
    if (!req.body.title || !req.body.content) {
      return res.status(400).json({ error: "제목과 내용 필요" });
    }

    conn.query(
      "INSERT INTO post VALUES (0, ?, ?)",
      [req.body.title, req.body.content],
      (error, results) => {
        if (error) throw error;

        return res.json(results);
      }
    );
  } catch (err) {
    console.error("server error:", err);
  }
});
// 게시글 삭제
app.delete("/posts/:id", (req, res) => {
  try {
    conn.query(
      `DELETE FROM post WHERE id = ${req.params.id}`,
      res.json({ message: "Post Deleted" })
    );
  } catch (err) {
    console.error("server error:", err);
  }
});
// 댓글 추가
app.post("/posts/:id/comments", async (req, res) => {
  try {
    await conn.query(
      `INSERT INTO comment VALUES (0, ${req.params.id}, "${req.body.content}")`
    );
    await conn.query(
      `SELECT post.*
              ,JSON_ARRAYAGG(
                JSON_OBJECT(
                  'id', comment.id,
                  'content', comment.content
                )
              ) AS comments
      FROM post
      LEFT OUTER JOIN comment
      ON post.id = comment.post_id
      WHERE post.id=${req.params.id}`,
      (error, results) => {
        if (error) throw error;

        const jsonResult = results.map((post) => {
          return {
            ...post,
            comments: JSON.parse(post.comments),
          };
        });

        return res.json(jsonResult);
      }
    );
  } catch (err) {
    console.error("server error:", err);
  }
});

app.listen(port, () => {
  console.log("Listening on port %d", port);
});

module.exports = app;
