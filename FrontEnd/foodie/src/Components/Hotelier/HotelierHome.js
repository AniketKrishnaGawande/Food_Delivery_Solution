import React from "react";
import HotelNavbar from "./HotelNavbar";
import background from '../Images/hotelbg2.jpg'
import './CSS files/HotelierHome.css'
const HotelHome=()=>
{
    return(
        <div>
            <HotelNavbar></HotelNavbar>
            <img src={background} alt="background" className="background"></img>
        </div>
    )
}
export default HotelHome