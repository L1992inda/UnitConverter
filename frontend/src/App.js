import React, { useEffect, useState } from "react";
import { useData } from "./components/Data";
import "./app.css";
import Dropdown from "./components/dropdown/Dropdown";

const App = () => {
  const { data } = useData();

  const [tabs, setTabs] = useState([]);
  const [activeTab, setActiveTab] = useState("");
  const [options, setOptions] = useState([]);
  const [selectedUnit, setSelectedUnit] = useState({
    from: "",
    to: "",
    value: 0,
  });

  useEffect(() => {
    if (data) {
      setTabs((prevState) => Object.keys(data));
    }
  }, [data]);

  const tabContent = (tab) => {
    const allOptions = data[tab].map((unit) => ({
      name: unit.name,
      symbol: unit.symbol,
    }));

    setSelectedUnit((prevState) => ({
      from: "",
      to: "",
      value: 0,
    }));
    setOptions((prevState) => allOptions);
    setActiveTab(tab);
  };

  return (
    <div>
      {
        <div>
          {tabs.map((tab) => (
            <button
              className="navbar"
              key={tab}
              style={{ backgroundColor: activeTab === tab ? "#777" : "" }}
              onClick={() => {
                tabContent(tab);
              }}
            >
              {tab}
            </button>
          ))}
        </div>
      }
      <div className="main-div">    
        {activeTab && (
          <Dropdown 
            options={options}
            activeTab={activeTab}
            selectedUnit={selectedUnit}
            setSelectedUnit={setSelectedUnit}
          />
        )}     
      </div>
    </div>
  );
};

export default App;
