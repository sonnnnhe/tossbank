import React from "react";
import * as E from "./2-jsx/Ex";

function App() {
  // return <Library />;
  // 이런식으로 작성할 것임
  // return (
  //   <MainApp>
  //     <Header />
  //     <Nav />
  //     <Main>
  //       <Section />
  //       <Aside />
  //     </Main>
  //   </MainApp>
  // );

  // return <E.Hello name="홍길동" />;
  // return <E.Sum num1="30" num2="20" />;
  // return <E.DrinkMachine price="5000" />;
  return <E.Greeting hour="14" />;
}

export default App;
