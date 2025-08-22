import React from "react";

// destructuring of props: Instead of writing props.name, props.price, etc., 
// we directly extract name, price, category, and available from the props object.
const CanteenItem = ({ name, price, category, available }) => {
  return (
    <li style={{ margin: "8px 0", fontSize: "16px" }}>
      <b>{name}</b> – Price: ₹{price} – Category: {category} –{" "}
   
      <span style={{ color: available === "Yes" ? "green" : "red" }}>
        {available === "Yes" ? "Available" : "Not Available"}
      </span>
    </li>
  );
};

export default CanteenItem;
