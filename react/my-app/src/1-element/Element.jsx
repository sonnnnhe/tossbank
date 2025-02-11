// 리액트 엘리먼트(React Element)란?
// 리액트 엘리먼트는 리액트 앱의 UI를 구성하는 가장 작은 단위입니다.
// 엘리먼트는 화면에 표시될 내용을 설명하는 자바스크립트 객체로,
// 컴포넌트를 생성하고 렌더링하는 데 사용됩니다.

// 리액트 엘리먼트는 **불변(immutable)**이며 한 번 생성되면 그 내용을 변경할 수 없습니다. 대신 새로운 엘리먼트를 생성하여 화면의 변화를 반영합니다.

// 리액트 엘리먼트의 특징
// 1. 불변성: 엘리먼트는 한 번 생성되면 변경할 수 없습니다.
// 2. 가볍고 빠름: 가상 DOM을 사용하여 변경 사항을 효율적으로 관리합니다.
// 3. UI의 구성 단위: 컴포넌트 내에서 리액트 엘리먼트는 HTML 태그처럼 사용됩니다.

import React from "react"; // package.json에서 가져다 쓰는 것
// React 17이상에서는 import하지 않아도 JSX 사용 가능함. import 생략 가능.

// 내보내기 방법
const E1 = <h1>리액트 엘리먼트1입니다.</h1>;
// 1. 내보내고자 하는 element 앞에 export 작성
export const E2 = React.createElement(
  "h1", // type
  null, // props(속성).. className="greeting"일 경우 props가 {className: 'greeting'}이 되는 것
  "리액트 엘리먼트2입니다." // [...children]
);
export const E3 = <h1 style={{ color: "blue" }}>엘리먼트3</h1>;
//                           {}가 두개인 이유
//                           - jsx에서 js를 쓰려면 {} 필요
//                           - key-value 객체를 열기 위해 필요 (js에서 style은 key-value객체임)

const fruits = ["사과", "바나나", "포도"];
export const E4 = (
  <ul>
    {fruits.map((item, index, array) => {
      //      {JS값 표현식}
      // 리액트의 리스트(목록)은 key를 줘야 함.
      return <li key={index}>{item}</li>;
    })}
  </ul>
);
// E4와 동일한 패턴
export const E5 = (
  <ul>
    {fruits.map((item, index) => (
      <li key={index}>{item}</li>
    ))}
  </ul>
);

// 소괄호 없이 return하는 경우
// : return 뒤에 바로 JSX나 값이 올 경우
// 소괄호로 return하는 경우
// : 함수 컴퍼넌트로 return하는 경우
// 여러 요소를 return하는 경우는 최상위 단일 요소로 만들어야 됨.
function handleClick() {
  alert("버튼이 클릭되었습니다.");
}
export const E6 = (
  // 두개 이상일 때는 <></>로 감싸주기
  <>
    <h1>이벤트 처리</h1>
    <button onClic={handleClick}>클릭하세요</button>
  </>
);

// props로 데이터 전달하기
export function Hello(props) {
  // return문과 같은 줄에 있을 때는 소괄호 필요 없음. (써도 상관X)
  return <h1>안녕하세요. {props.name}님!</h1>;
  //                    props가 객체 형태로 들어옴
  //                    props의 속성별로 접근 가능
}

export function Button(props) {
  return (
    // 백틱을 사용하는 이유 : 문자열타입으로 전달하기 위해
    // <button style={{ color: props.color }}></button>로 해도 됨
    <button style={{ color: `{props.color}` }}>
      {/* JSX 코멘트 : children은 props의 기본속성으로 */}
      {/* 컴퍼넌트 하위 요소를 의미함. */}
      <b>{props.children}</b>
    </button>
  );
}
export function ConfirmDialog(props) {
  return (
    <div>
      <p>확인버튼을 눌러주세요.</p>
      <Button color="green">
        <span>확인</span>
        <br />
        <span>버튼</span>
      </Button>
    </div>
  );
}

// 2. export default 엘리먼트이름;
// default : 내보내기 할 하나의 컴포넌트(요소).. 대표같은 느낌
export default E1;
// 3. export { E1, E2 }; 하나씩 내보내기
