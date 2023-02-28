import { useState } from 'react';
import { useNavigate } from "react-router-dom"
import React from 'react'
import axios from "axios";

const CustomerRegister = () => {
    const [fname, setFname] = useState('');
    const [lname, setLname] = useState('');
    const [address, setAddress] = useState('');
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
    const handleAddress=(e)=>
    {
        setAddress(e.target.value)
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
        axios.post('http://localhost:8080/customer/customerRegister',{
            firstName:fname,
            lastName:lname,
            address:address,
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

    // private String firstName;
	// private String lastName;
	// private String address;
	// private String email;
	// private String password;

    return (
        <div>
            
            <label for='firstName'>FirstName : </label>
            <br /><input value={fname} onChange={handleFname} type="text" name='firstName' id='firstName' /><br />

            <label for='lastName'>lastName : </label>
            <br /><input value={lname} onChange={handleLname} type="text" name='lastName' id='lastName' /><br />

            <label for='address'>Address : </label>
            <br /><input value={address} onChange={handleAddress} type="text" name='address' id='address' /><br />

            <label for='firsemailtName'>Email : </label>
            <br /><input value={email} onChange={handleEmail} type="text" name='email' id='email' /><br />

            <label for='password'>Password : </label>
            <br /><input value={pwd} onChange={handlePwd} type="text" name='password' id='password' /><br />

            <button onClick={handleApi}>Register</button>
        </div>

    )
}
export default CustomerRegister
