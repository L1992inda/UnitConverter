import React, { useEffect, useState } from "react";
import "./dropdown.css";
import Result from "../result/Result";

const Dropdown = ({  options, activeTab, selectedUnit, setSelectedUnit }) => {

  const updateFrom = (event) => {
    if (event.target.value === selectedUnit.to){
      setSelectedUnit((prev) => ({ ...prev, to: "" }));
      setSelectedUnit((prev) => ({ ...prev, from: event.target.value }));
    }else{
      setSelectedUnit((prev) => ({ ...prev, from: event.target.value }));
    }
  };

  const updateTo = (event) => {
    if (event.target.value === selectedUnit.from) {
      setSelectedUnit((prev) => ({ ...prev, from: "" }));
      setSelectedUnit((prev) => ({ ...prev, to: event.target.value }));
    } else {
      setSelectedUnit((prev) => ({ ...prev, to: event.target.value }));
    }
  };

  const updateValue = (event) => {
    setSelectedUnit((prev) => ({ ...prev, value: event.target.value }));
  };

  useEffect(() => {
    setSelectedUnit({ from: "", to: "", value: 0 });
  }, [activeTab]);

  return (
    <div>
      <div>
      <label>
        <input
          name="userInput"
          type="number"
          value={selectedUnit.value}
          onChange={updateValue}
        />
      </label>
      </div>
      <div className="dropdown-container"> 
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
</div><div className="result-container">
      {selectedUnit.from && selectedUnit.to && selectedUnit.value && (
        <Result selectedUnit={selectedUnit} activeTab={activeTab} />
      )}
</div>
    </div>
  );
};

export default Dropdown;
