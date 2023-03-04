import { useState } from 'react';
import { useNavigate } from "react-router-dom"
import React from 'react'
import axios from "axios";

const DeliveryBoyRegister = () => {
    const [delObj ,setObj] = useState({firstName:"", lastName:"",email:"",password:""});
    const [fname, setFname] = useState('');
    const [lname, setLname] = useState('');
    const [email, setEmail] = useState('');
    const [pwd, setPwd] = useState('');

    const handleFname=(e)=>
    {
        setFname(e.target.value)
    }
    const handleLname=(e)=>
    {
        setLname(e.target.value)
    }
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
        if(delObj.email=="" || delObj.firstName==""|| delObj.lastName=="" || delObj.password=="" )
        {
            alert("Enter data")
            return;
        }
        axios.post('http://localhost:8080/deliveryBoy/registerDeliveryBoy',{
            firstName:fname,
            lastName:lname,
            email:email,
            password:pwd
        }).then(result=>{
            console.log(result.data)
            alert("Sucessfull Register")
        }).catch(error=>{
            alert("Error in Registering")
            console.log(error)
        })

    }

    return (
        <div>
            
            <label for='firstName'>FirstName : </label>
            <br /><input value={fname} onChange={handleFname} type="text" name='firstName' id='firstName' required/><br />

            <label for='lastName'>lastName : </label>
            <br /><input value={lname} onChange={handleLname} type="text" name='lastName' id='lastName'required /><br />

            <label for='email'>Email : </label>
            <br /><input value={email} onChange={handleEmail} type="text" name='email' id='email' required/><br />

            <label for='password'>Password : </label>
            <br /><input value={pwd} onChange={handlePwd} type="text" name='password' id='password' required/><br />

            <button onClick={handleApi}>Register</button>
        </div>

    )
}
export default DeliveryBoyRegister
