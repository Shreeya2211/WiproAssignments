import React, { useState } from "react";

const Electronics = () => {
  // useState hooks for item details
  const [name] = useState("Laptop");  // Fixed item name
  const [brand, setBrand] = useState("Dell"); // Brand can be changed
  const [price, setPrice] = useState(5500);   // Price can increase

  // Function to change the brand
  const changeBrand = () => {
    setBrand("HP");
  };

  // Function to increase the price
  const increasePrice = () => {
    setPrice(price + 500);
  };

  return (
    <div
      style={{
        border: "2px solid black",
        borderRadius: "10px",
        width: "400px",
        margin: "20px auto",
        padding: "20px",
        textAlign: "center",
        backgroundColor: "#f9f9f9",
      }}
    >
      <h2>⚡ Electronic Item Details</h2>
      <p><b>Name:</b> {name}</p>
      <p><b>Brand:</b> {brand}</p>
      <p><b>Price:</b> ₹{price}</p>

      <div style={{ marginTop: "15px" }}>
        <button
          onClick={changeBrand}
          style={{
            marginRight: "10px",
            padding: "8px 12px",
            borderRadius: "5px",
            border: "1px solid gray",
            cursor: "pointer",
          }}
        >
          Change Brand
        </button>

        <button
          onClick={increasePrice}
          style={{
            padding: "8px 12px",
            borderRadius: "5px",
            backgroundColor: "blue",
            color: "white",
            border: "none",
            cursor: "pointer",
          }}
        >
          Increase Price
        </button>
      </div>
    </div>
  );
};

export default Electronics;
