import { useState, useCallback } from "react";
import ThemeContext from "./ThemeContext";
import ThemeContextUseContext from "./ThemeContextUseContext";
import ThemeContextConsumer from "./ThemeContextConsumer";

function ThemeContextProvider({ initTheme }) {
  const [theme, setTheme] = useState(initTheme);

  // useMemo: 값이 저장
  // useCallback: 함수를 저장해놓음
  const toggleTheme = useCallback(() => {
    if (theme === "light") {
      setTheme("dark");
    } else {
      setTheme("light");
    }
  }, [theme]);

  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      {/* context를 사용하고자 하는 애들을 provider 아래에..? */}
      <ThemeContextUseContext />
      <ThemeContextConsumer />
    </ThemeContext.Provider>
  );
}

export default ThemeContextProvider;
