import React, { useEffect, useState } from "react";
import { Route, Routes, useNavigate } from "react-router-dom";
import Header from "./subComponents/Header";

const Home=()=>{
    var nav=useNavigate();
    useEffect(()=>{
if(!localStorage.customer)
{nav("/")}
},[]);
return(
    <div>
<Header ></Header>

    </div>
);

}
export default Home;