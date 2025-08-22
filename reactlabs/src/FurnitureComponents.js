// src/FurnitureComponents.js
import React, { useState } from "react"; // Import React and useState hook

// Chair component definition
function Chair() {
  return (
    <div className="card p-3 mt-3"> {/* Card container with padding and margin */}
      <h2>🪑 Chair</h2> {/* Heading with emoji */}
      <p><b>Name:</b> Office Chair</p> {/* Furniture name */}
      <p><b>Price:</b> ₹2500</p> {/* Furniture price */}
      <p><b>Material:</b> Plastic</p> {/* Material info */}
      <p><b>Brand:</b> Nilkamal</p> {/* Brand info */}
    </div>
  );
}

// Table component definition
function Table() {
  return (
    <div className="card p-3 mt-3"> {/* Card container with padding and margin */}
      <h2>🪑 Table</h2> {/* Heading with emoji */}
      <p><b>Name:</b> Dining Table</p> {/* Furniture name */}
      <p><b>Price:</b> ₹6000</p> {/* Furniture price */}
      <p><b>Material:</b> Wood</p> {/* Material info */}
      <p><b>Brand:</b> Godrej Interio</p> {/* Brand info */}
    </div>
  );
}

// Sofa component definition
function Sofa() {
  return (
    <div className="card p-3 mt-3"> {/* Card container with padding and margin */}
      <h2>🛋️ Sofa</h2> {/* Heading with emoji */}
      <p><b>Name:</b> Recliner Sofa</p> {/* Furniture name */}
      <p><b>Price:</b> ₹12000</p> {/* Furniture price */}
      <p><b>Material:</b> Leather</p> {/* Material info */}
      <p><b>Brand:</b> Pepperfry</p> {/* Brand info */}
    </div>
  );
}

// Bed component definition
function Bed() {
  return (
    <div className="card p-3 mt-3"> {/* Card container with padding and margin */}
      <h2>🛏️ Bed</h2> {/* Heading with emoji */}
      <p><b>Name:</b> King Size Bed</p> {/* Furniture name */}
      <p><b>Price:</b> ₹15000</p> {/* Furniture price */}
      <p><b>Material:</b> Teak Wood</p> {/* Material info */}
      <p><b>Brand:</b> Urban Ladder</p> {/* Brand info */}
    </div>
  );
}

// Main FurnitureStore component
export default function FurnitureStore() {
  const [selectedFurniture, setSelectedFurniture] = useState("Chair"); // State to track selected furniture item

  // Function to render selected furniture component
  const renderFurniture = () => {
    switch (selectedFurniture) { // Check selected option
      case "Chair":
        return <Chair />; // Show Chair component
      case "Table":
        return <Table />; // Show Table component
      case "Sofa":
        return <Sofa />; // Show Sofa component
      case "Bed":
        return <Bed />; // Show Bed component
      default:
        return <p>Please select a furniture item.</p>; // Default message
    }
  };

  return (
    <div className="mt-4 text-center"> {/* Main container with margin and centered text */}
      <h1>🛋️ Furniture Store</h1> {/* Page heading */}

      {/* Dropdown to select furniture */}
      <select
        className="form-select w-25 mx-auto" // Bootstrap styles for dropdown
        value={selectedFurniture} // Bind selected value to state
        onChange={(e) => setSelectedFurniture(e.target.value)} // Update state on change
      >
        <option value="Chair">Chair</option> {/* Dropdown option for Chair */}
        <option value="Table">Table</option> {/* Dropdown option for Table */}
        <option value="Sofa">Sofa</option> {/* Dropdown option for Sofa */}
        <option value="Bed">Bed</option> {/* Dropdown option for Bed */}
      </select>

      <div>{renderFurniture()}</div> {/* Display selected furniture */}
    </div>
  );
}
