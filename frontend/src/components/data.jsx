import { useEffect, useState } from "react";

export const Data = () => {
    const [fetchedData, setFetchedData] = useState({});

    useEffect(() => {
        fetch("http://localhost:8080/units")
            .then((res) => res.json())
            .then((data) => setFetchedData(data))
            .catch((err) => console.error("Error fetching data", err));
    }, []);

    return (
        <div>
            {Object.keys(fetchedData).map((category) => (
                <div key={category}>
                    <h3>{category}</h3>
                    <ul>
                        {fetchedData[category].map((unit,index)=>
                        (
                            <li key={index}>
                                {unit.name} ({unit.symbol})
                            </li>
                        ))}
                    </ul>
                </div>
            ))}
        </div>
    );
};
