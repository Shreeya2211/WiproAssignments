import React from "react";
import CanteenItem from "./CanteenItem";

// Parent Component, display the canteen details and pass data (props) to its child (CanteenItem).
const CanteenMenu = () => {
  return (
    <div
      style={{
        border: "2px solid brown",
        borderRadius: "10px",
        padding: "20px",
        width: "500px",
        margin: "20px auto",
        backgroundColor: "#fff8dc",
      }}
    >
      <h2 style={{ textAlign: "center", color: "brown" }}>Canteen Menu</h2>

      {/* Parent info */}
      <p>
        <b>Canteen Name:</b> Campus Food Court
      </p>
      <p>
        <b>Location:</b> Block A, Ground Floor
      </p>
      <p>
        <b>Open Hours:</b> 8:00 AM - 8:00 PM
      </p>

      <h3>Items:</h3>
      <ul>
        {/* Child components */}
        <CanteenItem name="Idli" price={30} category="Breakfast" available="Yes" />
        <CanteenItem name="Dosa" price={50} category="Breakfast" available="Yes" />
        <CanteenItem name="Vada" price={20} category="Snack" available="No" />
        <CanteenItem name="Poori" price={40} category="Breakfast" available="Yes" />
        <CanteenItem name="Meals" price={120} category="Lunch" available="Yes" />
      </ul>
    </div>
  );
};

export default CanteenMenu;
