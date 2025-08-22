

import React, { useState } from "react";
//declared an arrow functional component Phone, created state var phone, its setter is setPhone
const Phone = () => {
  // useState hook to manage phone details
  const [phone, setPhone] = useState({
    brand: "Apple",
    model: "iPhone 15",
    price: 79999,
  });

  // Function to increase the price
  const increasePrice = () => {
    setPhone((prevPhone) => ({
      ...prevPhone,
      price: prevPhone.price + 1000, // Increase by 1000 each click
    }));
  };

  return (
    <div
      style={{
        border: "2px solid black",
        padding: "20px",
        width: "300px",
        margin: "20px auto",
        textAlign: "center",
      }}
    >
      <h2>📱 Phone Details</h2>
      <p><strong>Brand:</strong> {phone.brand}</p>
      <p><strong>Model:</strong> {phone.model}</p>
      <p><strong>Price:</strong> ₹{phone.price}</p>

      <button
        onClick={increasePrice}
        style={{
          backgroundColor: "dodgerblue",
          color: "white",
          padding: "10px 20px",
          border: "none",
          borderRadius: "8px",
          cursor: "pointer",
          fontSize: "16px",
        }}
      >
        Increase Price
      </button>
    </div>
  );
};

export default Phone;
