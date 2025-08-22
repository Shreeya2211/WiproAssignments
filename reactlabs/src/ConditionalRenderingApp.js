// Import React and its hooks useState, useEffect
import React, { useState, useEffect } from "react";

//Component 1: Loading Component
function LoadingComponent() {
  // Returns loading message
  return <h2>Loading product details...</h2>;
}

//Component 2: Error Component
function ErrorComponent() {
  // Returns error message
  return <h2>⚠️ Error fetching product details</h2>;
}

//Component 3: Product Component
function ProductComponent({ product }) {
  // Receives product as props and displays its details
  return (
    // Container with inline styling
    <div style={{ border: "1px solid gray", padding: "10px", margin: "10px" }}>
      <h2>Electronic Product Details</h2>
      {/* Display product name */}
      <p><b>Name:</b> {product.name}</p>
      {/* Display brand */}
      <p><b>Brand:</b> {product.brand}</p>
      {/* Display price */}
      <p><b>Price:</b> ₹{product.price}</p>
      {/* Display category */}
      <p><b>Category:</b> {product.category}</p>
      {/* Conditional: Premium if price > 50000 else Budget */}
      <p>
        <b>Type:</b> {product.price > 50000 ? "Premium Product" : "Budget Product"}
      </p>
      {/* Conditional: Warranty years or No Warranty */}
      <p>
        <b>Warranty:</b> {product.warranty > 0 ? `${product.warranty} years` : "No Warranty"}
      </p>
      {/* Conditional: In stock or Out of stock */}
      <p>{product.availability ? "✅ In Stock" : "❌ Out of Stock"}</p>
      {/* Conditional: Special offer only if category is Laptop */}
      <p>{product.category === "Laptop" ? "🎒 Free Laptop Bag Offer" : ""}</p>
    </div>
  );
}

// Main Component
export default function ConditionalRenderingApp() {
  // State: true when loading
  const [loading, setLoading] = useState(true);
  // State: true when error occurs
  const [error, setError] = useState(false);
  // State: stores product object once loaded
  const [product, setProduct] = useState(null);

  // useEffect hook runs once after initial render
  useEffect(() => {
    // Simulate API delay with setTimeout
    setTimeout(() => {
      // Generate random error with 30% chance
      const isError = Math.random() > 0.7;
      if (isError) {
        // Set error state true and stop loading
        setError(true);
        setLoading(false);
      } else {
        // Otherwise set product details
        setProduct({
          name: "Dell Inspiron",
          brand: "Dell",
          price: 45000,
          category: "Laptop",
          warranty: 1,
          availability: true,
        });
        // Stop loading
        setLoading(false);
      }
    }, 2000); // Runs after 2 seconds
  }, []); // Empty dependency means run only once

  // ✅ Conditional rendering using nested ternary
  return (
    <div>
      {loading ? ( // Show loading if loading true
        <LoadingComponent />
      ) : error ? ( // Else if error true show error
        <ErrorComponent />
      ) : ( // Else show product
        <ProductComponent product={product} />
      )}
    </div>
  );
}
