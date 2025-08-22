import React, { Component } from "react"; // Import React and Component
import "bootstrap/dist/css/bootstrap.min.css"; // Import Bootstrap for styling

class AccessoriesForm extends Component { // Create a class component
  constructor(props) { 
    super(props); // Call parent constructor
    this.state = { // Initialize state variables
      accessoryName: "", // For text input
      description: "", // For textarea
      category: "", // For select dropdown
      brand: "", // For radio buttons
      inStock: false, // For checkbox
      warranty: "", // For number input
      submitted: false, // To check if form is submitted
    };
  }

  // Function to handle input changes
  handleChange = (e) => {
    const { name, value, type, checked } = e.target; // Extract input details
    this.setState({
      [name]: type === "checkbox" ? checked : value, // Update state for checkbox or other fields
    });
  };

  // Function to handle form submission
  handleSubmit = (e) => {
    e.preventDefault(); // Prevent page reload on submit
    this.setState({ submitted: true }); // Mark form as submitted
  };

  render() {
    return (
      <div className="container mt-4"> {/* Bootstrap container with margin */}
        <div className="card p-4 shadow-sm"> {/* Card with padding and shadow */}
          <h3 className="text-center mb-3">Accessories Form</h3> {/* Form title */}
          <form onSubmit={this.handleSubmit}> {/* Start form */}

            {/* Text input field */}
            <div className="form-group mb-3">
              <label>Accessory Name</label> {/* Label for text input */}
              <input
                type="text" // Text input type
                name="accessoryName" // Maps to state variable
                className="form-control" // Bootstrap styling
                value={this.state.accessoryName} // Bind value from state
                onChange={this.handleChange} // Update state on change
                required // Validation (must be filled)
              />
            </div>

            {/* Textarea field */}
            <div className="form-group mb-3">
              <label>Description</label> {/* Label for textarea */}
              <textarea
                name="description" // Maps to state variable
                className="form-control" // Bootstrap styling
                value={this.state.description} // Bind value from state
                onChange={this.handleChange} // Update state on change
                required // Validation (must be filled)
              />
            </div>

            {/* Select dropdown */}
            <div className="form-group mb-3">
              <label>Category</label> {/* Label for select */}
              <select
                name="category" // Maps to state variable
                className="form-control" // Bootstrap styling
                value={this.state.category} // Bind value from state
                onChange={this.handleChange} // Update state on change
                required // Validation
              >
                <option value="">Select Category</option> {/* Default option */}
                <option value="Mobile">Mobile</option> {/* Option 1 */}
                <option value="Laptop">Laptop</option> {/* Option 2 */}
                <option value="Tablet">Tablet</option> {/* Option 3 */}
              </select>
            </div>

            {/* Radio buttons */}
            <div className="form-group mb-3">
              <label>Brand</label> {/* Label for radios */}
              <div>
                <input
                  type="radio" // Radio input
                  name="brand" // Maps to same state variable
                  value="Samsung" // Radio value
                  checked={this.state.brand === "Samsung"} // Check if selected
                  onChange={this.handleChange} // Update state
                />{" "}
                Samsung
              </div>
              <div>
                <input
                  type="radio"
                  name="brand"
                  value="Apple"
                  checked={this.state.brand === "Apple"}
                  onChange={this.handleChange}
                />{" "}
                Apple
              </div>
              <div>
                <input
                  type="radio"
                  name="brand"
                  value="Dell"
                  checked={this.state.brand === "Dell"}
                  onChange={this.handleChange}
                />{" "}
                Dell
              </div>
            </div>

            {/* Checkbox */}
            <div className="form-group mb-3">
              <label>
                <input
                  type="checkbox" // Checkbox input
                  name="inStock" // Maps to state variable
                  checked={this.state.inStock} // Bind value
                  onChange={this.handleChange} // Update state on change
                />{" "}
                Available in Stock {/* Label text */}
              </label>
            </div>

            {/* Number input */}
            <div className="form-group mb-3">
              <label>Warranty (in years)</label> {/* Label for number input */}
              <input
                type="number" // Number input type
                name="warranty" // Maps to state variable
                className="form-control" // Bootstrap styling
                value={this.state.warranty} // Bind value from state
                onChange={this.handleChange} // Update state on change
                required // Validation
              />
            </div>

            {/* Submit button */}
            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </form>
        </div>

        {/* Show table after submission */}
        {this.state.submitted && ( // Conditional rendering
          <div className="card mt-4 p-4 shadow-sm"> {/* Card for output */}
            <h3 className="text-center mb-3">Submitted Details</h3> {/* Title */}
            <table className="table table-bordered"> {/* Bootstrap table */}
              <tbody>
                <tr>
                  <th>Accessory Name</th> {/* Table header */}
                  <td>{this.state.accessoryName}</td> {/* Show state value */}
                </tr>
                <tr>
                  <th>Description</th>
                  <td>{this.state.description}</td>
                </tr>
                <tr>
                  <th>Category</th>
                  <td>{this.state.category}</td>
                </tr>
                <tr>
                  <th>Brand</th>
                  <td>{this.state.brand}</td>
                </tr>
                <tr>
                  <th>Available in Stock</th>
                  <td>{this.state.inStock ? "Yes" : "No"}</td> {/* Show Yes/No */}
                </tr>
                <tr>
                  <th>Warranty</th>
                  <td>{this.state.warranty} Years</td>
                </tr>
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

export default AccessoriesForm; // Export component for use in App.js
