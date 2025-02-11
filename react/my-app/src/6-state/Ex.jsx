import React, { useState } from "react";

//Ex.jsx

// 연습문제 1: 입력된 텍스트를 화면에 바로 보여주기
// 설명: 입력 필드에 사용자가 입력한 텍스트를 바로 화면에 표시하세요.
// 힌트: onChange 이벤트
export function State1() {
  const [text, setText] = useState("");

  const PrintText = (e) => {
    // e : 이벤트 객체 - 이벤트에 대한 정보를 가지고 있다.
    // e.target : 이벤트가 발생한 객체(input 객체)
    setText(e.target.value);
  };

  return (
    <div>
      <input type="text" name="text" value={text} onChange={PrintText} />
      <p>입력된 텍스트: {text}</p>
    </div>
  );
}

// 연습문제 2: 버튼을 클릭할 때마다 색상 변경하기
// 설명: 버튼을 클릭할 때마다 배경 색상이 빨강, 초록, 파랑으로
//    순차적으로 변경되도록 만드세요.
export function State2() {
  const [count, setCount] = useState(0);

  const ChangeCount = () => {
    setCount((prev) => prev + 1);
  };

  const ChangeBgColor = () => {
    if (count % 3 === 1) {
      return "red";
    } else if (count % 3 === 2) {
      return "green";
    } else {
      return "blue";
    }
  };

  return (
    <button onClick={ChangeCount} style={{ backgroundColor: ChangeBgColor() }}>
      배경색 바꾸기
    </button>
  );
}

// 연습문제 3: 체크박스 상태 관리하기
// 설명: 체크박스를 클릭하면 "ON" 또는 "OFF"라는 텍스트가
//   화면에 표시되도록 만드세요.
// 힌트: onChange, checked 속성을 이용
export function State3() {
  const isChecked = (e) => {
    if (e.target.checked) {
      console.log("ON");
    } else {
      console.log("OFF");
    }
  };
  return (
    <div>
      <input type="checkbox" id="cb" onChange={isChecked} />
      <label htmlFor="cb">체크박스</label>
    </div>
  );
}

// 연습문제 4: 숫자 제한 걸기
// 설명: 숫자를 증가시키되, 숫자가 10 이상이면
//   더 이상 증가하지 않도록 제한하세요.
export function State4() {
  const [count, setCount] = useState(0);

  const increaseNum = () => {
    if (count >= 10) {
      return;
    } else {
      setCount((prev) => prev + 1);
    }
  };

  return (
    <div>
      <button onClick={increaseNum}>숫자 증가시키기</button>
      <p>숫자: {count}</p>
    </div>
  );
}

// 연습문제 5: 버튼을 클릭할 때마다 리스트에 항목 추가하기
// 설명: 버튼을 클릭하면 입력 필드의 값을 리스트에 추가하고,
//   추가된 항목들을 화면에 표시하세요.
// 힌트: [], ["aaa", "bbb", "ccc"]
export function State5() {
  const [text, setText] = useState("");
  const [lists, setList] = useState([]);

  const getText = (e) => {
    setText(e.target.value);
  };

  const pushList = () => {
    if (text.trim() !== "") {
      setList([...lists, text]);
      setText("");
    }
  };
  return (
    <div>
      <input
        type="text"
        placeholder="값을 입력하세요"
        value={text}
        onChange={getText}
      />
      <button onClick={pushList}>리스트에 추가하기</button>
      <ul>
        {lists.map((list, index) => {
          return <li key={index}>{list}</li>;
        })}
      </ul>
    </div>
  );
}
