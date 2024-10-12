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
      setSelectedUnit((prev) => ({ ...prev, to: event.target.value}));
    } else {
      setSelectedUnit((prev) => ({ ...prev, to: event.target.value}));
    }
  };

  const updateValue = (event) => {
    setSelectedUnit((prev) => ({ ...prev, value: event.target.value }));
  };

  const inputOnFocus =(e)=>{
 if(selectedUnit.value === 0){
  setSelectedUnit((prev)=>({...prev,value:""}))
 }
  };

  const inputOnBlur=(e)=>{
    if(selectedUnit.value === ""){
      setSelectedUnit((prev)=>({...prev,value:0}))
 }
    }

  useEffect(() => {
    setSelectedUnit({ from: "", to: "", value: 0});
  }, [activeTab,setSelectedUnit]);

  return (
    <div className="container">
      <div>
      <label>
        <input
          name="userInput"
          type="number"
          value={selectedUnit.value}
          onChange={updateValue}
          onFocus={inputOnFocus}
          onBlur={inputOnBlur}
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
</div>
<div className="result-container">
      {selectedUnit.from && selectedUnit.to && selectedUnit.value > 0 &&  (
        <Result selectedUnit={selectedUnit} activeTab={activeTab} options={options} />
      )}
</div>
    </div>
  );
};

export default Dropdown;
