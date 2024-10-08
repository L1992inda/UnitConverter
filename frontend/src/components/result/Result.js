import { useEffect, useState } from "react";


const Result = ({selectedUnit}) => {

    const [result, setResult] = useState(0);

    useEffect(()=>{

        if (selectedUnit.from && selectedUnit.to && selectedUnit.value) {
        const url = `http://localhost:8080/convert/temperature?from=${selectedUnit.from}&to=${selectedUnit.to}&value=${selectedUnit.value}`;

        fetch(url)
        .then((res)=> res.json())
        .then((data)=>{
            setResult(data);
        })
        .catch((err)=>console.error("Error fetching data",err))
}},[selectedUnit])

return (
    <div>
      {result ? <div> {result}</div> : <div>Select values to convert</div>}
    </div>
  );
}



export default Result;
