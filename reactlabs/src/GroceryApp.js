//below two lines imports react lib and GroceryList component from the folder
import React from "react";
import GroceryList from "./GroceryList";

//defines another component GrocerApp and created an array groceries with 5 items
const GroceryApp = () => {
  const groceries = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];


  //inside the return we render grocerylist, passing groceries array as a prop items
  return <GroceryList items={groceries} />;
};

export default GroceryApp;
//exporting the component so that it can be imported in App.js