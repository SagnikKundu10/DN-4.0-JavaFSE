import React, { useState } from "react";

function CurrencyConvertor() {
  const [amount, setAmount] = useState("");
  const [currency, setCurrency] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const rate = 80;
    const convertedAmount = amount * rate;
    alert(`Converting to ${currency} Amount is ${convertedAmount}`);
  };

  return (
    <div>
      <h1 style={{ color: "green" }}>Currency Convertor!!!</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Amount:
          <input
            type="text"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
          />
        </label>
        <br />
        <br />
        <label>
          Currency:
          <textarea
            value={currency}
            onChange={(e) => setCurrency(e.target.value)}
          />
        </label>
        <br />
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default CurrencyConvertor;
