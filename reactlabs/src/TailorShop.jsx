import React from "react";

const ServiceCard = ({ serviceName, price, fabricsAvailable }) => {
  return (
    <div style={{ display: "inline-block", margin: "0 10px", verticalAlign: "top" }}>
      +-------------------+<br />
      {`| ${serviceName.padEnd(17)} |`}<br />
      {`| Price: $${price.toString().padEnd(11)} |`}<br />
      {`| Fabrics:          |`}<br />
      {fabricsAvailable.map((fabric, i) => (
        <div key={i}>{`| - ${fabric.padEnd(14)} |`}</div>
      ))}
      +-------------------+<br />
    </div>
  );
};

const TailorShop = () => {
  const services = [
    {
      serviceName: "Shirt",
      price: 20,
      fabricsAvailable: ["Cotton", "Linen", "Polyester"],
    },
    {
      serviceName: "Pants",
      price: 30,
      fabricsAvailable: ["Denim", "Wool", "Chino"],
    },
    {
      serviceName: "Lehenga",
      price: 150,
      fabricsAvailable: ["Silk", "Georgette", "Chiffon"],
    },
    {
      serviceName: "Blouse",
      price: 40,
      fabricsAvailable: ["Cotton", "Silk", "Satin"],
    },
  ];

  return (
    <div style={{ fontFamily: "monospace", whiteSpace: "pre", textAlign: "center" }}>
      +---------------------------------------------------+<br />
      |                 Tailoring Services                |<br />
      +---------------------------------------------------+<br /><br />

      {/* First row (3 services side by side) */}
      <div>
        {services.slice(0, 3).map((s, i) => (
          <ServiceCard key={i} {...s} />
        ))}
      </div>

      <br />

      {/* Second row (Blouse alone) */}
      <div>
        <ServiceCard {...services[3]} />
      </div>
    </div>
  );
};

export default TailorShop;