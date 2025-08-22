import React from "react"; // Import React to use JSX

function FruitList({ fruits }) { // Define functional component that accepts 'fruits' as props
  return ( // Return JSX structure
    <div> {/* Wrapper div for the fruit list */}
      <h3>FruitList</h3> {/* Heading for the fruit list */}
      <ul> {/* Unordered list to display fruits */}
        {fruits.map((fruit, index) => ( // Loop through fruits array with map()
          <li key={index}>{fruit}</li> // Display each fruit as a list item, using index as key
        ))} 
      </ul>
    </div>
  );
}

export default FruitList; // Export FruitList component to be used in other files
