import React, { useEffect, useState } from "react";
import { Route, Routes, useNavigate } from "react-router-dom";
import Header from "./subComponents/Header";
import Slider from "./subComponents/Slider";
const Home=()=>{
    var nav=useNavigate();
    useEffect(()=>{
if(!localStorage.customer)
{nav("/")}
},[]);
return(
    <div>
<Header ></Header>
<Slider></Slider>


    </div>
);

}
export default Home;