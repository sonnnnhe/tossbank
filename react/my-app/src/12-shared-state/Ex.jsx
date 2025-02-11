import React, { useState } from "react";
/**
 * 연습문제 1: 두 개의 숫자 입력 필드의 합 계산하기 (State 끌어올리기)
    문제 설명:
    두 개의 숫자 입력 필드를 만들고 입력한 숫자들의 합을 부모 컴포넌트에서 
    실시간으로 계산하여 출력합니다.
 */

// function InputField1({ value, onChange }) {
//   return (
//     <div>
//       <label>자식1: 입력 필드 1: </label>
//       <input
//         type="text"
//         value={value}
//         onChange={(e) => onChange(e.target.value)}
//       />
//     </div>
//   );
// }
function InputField1({ value, onChange }) {
  return (
    <div>
      <label>숫자 입력 필드 1: </label>
      <input
        type="text"
        text={value}
        onChange={(e) => onChange(Number(e.target.value))}
      />
    </div>
  );
}
function InputField2({ value, onChange }) {
  return (
    <div>
      <label>숫자 입력 필드 2: </label>
      <input
        type="text"
        text={value}
        onChange={(e) => onChange(Number(e.target.value))}
      />
    </div>
  );
}

export function InputSum() {
  const [num1, setNum1] = useState(0);
  const [num2, setNum2] = useState(0);

  return (
    <div>
      <h1>숫자들의 합</h1>
      <InputField1 value={num1} onChange={setNum1} />
      <InputField2 value={num2} onChange={setNum2} />
      <h3>입력된 값 1: {num1}</h3>
      <h3>입력된 값 2: {num2}</h3>
      <h3>합: {num1 + num2}</h3>
    </div>
  );
}

/**
 * 연습문제2: 선택한 리스트 항목 표시하기 (State 끌어올리기)
 * 문제 설명:
    리스트에 여러 항목(예: 과일 목록)이 주어져 있고, 사용자가 항목을 선택하면 
    선택한 항목들이 부모 컴포넌트에서 관리되어 화면에 표시됩니다.

    const items = ["사과", "바나나", "오렌지", "수박", "포도"];

    요구사항
    항목을 클릭하면 선택된 항목들이 부모 컴포넌트에 저장되어 표시됩니다.
    이미 선택된 항목을 클릭하면 해당 항목이 선택 목록에서 제거됩니다.
    상태는 부모 컴포넌트에서 관리합니다.
 */
function List({ items, onClick, selectedItem }) {
  return (
    <div>
      <h1>리스트 선택 및 연동</h1>
      <ul>
        {items.map((item) => (
          <li
            key={item}
            onClick={(e) => onClick([...selectedItem, item])}
            style={{
              backgroundColor: selectedItem.includes(item)
                ? "lightgray"
                : "white",
            }}
          >
            {item}
          </li>
        ))}
      </ul>
    </div>
  );
}
export function SelectedList() {
  const [items, setItems] = useState([
    "사과",
    "바나나",
    "오렌지",
    "수박",
    "포도",
  ]);
  const [selectedItem, setSelectedItem] = useState([]);
  return (
    <div>
      <List
        items={items}
        onClick={setSelectedItem}
        selectedItem={selectedItem}
      />
      <h3>선택된 항목:</h3>
      <ul>
        {selectedItem.map((item) => (
          <li key={item}>{item}</li>
        ))}
      </ul>
    </div>
  );
}
