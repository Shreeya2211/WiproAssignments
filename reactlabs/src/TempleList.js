import React from "react"; // Import React to use JSX

const TempleList = () => { // Define a functional component named TempleList
  const temples = [ // Array of temple objects with id, name, location, and deities
    {
      id: 1, // Unique ID for the temple
      name: "Meenakshi Amman Temple", // Name of the temple
      location: "Madurai, Tamil Nadu", // Location of the temple
      deities: ["Meenakshi", "Sundareswarar"], // List of deities worshipped
    },
    {
      id: 2,
      name: "Sri Venkateswara Temple",
      location: "Tirupati, Andhra Pradesh",
      deities: ["Venkateswara", "Lakshmi"],
    },
    {
      id: 3,
      name: "Jagannath Temple",
      location: "Puri, Odisha",
      deities: ["Jagannath", "Balabhadra", "Subhadra"],
    },
  ];

  return ( // Return JSX to render UI
    <div> {/* Wrapper container */}
      <h2>🛕 Famous Temples in India</h2> {/* Heading for the list */}
      <table border="1" cellPadding="8" cellSpacing="0"> {/* Table with border and spacing */}
        <thead> {/* Table header */}
          <tr> {/* Row for column headings */}
            <th>ID</th> {/* Column for temple ID */}
            <th>Temple Name</th> {/* Column for temple name */}
            <th>Location</th> {/* Column for temple location */}
            <th>Deities</th> {/* Column for deities */}
          </tr>
        </thead>
        <tbody> {/* Table body to hold temple data */}
          {temples.map((temple) => ( // Loop through temples array and create a row for each temple
            <tr key={temple.id}> {/* Table row with unique key */}
              <td>{temple.id}</td> {/* Display temple ID */}
              <td>{temple.name}</td> {/* Display temple name */}
              <td>{temple.location}</td> {/* Display temple location */}
              <td> {/* Cell to display deities list */}
                <ul> {/* Unordered list of deities */}
                  {temple.deities.map((deity, index) => ( // Loop through deities array
                    <li key={index}>{deity}</li> // Display each deity as a list item
                  ))}
                </ul>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TempleList; // Export the TempleList component for use in other files
