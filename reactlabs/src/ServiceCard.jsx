import React from "react"; // Import React to use JSX

function ServiceCard({ service }) { // Define functional component with props destructured (service)
  return ( // Return JSX layout
    <div className="col-md-4 mb-4"> {/* Bootstrap column (3 cards per row), margin bottom */}
      <div className="card shadow h-100"> {/* Card with shadow and full height */}
        <div className="card-body text-center"> {/* Card body with centered text */}
          <h4 className="card-title">{service.serviceName}</h4> {/* Display service name */}
          <p className="card-text"> {/* Price paragraph */}
            <strong>Price:</strong> ${service.price} {/* Show service price */}
          </p>
          <h6>Fabrics Available:</h6> {/* Subtitle for fabrics list */}
          <ul className="list-unstyled"> {/* Unstyled list for fabrics */}
            {service.fabricsAvailable.map((fabric, index) => ( // Loop through fabrics array
              <li key={index}>- {fabric}</li> // Show each fabric in a list item
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
}

export default ServiceCard; // Export ServiceCard component for use in TailorShop
