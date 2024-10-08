import React, { useEffect, useState } from "react";
import Data from "./components/data";
import "./app.css";
import Dropdown from "./components/dropdown/Dropdown";

const App = () => {
  const [fetchedData, setFetchedData] = useState({});
  const [tabs, setTabs] = useState([]);
  const [activeTab, setActiveTab] = useState("");
  const [options, setOptions] = useState([]);

  useEffect(() => {
    if (Object.keys(fetchedData).length > 0) {
      setTabs(Object.keys(fetchedData));
    }
  }, [fetchedData]);

  const tabContent = (tab) => {
    const allOptions = fetchedData[tab].map((unit) => ({
      name: unit.name,
      symbol: unit.symbol,
    }));
    setOptions(allOptions);
  };

  return (
    <div>
      <Data setData={setFetchedData} />

      {
        <div>
          {tabs.length > 0
            ? tabs.map((tab) => (
                <button
                  className="navbar"
                  key={tab}
                  style={{ backgroundColor: activeTab === tab ? "#777" : "" }}
                  onClick={() => {
                    setActiveTab(tab);
                    tabContent(tab);
                  }}
                >
                  {tab}
                </button>
              ))
            : ""}
        </div>
      }
      {activeTab && <Dropdown options={options} />}
    </div>
  );
};

export default App;
