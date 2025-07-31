import React, { useState } from "react";
import EmployeeList from "./components/EmployeeList";
import ThemeContext from "./ThemeContext";

function App() {
  const [theme, setTheme] = useState("light");

  return (
    <ThemeContext.Provider value={theme}>
      <div className="App">
        <h1>Employee Directory</h1>
        <EmployeeList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
