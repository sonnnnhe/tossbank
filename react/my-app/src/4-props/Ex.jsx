//Ex.jsx
// 1. 문제 1: 단일 Props 전달하기
// 목표: 단일 `props`를 활용하여 간단한 문구를 출력하는 컴포넌트를 작성하세요.
// 요구사항:
// - `Greeting`이라는 자식 컴포넌트를 만드세요.
// - `name`이라는 `props`를 받아 "환영합니다,
//   [이름]님!"이라는 문구를 렌더링합니다.
// - 부모 컴포넌트에서 여러 사람의 이름을 넘겨 출력합니다.
function Greeting(props) {
  return (
    <h3>
      {props.items.map((item) => {
        return <h3>환영합니다, [{item}]님!</h3>;
      })}
    </h3>
  );
}
export function GreetingList() {
  return <Greeting items={["손하은", "진은비", "박해원"]} />;
}

// 2. 문제 2: 여러 Props 전달하기
// 목표: 여러 개의 `props`를 활용하여 사용자의 정보를 출력하는 컴포넌트를 작성하세요.
// 요구사항:
// - `UserCard`라는 자식 컴포넌트를 작성하세요.
// - `name`, `age`, `job`을 `props`로 받아 사용자 정보를 표시합니다.
// - 부모 컴포넌트에서 두 명의 사용자 정보를 전달해 렌더링합니다.
function UserCard(props) {
  return (
    <div>
      {props.items.map((item, index) => {
        return (
          <div>
            <h3>사용자{index + 1}의 정보</h3>
            <ul>
              <li>이름: {item.name}</li>
              <li>나이: {item.age}</li>
              <li>직업: {item.job}</li>
            </ul>
          </div>
        );
      })}
    </div>
  );
}
export function UserList() {
  const users = [
    { name: "손하은", age: 23, job: "학생" },
    { name: "장가은", age: 25, job: "학생" },
  ];

  return <UserCard items={users} />;
  // return <UserCard age={23} />;
}

// 3. 문제 3: 배열 Props 전달하기
// 목표: 배열 데이터를 `props`로 전달하여 리스트 형태로 출력하는 컴포넌트를 작성하세요.
// 요구사항:
// - `ItemList`라는 자식 컴포넌트를 작성하세요.
// - `items`라는 배열을 `props`로 받아 `<li>` 태그로 각 항목을 렌더링합니다.
// - 부모 컴포넌트에서 두 개의 다른 배열을 전달해 두 개의 목록을 출력합니다.
function ItemList(props) {
  return (
    <ul>
      {props.items.map((item) => (
        <li>{item}</li>
      ))}
    </ul>
  );
}
export function PrintList() {
  return (
    <div>
      <ItemList items={["체리", "리치", "앵두"]} />
      <ItemList items={["장미", "튤립", "수선화"]} />
    </div>
  );
}

// 4. 문제 4: 이벤트 Props 전달하기
// 목표: 버튼을 클릭했을 때 이벤트를 처리하는 컴포넌트를 작성하세요.
// 요구사항:
// - `ClickButton`이라는 자식 컴포넌트를 작성하세요.
// - 부모 컴포넌트에서 클릭 시 경고창이 뜨도록 이벤트 핸들러를 전달하세요.
function ClickButton(props) {
  return <button onClick={props.onClickFunc}>클릭하세요.</button>;
}
export function ClickAlert() {
  function handler() {
    alert("버튼이 클릭되었습니다.");
  }

  return <ClickButton onClickFunc={handler} />;
}

// 5. 문제 5: children을 이용한 컴포넌트 구성
// 목표: `children`을 활용하여 컴포넌트 내부에서 콘텐츠를 자유롭게 구성하는 연습을 합니다.
// 요구사항:
// - `InfoCard`라는 자식 컴포넌트를 작성하세요.
// - `title`이라는 `props`와 `children`을 사용하여 제목과 본문 콘텐츠를 렌더링합니다.
// - 부모 컴포넌트에서 두 개의 카드를 렌더링하세요.
function InfoCard(props) {
  return (
    <div>
      <h3>{props.title}</h3>
      {props.children}
    </div>
  );
}

export function CardList() {
  return (
    <div>
      <InfoCard title="오늘 할 일">
        <ul>
          <li>JS 복습</li>
          <li>JSX 복습</li>
        </ul>
        <button>완료 시 클릭하세요.</button>
      </InfoCard>
      <br />
      <InfoCard title="사야할 물건">
        <ul>
          <li>부엌 쓰레기통</li>
          <li>러그</li>
          <li>탁자</li>
          <li>휴대폰 거치대</li>
        </ul>
        <h5>주의: 예산을 고려하세요.</h5>
      </InfoCard>
    </div>
  );
}
