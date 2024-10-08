import React, { useState } from "react";
import "./dropdown.css";
import Result from "../result/Result";

const Dropdown = ({ options }) => {
  const [selectedUnit, setSelectedUnit] = useState({
    from: "",
    to: "",
    value: 0,
  });

  const updateFrom = (event) => {
    setSelectedUnit((prev) => ({ ...prev, from: event.target.value }));
  };

  const updateTo = (event) => {
    setSelectedUnit((prev) => ({ ...prev, to: event.target.value }));
  };

  const updateVAlue = (event) => {
    setSelectedUnit((prev) => ({ ...prev, value: event.target.value }));
  };

  return (
    <div>
      <select value={selectedUnit.from} onChange={updateFrom}>
        <option value=""> - - - - - </option>
        {options.map((unit, index) => (
          <option key={index} value={unit.name}>
            {unit.name} {unit.symbol}
          </option>
        ))}
      </select>

      <select value={selectedUnit.to} onChange={updateTo}>
        <option value=""> - - - - - </option>
        {options.map((unit, index) => (
          <option key={index} value={unit.name}>
            {unit.name} {unit.symbol}
          </option>
        ))}
      </select>

      <label>
        <input
          name="userInput"
          type="number"
          value={selectedUnit.value}
          onChange={updateVAlue}
        />
      </label>
      <Result selectedUnit={selectedUnit} />
    </div>
  );
};

export default Dropdown;
