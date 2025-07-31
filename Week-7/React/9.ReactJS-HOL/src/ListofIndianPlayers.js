import React from "react";

export default function ListofIndianPlayers({ IndianPlayers }) {
  return (
    <>
      {IndianPlayers.map((player, index) => (
        <div key={index}>
          <li>Mr. {player}</li>
        </div>
      ))}
    </>
  );
}
