import { useEffect, useState } from "react";

const Result = ({ selectedUnit, activeTab }) => {
  const [result, setResult] = useState(0);

  useEffect(() => {
    if (
      selectedUnit.from &&
      selectedUnit.to &&
      selectedUnit.value &&
      activeTab
    ) {
      const converter = activeTab.toLowerCase();
      const url = `http://localhost:8080/convert/${converter}?from=${selectedUnit.from}&to=${selectedUnit.to}&value=${selectedUnit.value}`;

      fetch(url)
        .then((res) => res.json())
        .then((data) => {
          setResult(data);
        })
        .catch((err) => console.error("Error fetching data", err));
    }
  }, [selectedUnit, activeTab]);

  return (
    <div>
      {result && activeTab && (
        <div>
          {selectedUnit.value} {selectedUnit.from}
          {" = "}
          {result} {selectedUnit.to}
        </div>
      )}
    </div>
  );
};

export default Result;
