import { useState, useCallback } from "react";
import ThemeContext from "./ThemeContext";
import ThemeContextUseContext from "./ThemeContextUseContext";

function ThemeContextConsumer({ initTheme }) {
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
}

export default ThemeContextConsumer;
