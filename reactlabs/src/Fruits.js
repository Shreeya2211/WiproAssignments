import React, { Component } from "react"; // Import React and Component class
import FruitList from "./FruitList"; // Import the FruitList child component

class Fruits extends Component { // Define Fruits component as a class
  constructor(props) { // Constructor to initialize state
    super(props); // Call parent constructor
    this.state = { // Define initial state
      fruits: ["Apple", "Banana", "Orange"], // List of fruits
      newFruit: "", // Store input for new fruit
    };
  }

  handleChange = (e) => { // Method to update newFruit value when input changes
    this.setState({ newFruit: e.target.value }); // Update state with input value
  };

  addFruit = () => { // Method to add new fruit to the list
    if (this.state.newFruit.trim() !== "") { // Check if input is not empty
      this.setState((prevState) => ({ // Update state based on previous state
        fruits: [...prevState.fruits, prevState.newFruit], // Add new fruit to array
        newFruit: "", // Clear input field after adding
      }));
    }
  };

  render() { // Render method to display UI
    return ( // Return JSX
      <div style={{ margin: "20px" }}> {/* Wrapper div with margin */}
        <h2>Fruits</h2> {/* Heading */}
        <input // Input field for entering fruit name
          type="text" // Input type is text
          value={this.state.newFruit} // Controlled input bound to state
          onChange={this.handleChange} // Call handleChange when input changes
          placeholder="Enter fruit" // Placeholder text in input
        />
        <button onClick={this.addFruit}>Add</button> {/* Button to add fruit */}

        {/* Pass fruits array as props to child component */}
        <FruitList fruits={this.state.fruits} /> {/* Render FruitList with fruits */}
      </div>
    );
  }
}

export default Fruits; // Export Fruits component
