import React, { Component } from "react"; // Import React library and Component class

// Functional Component to display list of televisions
function TelevisionList({ models }) { // Receive 'models' as props
  return (
    <div>
      <h3>📺 Television Models</h3> {/* Heading for the list */}
      <ul>
        {models.map((model, index) => ( // Loop through models array
          <li key={index}>{model}</li> // Render each television model as list item
        ))}
      </ul>
    </div>
  );
}

// Class Component to manage televisions
class TelevisionManager extends Component { // Main class component
  constructor(props) { 
    super(props); // Call parent constructor
    this.state = { // Initialize component state
      models: ["Sony Bravia", "Samsung Crystal", "LG OLED"], // Default television models
      newModel: "", // To store input for new television model
    };
  }

  handleChange = (e) => { // Handle input field change
    this.setState({ newModel: e.target.value }); // Update 'newModel' in state
  };

  addModel = () => { // Method to add a new model
    if (this.state.newModel.trim() !== "") { // Check if input is not empty
      this.setState((prevState) => ({ // Update state immutably
        models: [...prevState.models, prevState.newModel], // Add new model using spread operator
        newModel: "", // Reset input field after adding
      }));
    }
  };

  render() { // Render method for UI
    return (
      <div style={{ margin: "20px" }}> {/* Container with margin */}
        <h2>Television Manager</h2> {/* Heading */}
        <input
          type="text" // Input type text
          value={this.state.newModel} // Controlled input bound to state
          onChange={this.handleChange} // Calls handleChange on typing
          placeholder="Enter Television Model" // Placeholder text
        />
        <button onClick={this.addModel}>Add Model</button> {/* Button to add model */}

        {/* Pass models array as props to child component */}
        <TelevisionList models={this.state.models} /> 
      </div>
    );
  }
}

export default TelevisionManager; // Export the main class component as default
