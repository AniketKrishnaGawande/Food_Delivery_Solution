import { useState } from 'react';
import { useNavigate } from "react-router-dom"
import React from 'react'
import axios from "axios";
const HotelierRegister = () => {
    var nav = useNavigate();
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
        if(email=="" || fname==""|| address=="" || pwd=="" )
        {
            alert("Enter data")
            return;
        }
        axios.post('http://localhost:8080/hotels/RegisterHotel',{

        hname:fname,
        haddress:address,
            email:email,
            password:pwd
        }).then(result=>{
            console.log(result.data)
            nav("/");
        }).catch(error=>{
            alert("Error in Registering")
            console.log(error)
        })

    }

    return (
        <div class="form-right">
            <div class="wrapper">
        <div class="form-left">
            <h2 class="text-uppercase">information</h2>
            <p>
                empor incididunt ut labore et dolore magna aliqua. Et molestie ac feugiat sed. Diam volutpat commodo.
            </p>
            <p class="text">
                <span>Sub Head:</span>
                Vitae auctor eu augudsf ut. Malesuada nunc vel risus commodo viverra. Praesent elementum facilisis leo vel.
            </p>
            <div class="form-field">
                <a  href='/'>  <input type="button" class="account" value="Have an Account?"/></a> 
            </div>
        </div>

        <div class="form-right">
            <h2 class="text-uppercase">Registration form</h2>

            <div class="row">
            
                <div class="col-sm-6 mb-3">
                
                <label for="firstName">First Name</label>
                    <input value={fname.fname}  class="input-field"  onChange={handleFname} type="text" name='fname' id='firstName' required/>
                  
                </div>
                
                <div class="col-sm-6 mb-3">
                    <label  for="lastName">Address</label>
                    <input value={address.address}  class="input-field" onChange={handleAddress} type="text" name='lname' id='lastName' required/>
                </div>
            </div>
                <div class="mb-3">
                    <label for='email'>Email : </label>
                     <input value={email.email} onChange={handleEmail} class="input-field" type="email" name='email' id='email' required/>
                </div>

            <div class="row">
                <div class="col-sm-6 mb-3">
                    <label for='password'>Password : </label>
                  <input value={pwd.pwd} onChange={handlePwd} type="password" name='pwd'  class="input-field" id='password' />
                </div>
            </div>
            <div class="form-field">
                <button onClick={handleApi}  class="register">Register</button>
            </div>
        </div>

    </div>
            
        </div>

    )
}
export default HotelierRegister
