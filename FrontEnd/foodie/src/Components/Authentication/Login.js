import { useState } from 'react';
import {useNavigate} from "react-router-dom";
import React from 'react'
import './Login.css'
import logo from'../Images/Foodie.jpg'
import axios from "axios";
const Login=()=>
{
    const[email,setEmail]=useState('');
    const[pwd,setPwd]=useState('');
    const navigate=useNavigate();

    const handleEmail=(e)=>
    {
        setEmail(e.target.value)
    }

    const handlePwd=(e)=>
    {
        setPwd(e.target.value)
    }

    const handleApi=()=>
    {
        // console.log({email,pwd})
        const selectedOption=document.querySelector("#users");
        const output=selectedOption.value;

        if(output==="Admin")
        {
            axios.post('http://localhost:8080/admin/adminLogin',{
            email:email,
            password:pwd
        }).then(result=>{
            console.log(result.data)
            // alert("success")
            localStorage.setItem("item",JSON.stringify(result.data))
            navigate("/home")//dummy component
            
        }).catch(error=>{
            alert("Service error")
            console.log(error)
        })

        }
        else if(output==="Customer")
        {
            axios.post('http://localhost:8080/customer/customerLogin',{
            email:email,
            password:pwd
        }).then(result=>{
            console.log(result.data)
            alert("success")
            // navigation remaining
        }).catch(error=>{
            alert("Service error")
            console.log(error)
        })
        }
        else if(output==="DeliveryBoy")
        {
            axios.post('http://localhost:8080/deliveryBoy/login',{
            email:email,
            password:pwd
        }).then(result=>{
            console.log(result.data)
            alert("success")
            // navigation remaining
        }).catch(error=>{
            alert("Service error")
            console.log(error)
        })
        }
        else if(output==="Hotelier")
        {
            axios.post('http://localhost:8080/hotels/hotelierLogin',{
            email:email,
            password:pwd
        }).then(result=>{
            console.log(result.data)
            alert("success")
            // navigation remaining
        }).catch(error=>{
            alert("Service error")
            console.log(error)
        })
        }
   

    }

    return(
        <div className='Main-Container'>
            <div className='div1'> 
            <img src={logo} alt="logo" className="Logo"></img>
        </div>


        <div className='div2'> 

            <label htmlFor='email' className='spacing'>Email : </label>
            <input value={email} onChange={handleEmail} type="email" id='email'/>

            <label htmlFor='password' className='spacing'>Password : </label>
            <input value={pwd} onChange={handlePwd} type="password" id='password'/>

                <select id='users'>
                <option value="Admin">Admin</option>
                <option value="Customer">Customer</option>
                <option value="Hotelier">Hotelier</option>
                <option value="DeliveryBoy">DeliveryBoy</option>
            </select>

            <button onClick={handleApi}>Login</button>

            <a href='/Customerregister' className='link'>Customer Registration</a>

            <a href='/Hotelierregister' className='link'>Hotelier Registration</a>
        
            <a href='/DeliveryBoyregister' className='link'>Delivery Boy Registration</a>
            </div>
        </div>
        
    )
}
export default Login