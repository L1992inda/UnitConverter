import React, { useEffect, useState } from "react";
import "./dropdown.css";
import Result from "../result/Result";

const Dropdown = ({ options, activeTab }) => {
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

  // const handleSubmit = () => {
  //    if (selectedUnit.from && selectedUnit.to && selectedUnit.value){
  //      <Result selectedUnit={selectedUnit} activeTab={activeTab} />

  //   }
  //}

  useEffect(() => {
    console.log("Resetting selectedUnit on tab change:", activeTab);
    setSelectedUnit({ from: "", to: "", value: 0 });
    console.log("values after tab change ", selectedUnit.from,selectedUnit.to,selectedUnit.value);
  }, [activeTab]);

  return (
    <div>
      <label>
        <input
          name="userInput"
          type="number"
          value={selectedUnit.value}
          onChange={updateVAlue}
        />
      </label>
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

      {selectedUnit.from && selectedUnit.to && selectedUnit.value  && (
        <Result selectedUnit={selectedUnit} activeTab={activeTab} />
      )}

    </div>
  );
};

export default Dropdown;
