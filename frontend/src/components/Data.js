import { useEffect,useState } from "react";

export const useData = ()=>{
    const [data, setData] = useState(null);

    useEffect(() => {
        fetch("http://localhost:8080/units")
            .then((res) => res.json())
            .then((data) => {
                setData(data); 
            })
            .catch((err) => console.error("Error fetching data", err));
    }, [setData]);

 return {
        data
    }
};




   
