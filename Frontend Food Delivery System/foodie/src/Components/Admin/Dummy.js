import React from "react";
function dummy()
{
    const dummy=()=>
    {
        const obj=JSON.parse(localStorage.getItem("admin")).firstName 
        return obj
    }

    return(
        <div>
        <h2>Session maintained for :{dummy()} </h2>
        
        </div>
    )
}
export default dummy