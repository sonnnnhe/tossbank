// default는 그냥 이름으로, 나머지 부가적인 것은 {} 안에 이름 작성해서 import
// import E1, { E2, E3, E4, E5, E6 } from "./1-element/Element"; 내보내기 이후에 import 해야함
import * as element from "./1-element/Ex"; // * as 이름 : 모든 요소 import.  =>  이름.요소이름으로 각 요소에 접근

function App() {
  // return E1; 출력: 리액트 엘리먼트1입니다.
  // return E2; // 출력: 리액트 엘리먼트2입니다.
  // return E3; // 출력: 엘리먼트3   글자색은 파란색임
  // return E4;
  // 이 방식은 JSX로 렌더링하지 않고
  // React 컴퍼넌트 자체 또는 JSX 요소로 작성된 변수를 반환하는 경우.
  // return element.E6;
  // 이 방식은 React의 함수형(클래스형) 컴퍼넌트를
  // JSX 문법으로 호출하여 반환하는 경우
  // return element.Hello(); // return element.Hello; 시 렌더링 불가능
  //                        return <element.Hello />; 은 가능

  // return <element.Hello name="홍길동" />; // props.name으로 홍길동을 준 것
  // return <element.ConfirmDialog />;
  // return element.Namecard;
  // return <element.Greeting name="홍길동" age="25" />;
  return element.Product(element.products);
}

export default App;
