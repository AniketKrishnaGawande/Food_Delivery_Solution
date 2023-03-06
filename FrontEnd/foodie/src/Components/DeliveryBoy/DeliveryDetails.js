import React from "react";
import DeliveryNav from "./DeliveryNavBar";
import axios from "axios";
import { useState, useEffect } from "react";
import DeliveryRender from "./DeliveryRender";
const DeliveryDetails=()=>
{

    const[service,setService]=useState([]);
    const hid = JSON.parse(localStorage.getItem("delivery")).id

    useEffect(() => {
        axios.get(`http://localhost:8080/changeStatus/getHistoryItemByDeliveryBoy/${hid}`).then((response => {
            // var obj1 = response.data
            setService(response.data);
            // console.log(obj1)
            console.log(JSON.stringify(response.data))
            
            
        }));
    }, []);

    var GetDetails=()=>service.map((data)=>{return <DeliveryRender delivery={data}></DeliveryRender>})

    return(
        <div>
            <DeliveryNav></DeliveryNav>
            <div>{GetDetails()}</div>

        </div>
    )
}
export default DeliveryDetails