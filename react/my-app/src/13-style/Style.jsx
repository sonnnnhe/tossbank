// 리액트에서 CSS를 구현하는 방법
// 1. JS Inline Style 속성
// 2. styled-componentrs 모듈 사용
// 3. tailwind-css 모듈을 사용

// 1. JS Inline Style 속성
import React from "react";

function InlineStyle() {
  const boxStyle = {
    backgroundColor: "lightBlue",
    color: "darkblue",
    padding: "20px",
    border: "2px solid navy",
    borderRadius: "8px",
    textAlign: "center",
  };
  return (
    // style이 기니까 boxStyle 변수로 ..
    <div style={boxStyle}>
      <h1 style={{ fontSize: "24px", margin: "0" }}>
        리액트 인라인 스타일 예제
      </h1>
      <p style={{ fontStyle: "italic" }}>JS 객체로 스타일을 적용하는 예제</p>
    </div>
  );
}

export default InlineStyle;

// React + CSS 관련 플러그인
// 1. ES7+ React/Redux/React-Native sinppets
// 2. Auto Import
// 3. ESLint : 문법체크
// 4. Prettier - Code formatter
// 5. vscode-syled-components
// 6. Tailwind CSS IntelliSense
