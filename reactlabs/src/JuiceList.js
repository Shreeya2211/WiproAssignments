import React from "react"; // Import React library to use JSX and components

// Child component to display one juice row
function Juice({ id, name, price }) { // Destructure props: id, name, price
  return (
    <tr> {/* Table row for one juice */}
      <td>{id}</td> {/* Display juice ID */}
      <td>{name}</td> {/* Display juice name */}
      <td>₹ {price}</td> {/* Display juice price with ₹ symbol */}
    </tr>
  );
}

// Parent component to render juice list
function JuiceList() {
  // Array of juice objects
  const juices = [
    { id: 1, name: "Orange Juice", price: 80 }, // Juice 1 details
    { id: 2, name: "Apple Juice", price: 100 }, // Juice 2 details
    { id: 3, name: "Mango Juice", price: 120 }, // Juice 3 details
  ];

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}> {/* Centered container with margin */}
      <h2>🥤 Juice Menu</h2> {/* Heading for menu */}
      
      {/* Table with border and padding, centered */}
      <table border="1" cellPadding="10" style={{ margin: "auto" }}>
        <thead> {/* Table header */}
          <tr>
            <th>ID</th> {/* Column heading for ID */}
            <th>Juice Name</th> {/* Column heading for Name */}
            <th>Price</th> {/* Column heading for Price */}
          </tr>
        </thead>
        <tbody> {/* Table body with juice rows */}
          {juices.map((juice) => ( // Loop over juices array
            <Juice
              key={juice.id} // Unique key for React
              id={juice.id} // Pass juice ID as prop
              name={juice.name} // Pass juice name as prop
              price={juice.price} // Pass juice price as prop
            />
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default JuiceList; // Export parent component to be used in App.js
