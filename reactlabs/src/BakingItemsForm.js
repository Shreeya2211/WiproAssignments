// Import React library and useState hook
import React, { useState } from "react";

// Define BakingItemsForm functional component
function BakingItemsForm() {
  // useState hook for storing form input values
  const [formData, setFormData] = useState({
    name: "",          // Input field: Item Name
    quantity: "",      // Input field: Quantity
    ingredients: "",   // Input field: Ingredients
    time: "",          // Input field: Baking Time
    category: "Cake",  // Dropdown default value set to 'Cake'
  });

  // useState hook for storing list of submitted baking items
  const [items, setItems] = useState([]);

  // Function to handle changes in input fields
  const handleChange = (e) => {
    const { name, value } = e.target; // Extract field name & value from event
    setFormData({
      ...formData,     // Keep previous form values intact
      [name]: value,   // Update the changed field dynamically
    });
  };

  // Function to handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();                  // Prevent default page reload
    setItems([...items, formData]);      // Add current form data to items list
    setFormData({                        // Reset form fields after submission
      name: "",
      quantity: "",
      ingredients: "",
      time: "",
      category: "Cake",
    });
  };

  // JSX returned by the component
  return (
    <div className="container mt-4"> {/* Bootstrap container with margin top */}
      <div className="card p-4"> {/* Bootstrap card with padding */}
        <h2>🥮 Baking Items Form</h2> {/* Form heading */}

        {/* Form starts here */}
        <form onSubmit={handleSubmit}> {/* Attach submit handler */}
          {/* Input field for Item Name */}
          <div className="mb-3">
            <label>Item Name</label>
            <input
              type="text" // Text input
              name="name" // Linked to 'name' in state
              className="form-control" // Bootstrap styling
              value={formData.name} // Controlled input value
              onChange={handleChange} // Update on change
              required // Field must be filled
            />
          </div>

          {/* Input field for Quantity */}
          <div className="mb-3">
            <label>Quantity</label>
            <input
              type="number" // Numeric input
              name="quantity" // Linked to 'quantity' in state
              className="form-control" // Bootstrap styling
              value={formData.quantity} // Controlled input value
              onChange={handleChange} // Update on change
              required // Field must be filled
            />
          </div>

          {/* Input field for Ingredients */}
          <div className="mb-3">
            <label>Ingredients</label>
            <input
              type="text" // Text input
              name="ingredients" // Linked to 'ingredients' in state
              className="form-control" // Bootstrap styling
              value={formData.ingredients} // Controlled input value
              onChange={handleChange} // Update on change
              required // Field must be filled
            />
          </div>

          {/* Input field for Baking Time */}
          <div className="mb-3">
            <label>Baking Time (minutes)</label>
            <input
              type="text" // Text input
              name="time" // Linked to 'time' in state
              className="form-control" // Bootstrap styling
              value={formData.time} // Controlled input value
              onChange={handleChange} // Update on change
              required // Field must be filled
            />
          </div>

          {/* Dropdown for Category */}
          <div className="mb-3">
            <label>Category</label>
            <select
              name="category" // Linked to 'category' in state
              className="form-control" // Bootstrap styling
              value={formData.category} // Controlled dropdown value
              onChange={handleChange} // Update on change
            >
              <option value="Cake">Cake</option> {/* Option 1 */}
              <option value="Bread">Bread</option> {/* Option 2 */}
              <option value="Pastry">Pastry</option> {/* Option 3 */}
            </select>
          </div>

          {/* Submit button */}
          <button type="submit" className="btn btn-success">
            Add Baking Item
          </button>
        </form>
        {/* Form ends here */}
      </div>

      {/* Section to display submitted items */}
      <h3 className="mt-4">Baking Items List</h3>
      <table className="table table-bordered mt-2"> {/* Bootstrap table */}
        <thead className="table-dark"> {/* Dark header row */}
          <tr>
            <th>#</th> {/* Serial number */}
            <th>Item Name</th> {/* Column for name */}
            <th>Quantity</th> {/* Column for quantity */}
            <th>Ingredients</th> {/* Column for ingredients */}
            <th>Baking Time</th> {/* Column for time */}
            <th>Category</th> {/* Column for category */}
          </tr>
        </thead>
        <tbody>
          {/* Loop through items array to display rows */}
          {items.map((item, index) => (
            <tr key={index}> {/* Unique key for each row */}
              <td>{index + 1}</td> {/* Display row number */}
              <td>{item.name}</td> {/* Display item name */}
              <td>{item.quantity}</td> {/* Display quantity */}
              <td>{item.ingredients}</td> {/* Display ingredients */}
              <td>{item.time} mins</td> {/* Display baking time */}
              <td>{item.category}</td> {/* Display category */}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

// Export component to be used in other files
export default BakingItemsForm;
