import React, { useState } from "react";

function LoginButton(props) {
  return <button onClick={props.onClick}>Login</button>;
}

function LogoutButton(props) {
  return <button onClick={props.onClick}>Logout</button>;
}

function GuestPage() {
  return (
    <div>
      <h1>Please sign up.</h1>
      <FlightDetails />
    </div>
  );
}

function UserPage() {
  return (
    <div>
      <h1>Welcome back</h1>
      <FlightDetails />
      <BookTicket />
    </div>
  );
}

function FlightDetails() {
  return (
    <div>
      <h2>Flight Details</h2>
      <ul>
        <li>Flight 1: New York → London - 10:00 AM</li>
        <li>Flight 2: Paris → Tokyo - 2:30 PM</li>
      </ul>
    </div>
  );
}

function BookTicket() {
  return (
    <div>
      <h2>Book Your Ticket</h2>
      <button>Book Now</button>
    </div>
  );
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginClick = () => setIsLoggedIn(true);
  const handleLogoutClick = () => setIsLoggedIn(false);

  let button = isLoggedIn ? (
    <LogoutButton onClick={handleLogoutClick} />
  ) : (
    <LoginButton onClick={handleLoginClick} />
  );

  let content = isLoggedIn ? <UserPage /> : <GuestPage />;

  return (
    <div style={{ padding: "20px" }}>
      {button}
      {content}
    </div>
  );
}

export default App;
