import React, { Component, createRef } from "react"; // Import React, Component class, and createRef for refs
import "bootstrap/dist/css/bootstrap.min.css"; // Import Bootstrap CSS for styling

// Controlled Component
class FlightBookingControlled extends Component { // Define controlled component class
  constructor(props) { // Constructor to initialize state
    super(props); // Call parent class constructor
    this.state = { // Define state for form fields
      name: "", // Passenger name field
      email: "", // Email field
      gender: "", // Gender field (radio)
      meal: "", // Meal preference field
      request: "", // Special request textarea
      submitted: false // Flag to check if form is submitted
    };
  }

  handleChange = (e) => { // Event handler for input changes
    this.setState({ [e.target.name]: e.target.value }); // Update corresponding state value
  };

  handleSubmit = (e) => { // Event handler for form submit
    e.preventDefault(); // Prevent page reload
    this.setState({ submitted: true }); // Mark form as submitted
  };

  render() { // Render method to display JSX
    return (
      <div className="p-3 border rounded shadow-sm"> {/* Container with Bootstrap styling */}
        <h4 className="mb-3">Controlled Flight Booking Form</h4> {/* Form heading */}
        <form onSubmit={this.handleSubmit}> {/* Form with submit handler */}
          <div className="mb-2"> {/* Input wrapper */}
            <input
              type="text" // Text input
              className="form-control" // Bootstrap input style
              name="name" // State key
              placeholder="Passenger Name" // Placeholder text
              value={this.state.name} // Controlled value from state
              onChange={this.handleChange} // Update state on change
              required // Field is mandatory
            />
          </div>
          <div className="mb-2">
            <input
              type="email" // Email input
              className="form-control"
              name="email"
              placeholder="Email"
              value={this.state.email}
              onChange={this.handleChange}
              required
            />
          </div>
          <div className="mb-2">
            <label className="me-2">Gender:</label> {/* Label for gender */}
            <input
              type="radio" // Radio button for Male
              name="gender"
              value="Male"
              checked={this.state.gender === "Male"} // Checked if state matches
              onChange={this.handleChange}
              className="form-check-input me-1"
            />
            Male {/* Display Male */}
            <input
              type="radio" // Radio button for Female
              name="gender"
              value="Female"
              checked={this.state.gender === "Female"}
              onChange={this.handleChange}
              className="form-check-input ms-3 me-1"
            />
            Female {/* Display Female */}
          </div>
          <div className="mb-2">
            <select
              className="form-control" // Dropdown
              name="meal"
              value={this.state.meal}
              onChange={this.handleChange}
              required
            >
              <option value="">Select Meal Preference</option> {/* Default option */}
              <option value="Veg">Veg</option> {/* Veg option */}
              <option value="Non-Veg">Non-Veg</option> {/* Non-Veg option */}
            </select>
          </div>
          <div className="mb-2">
            <textarea
              className="form-control" // Textarea for requests
              name="request"
              placeholder="Special Request"
              value={this.state.request}
              onChange={this.handleChange}
            ></textarea>
          </div>
          <button type="submit" className="btn btn-primary w-100"> {/* Submit button */}
            Submit
          </button>
        </form>

        {this.state.submitted && ( // If form submitted, show details
          <div className="mt-3">
            <h5>Submitted Details</h5>
            <table className="table table-bordered"> {/* Display data in table */}
              <tbody>
                <tr>
                  <th>Name</th> {/* Table header */}
                  <td>{this.state.name}</td> {/* Name value */}
                </tr>
                <tr>
                  <th>Email</th>
                  <td>{this.state.email}</td>
                </tr>
                <tr>
                  <th>Gender</th>
                  <td>{this.state.gender}</td>
                </tr>
                <tr>
                  <th>Meal</th>
                  <td>{this.state.meal}</td>
                </tr>
                <tr>
                  <th>Special Request</th>
                  <td>{this.state.request}</td>
                </tr>
              </tbody>
            </table>
          </div>
        )}
      </div>
    );
  }
}

// Uncontrolled Component
class FlightBookingUncontrolled extends Component { // Define uncontrolled component
  constructor(props) {
    super(props);
    this.flightRef = createRef(); // Ref for flight number input
    this.sourceRef = createRef(); // Ref for source input
    this.destinationRef = createRef(); // Ref for destination input
    this.dateRef = createRef(); // Ref for date input
    this.termsRef = createRef(); // Ref for checkbox input
    this.state = { submitted: false, data: {} }; // Store submitted status and form data
  }

  handleSubmit = (e) => { // Handle form submission
    e.preventDefault(); // Prevent page reload
    this.setState({ // Update state with values from refs
      submitted: true,
      data: {
        flight: this.flightRef.current.value, // Get flight number
        source: this.sourceRef.current.value, // Get source
        destination: this.destinationRef.current.value, // Get destination
        date: this.dateRef.current.value, // Get date
        terms: this.termsRef.current.checked ? "Accepted" : "Not Accepted" // Get terms status
      }
    });
  };

  render() {
    return (
      <div className="p-3 border rounded shadow-sm"> {/* Container */}
        <h4 className="mb-3">Uncontrolled Flight Booking Form</h4>
        <form onSubmit={this.handleSubmit}> {/* Form with submit handler */}
          <div className="mb-2">
            <input
              type="text"
              className="form-control"
              placeholder="Flight Number"
              ref={this.flightRef} // Use ref instead of state
              required
            />
          </div>
          <div className="mb-2">
            <input
              type="text"
              className="form-control"
              placeholder="Source"
              ref={this.sourceRef}
              required
            />
          </div>
          <div className="mb-2">
            <input
              type="text"
              className="form-control"
              placeholder="Destination"
              ref={this.destinationRef}
              required
            />
          </div>
          <div className="mb-2">
            <input
              type="date"
              className="form-control"
              ref={this.dateRef}
              required
            />
          </div>
          <div className="form-check mb-2">
            <input
              type="checkbox"
              className="form-check-input"
              ref={this.termsRef}
            />
            <label className="form-check-label">Accept Terms & Conditions</label>
          </div>
          <button type="submit" className="btn btn-success w-100"> {/* Submit button */}
            Submit
          </button>
        </form>

        {this.state.submitted && ( // Show submitted data after submit
          <div className="mt-3">
            <div className="card p-3"> {/* Card layout */}
              <h5>Submitted Details</h5>
              <p><strong>Flight Number:</strong> {this.state.data.flight}</p>
              <p><strong>Source:</strong> {this.state.data.source}</p>
              <p><strong>Destination:</strong> {this.state.data.destination}</p>
              <p><strong>Travel Date:</strong> {this.state.data.date}</p>
              <p><strong>Terms:</strong> {this.state.data.terms}</p>
            </div>
          </div>
        )}
      </div>
    );
  }
}

// Parent Component
class App15 extends Component { // Parent component that renders both forms
  render() {
    return (
      <div className="container mt-4"> {/* Bootstrap container */}
        <div className="row"> {/* Bootstrap row */}
          <div className="col-md-6"> {/* First column */}
            <FlightBookingControlled /> {/* Controlled form */}
          </div>
          <div className="col-md-6"> {/* Second column */}
            <FlightBookingUncontrolled /> {/* Uncontrolled form */}
          </div>
        </div>
      </div>
    );
  }
}

export default App15; // Export App15 as default
