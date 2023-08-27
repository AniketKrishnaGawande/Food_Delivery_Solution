import React from "react";
import delivery from '../Images/delivery.jpg'
import DeliveryNav from "./DeliveryNavBar";
import './CSS files/Delivery.css'
const DeliveryHome=()=>
{
    return(
        <div>
            <DeliveryNav></DeliveryNav>
            <img src={delivery} alt="delivery" className="delivery"></img>
        </div>
    )
}
export default DeliveryHome