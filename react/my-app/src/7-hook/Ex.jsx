// Ex.jsx
import React, { useState, useMemo, useCallback, useRef } from "react";
//연습문제 1: 숫자 배열의 평균값 구하기 (useMemo 사용)
// 목표:
// 사용자가 입력하는 숫자들을 배열에 추가하고, 배열의 평균값을 **useMemo**로
//   최적화하여 불필요한 재계산을 방지하세요.
// 힌트:
// 배열에 새로운 숫자가 추가될 때만 평균값을 재계산해야 합니다.
// 평균값을 구하려면 배열의 합을 배열의 길이로 나누면 됩니다.
export function Memo() {
  const [nums, setNums] = useState([]);
  const [inputValue, setInputValue] = useState("");

  let sum = 0;
  const avr = useMemo(() => {
    nums.map((num) => {
      sum += num;
    });
    console.log("평균값 계산 중...");

    return sum / nums.length;
  }, [nums]);

  return (
    <div>
      <h1>평균값: {avr}</h1>
      <input
        type="text"
        value={inputValue}
        onChange={(e) => {
          setInputValue(e.target.value);
        }}
      />
      <button
        onClick={() => {
          setNums([...nums, Number(inputValue)]);
        }}
      >
        리스트에 추가하기
      </button>
    </div>
  );
}

// 연습문제 2: 버튼 클릭 시 숫자 증가하기 (useCallback)
// 목표:
// 1. 숫자를 상태로 관리하고, 버튼을 클릭할 때마다 숫자가 1씩 증가합니다.
// 2. useCallback을 사용하여 버튼 클릭 핸들러가 컴포넌트가 리렌더링될 때마다 새로 생성되지 않도록 최적화하세요.
export function Callback() {
  const [number, setNumber] = useState(0);
  const [cnt, setCnt] = useState(0);

  const handleButtonClick = useCallback(() => {
    setCnt(cnt + 1);
    setNumber(number + 1);
    console.log("버튼 클릭됨.");
  }, [cnt]);

  return (
    <div>
      <h1>숫자: {number}</h1>
      <button onClick={handleButtonClick}>증가시키기</button>
    </div>
  );
}

// 연습문제 3: 입력창 초기화하기 (useRef)
// 목표:
// 사용자가 입력한 텍스트를 버튼 클릭 시 초기화하고, 입력창에 포커스를 다시 설정합니다.
// **useRef**를 사용하여 입력창을 제어하세요.
// 힌트:
// 입력창에 접근하기 위해 **useRef**로 참조를 생성하세요.
// **inputRef.current.value**를 이용해 입력 값을 초기화하고, **inputRef.current.focus()**로 포커스를 설정합니다.
export function Ref() {
  const [text, setText] = useState("");
  const inputRef = useRef(null);

  const getText = useCallback(
    (e) => {
      setText(e.target.value);
    },
    [text]
  );

  const handleButton = () => {
    if (inputRef.current) {
      setText("");
      inputRef.current.focus();
      console.log("초기화 중...");
    }
  };
  return (
    <div>
      <input
        type="text"
        value={text}
        ref={inputRef}
        placeholder="여기에 입력하세요."
        onChange={getText}
      />
      <br />
      <button onClick={handleButton}>입력창 포커스 및 초기화</button>
    </div>
  );
}
