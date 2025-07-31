import React from "react";
import "./App.css";

function App() {
  const element = "Office Space";

  const offices = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "WeWork", Rent: 65000, Address: "Bangalore" },
    { Name: "Regus", Rent: 55000, Address: "Hyderabad" },
    { Name: "Awfis", Rent: 70000, Address: "Pune" },
  ];

  const jsxatt = (
    <img
      src="https://images.unsplash.com/photo-1580519542036-c47de6196ba5?auto=format&fit=crop&w=800&q=60"
      width="25%"
      height="25%"
      alt="Office Space"
    />
  );

  return (
    <div className="App">
      <h1>{element}, at Affordable Range</h1>
      {jsxatt}
      {offices.map((item, index) => {
        const colors = [];
        if (item.Rent <= 60000) {
          colors.push("textRed");
        } else {
          colors.push("textGreen");
        }

        return (
          <div key={index}>
            <h1>Name: {item.Name}</h1>
            <h3 className={colors.join(" ")}>Rent: Rs. {item.Rent}</h3>
            <h3>Address: {item.Address}</h3>
          </div>
        );
      })}
    </div>
  );
}

export default App;
