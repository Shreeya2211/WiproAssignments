import React, { Component } from "react"; // Import React library and Component class
import "bootstrap/dist/css/bootstrap.min.css"; // Import Bootstrap CSS for styling

// Class component to handle Marriage Form
class MarriageForm extends Component {
  constructor(props) {
    super(props); // Call parent constructor
    this.state = {
      brideName: "", // State variable to store bride's name
      groomName: "", // State variable to store groom's name
      date: "",      // State variable to store marriage date
      venue: "",     // State variable to store venue name
      submitted: false, // Flag to check if form is submitted
    };
  }

  // Method to handle input changes for all fields
  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value }); // Update state dynamically based on input name
  };

  // Method to handle form submission
  handleSubmit = (e) => {
    e.preventDefault(); // Prevent page from reloading
    this.setState({ submitted: true }); // Change flag to true to show details
  };

  // Render method to display UI
  render() {
    return (
      <div className="container mt-4"> {/* Container with margin-top */}
        {/* Card for Marriage Form */}
        <div className="card p-4 shadow-sm"> {/* Card with padding and shadow */}
          <h3 className="text-center mb-3">Marriage Form</h3> {/* Form title */}
          <form onSubmit={this.handleSubmit}> {/* Form element with submit handler */}
            
            {/* Bride Name Input */}
            <div className="form-group mb-3"> {/* Form group for spacing */}
              <label>Bride Name</label> {/* Input label */}
              <input
                type="text" // Text input field
                name="brideName" // State key: brideName
                className="form-control" // Bootstrap input styling
                value={this.state.brideName} // Controlled input linked to state
                onChange={this.handleChange} // Updates state on typing
                required // Makes field mandatory
              />
            </div>

            {/* Groom Name Input */}
            <div className="form-group mb-3">
              <label>Groom Name</label>
              <input
                type="text"
                name="groomName"
                className="form-control"
                value={this.state.groomName}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Marriage Date Input */}
            <div className="form-group mb-3">
              <label>Marriage Date</label>
              <input
                type="date" // Date picker input
                name="date" // State key: date
                className="form-control"
                value={this.state.date}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Venue Input */}
            <div className="form-group mb-3">
              <label>Venue</label>
              <input
                type="text"
                name="venue"
                className="form-control"
                value={this.state.venue}
                onChange={this.handleChange}
                required
              />
            </div>

            {/* Submit Button */}
            <button type="submit" className="btn btn-primary w-100">
              Submit {/* Button text */}
            </button>
          </form>
        </div>

        {/* Display Submitted Details */}
        {this.state.submitted && ( // Show only if submitted is true
          <div className="card mt-4 p-4 shadow-sm">
            <h3 className="text-center mb-3">Marriage Details</h3> {/* Section title */}
            <p><strong>Bride Name:</strong> {this.state.brideName}</p> {/* Display bride name */}
            <p><strong>Groom Name:</strong> {this.state.groomName}</p> {/* Display groom name */}
            <p><strong>Date:</strong> {this.state.date}</p> {/* Display date */}
            <p><strong>Venue:</strong> {this.state.venue}</p> {/* Display venue */}
          </div>
        )}
      </div>
    );
  }
}

export default MarriageForm; // Export component so it can be used in App.js
