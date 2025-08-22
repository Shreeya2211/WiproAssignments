import React from "react";

function TelevisionList({ televisions }) {
  return (
    <div style={{ marginTop: "20px" }}>
      <h3>Television Models</h3>
      <ul>
        {televisions.map((tv, index) => (
          <li key={index}>{tv}</li>
        ))}
      </ul>
    </div>
  );
}

export default TelevisionList;
