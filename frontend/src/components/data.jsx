import { useEffect } from "react";

const Data = ({ setData }) => {
    useEffect(() => {
        fetch("http://localhost:8080/units")
            .then((res) => res.json())
            .then((data) => {
                setData(data); 
            })
            .catch((err) => console.error("Error fetching data", err));
    }, [setData]);

};

export default Data;
