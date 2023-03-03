import { useState } from 'react';
import { useNavigate } from "react-router-dom"
import React from 'react'
import axios from "axios";

const CustomerRegister = () => {
    const [custObj ,setObj] = useState({fname:"", lname:"",address:"",email:"",pwd:""});
    
    const handleChange=(e)=>
    {
            var {name,value}=e.target;
            setObj({...custObj,[name]:value});
    }    
    const handleApi=()=>
    {

var pwd = document.querySelector("#password").value;
var cpwd = document.querySelector("#cpassword").value;
if(pwd!=cpwd)
{
    alert("password not matched. please enter same password");
    return;
}
        axios.post('http://localhost:8080/customer/customerRegister',{
            firstName:custObj.fname,
            lastName:custObj.lname,
            address:custObj.address,
            email:custObj.email,
            password:custObj.pwd
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
            <br /><input value={custObj.fname} onChange={handleChange} type="text" name='fname' id='firstName' /><br />

            <label for='lastName'>lastName : </label>
            <br /><input value={custObj.lname} onChange={handleChange} type="text" name='lname' id='lastName' /><br />

            <label for='address'>Address : </label>
            <br /><input value={custObj.address} onChange={handleChange} type="text" name='address' id='address' /><br />

            <label for='firsemailtName'>Email : </label>
            <br /><input value={custObj.email} onChange={handleChange} type="email" name='email' id='email' /><br />

            <label for='password'>Password : </label>
            <br /><input value={custObj.pwd} onChange={handleChange} type="password" name='pwd' id='password' /><br />

            <label for='password'>Confirm Password : </label>
            <br /><input  onChange={handleChange} type="text" name='cpwd' id='cpassword' /><br />

            <button onClick={handleApi}>Register</button>
        </div>

    )
}
export default CustomerRegister
