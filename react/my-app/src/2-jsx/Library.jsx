import React from "react";
import Book from "./Book"; //확장자 생략 가능 (.jsx)

function Library() {
  return (
    <div>
      <Book name="리액트 기초" price={3000} />
      <Book name="노드JS 기초" price={4000} />
      <Book name="AWS 기초" price={5000} />
    </div>
  );
}

export default Library;
