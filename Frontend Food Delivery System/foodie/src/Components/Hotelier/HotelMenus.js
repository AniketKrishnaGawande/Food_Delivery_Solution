import React from "react";
import HotelNavbar from "./HotelNavbar";
import { useState, useEffect } from "react";
import MenuRender from "./MenuRender";
import axios from "axios";
const HotelMenus=()=>
{
    const[menu,setMenu]=useState([]);
    const hid = JSON.parse(localStorage.getItem("hotelier")).id

    useEffect(() => {
        axios.get(`http://localhost:8080/hotelMenu/getMenuByHotelId/${hid}`).then((response => {
            // var obj1 = response.data
            setMenu(response.data);
            // console.log(obj1)
            console.log(JSON.stringify(response.data))
            
            
        }));
    }, []);

    var GetMenus=()=>menu.map((data)=>{return <MenuRender menus={data}></MenuRender>})

    return(
        <div>
            <HotelNavbar></HotelNavbar>
            <div>{GetMenus()}</div>
            
        </div>
    )
}
export default HotelMenus