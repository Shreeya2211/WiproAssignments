import React, { Component } from 'react';

class Car extends Component {
  render() {
    return (
      <div>
        <h2>Car Details</h2>
        <p><b>Brand:</b> {this.props.brand}</p>
        {/*(this) is used for state hence it is a  class component*/}
        <p><b>Model:</b> {this.props.model}</p>
        <p><b>Color:</b> {this.props.color}</p>
        <p><b>Year:</b> {this.props.year}</p>
      </div>
    );
  }
}

export default Car;//its mandatory to export the component to import it in App.js because im creating separate file for the component.