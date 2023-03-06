import React from "react";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import HotelNavbar from "./HotelNavbar";
import axios from 'axios';
import OrderStatusRender from './OrderStatusRender';
const Order = () => {
    const navigate = useNavigate()
    var [obj, setObj] = useState([]);
   
    const hid = JSON.parse(localStorage.getItem("hotelier")).id
    useEffect(() => {
        axios.get(`http://localhost:8080/order/historyForHotel/${hid}`).then((response => {
            // var obj1 = response.data
            setObj(response.data);
            // console.log(obj1)
            console.log(JSON.stringify(response.data))
            
            
        }));
    }, []);

    var OrderRender=()=>obj.map((data)=>{return <OrderStatusRender order={data}></OrderStatusRender>})

        return(
            <div>
                <HotelNavbar></HotelNavbar>
                <div>{OrderRender()}</div>

            </div>


        )
}
export default Order