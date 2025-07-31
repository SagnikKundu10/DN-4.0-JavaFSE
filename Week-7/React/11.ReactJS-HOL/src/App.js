import React, { useState } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

function App() {
  const [count, setCount] = useState(5);

  const increment = () => {
    setCount(count + 1);
    alert("Hello! This is a static message.");
  };

  const decrement = () => {
    setCount(count - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handleClick = () => {
    alert("I was clicked");
  };

  return (
    <div style={{ margin: "20px" }}>
      <p>{count}</p>

      <button onClick={increment}>Increment</button>
      <br />
      <br />
      <button onClick={decrement}>Decrement</button>
      <br />
      <br />
      <button onClick={() => sayWelcome("welcome")}>Say welcome</button>
      <br />
      <br />
      <button onClick={handleClick}>Click on me</button>
      <br />
      <br />

      <CurrencyConvertor />
    </div>
  );
}

export default App;
