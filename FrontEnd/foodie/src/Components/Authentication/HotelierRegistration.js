import { useState } from 'react';
import { useNavigate } from "react-router-dom"
import React from 'react'
import axios from "axios";

const HotelierRegister = () => {
    const [fname, setFname] = useState('');
    const [address, setAddresse] = useState('');
    const [email, setEmail] = useState('');
    const [pwd, setPwd] = useState('');

    const handleFname=(e)=>
    {
        setFname(e.target.value)
    }
    
    const handleAddress=(e)=>
    {
        setAddresse(e.target.value)
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
        axios.post('http://localhost:8080/hotels/RegisterHotel',{

            hName:fname,
            hAddress:address,
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
            
            <label for='firstName'>Hotel Name : </label>
            <br /><input value={fname} onChange={handleFname} type="text" name='firstName' id='firstName' /><br />

            <label for='address'>Address : </label>
            <br /><input value={address} onChange={handleAddress} type="text" name='address' id='address' /><br />

            <label for='email'>Email : </label>
            <br /><input value={email} onChange={handleEmail} type="text" name='email' id='email' /><br />

            <label for='password'>Password : </label>
            <br /><input value={pwd} onChange={handlePwd} type="text" name='password' id='password' /><br />

            <button onClick={handleApi}>Register</button>
        </div>

    )
}
export default HotelierRegister
