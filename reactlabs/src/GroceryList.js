import React from "react";

function GroceryList({ items }) {
  return (
    <div className="p-4">
      <h2>Grocery List</h2>
      <ul className="assignment-list">
        {items.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
      <button onClick={() => alert("Groceries Added to Cart!")}>
        Add to Cart
      </button>
    </div>
  );
}

export default GroceryList;
