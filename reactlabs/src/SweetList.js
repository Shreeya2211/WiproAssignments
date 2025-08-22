import React from "react";

// Declares a functional component named SweetList
const SweetList = () => {
  
// Defines an array of sweet objects with id, name, and price
  const sweets = [
    { id: 1, name: "Laddu", price: 50 },
    { id: 2, name: "Jalebi", price: 40 },
    { id: 3, name: "Rasgulla", price: 60 },
    { id: 4, name: "Gulab Jamun", price: 70 },
  ];

  return (
    <div
      style={{
        border: "2px solid brown",
        borderRadius: "10px",
        padding: "20px",
        width: "350px",
        margin: "20px auto",
        backgroundColor: "#fff8dc",
        textAlign: "left",
      }}
    >
      <h2 style={{ textAlign: "center", color: "brown" }}>🍬 Sweets List</h2>

      <ul>
        {sweets.map((sweet) => (
            // Loops through sweets array using map to generate <li> elements.
          <li key={sweet.id} style={{ margin: "8px 0", fontSize: "18px" }}>
            {sweet.name} - Price: ₹{sweet.price}
          </li>
          // Displays each sweet with its name and price inside <li>, using id as unique key
        ))}
      </ul>
    </div>
  );
};

export default SweetList;
