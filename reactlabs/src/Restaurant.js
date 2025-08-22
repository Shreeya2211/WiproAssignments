import React, { Component } from "react";

// Child Component
//presentation component too only UI presentation is available in this component
//destructuring,In a class component, props are accessed using this.props
class MenuItem extends Component {
  render() {
    const { name, price, category, available } = this.props;
    return (
      <li>
        {name} - ₹{price} ({category}), {available ? "Available" : "Not Available"}
      </li>
    );
  }
}

// Parent Component
//container component,hence it holds some logic code
class Restaurant extends Component {
  render() {
    return (
      <div style={{ padding: "20px", fontFamily: "Arial" }}>
        <h1>Restaurant Name: Kritunga</h1>
        <p><b>Location:</b> SR Complex, First Floor</p>
        <p><b>Open Hours:</b> 10:00 AM - 10:00 PM</p>

        <h2>Restaurant Menu:</h2>
        <ul>
          <MenuItem name="Chicken lollipop" price={150} category="Main Course" available={true} />
          <MenuItem name="prawns Biryani" price={200} category="Main Course" available={true} />
          <MenuItem name="Butter Scotch" price={80} category="Breakfast" available={true} />
          <MenuItem name="Veg Biryani" price={40} category="Dessert" available={false} />
          <MenuItem name="Roti" price={120} category="Combo" available={true} />
        </ul>
      </div>
    );
  }
}

export default Restaurant;//its mandatory to export the component to import it in App.js because im creating separate file for the component.