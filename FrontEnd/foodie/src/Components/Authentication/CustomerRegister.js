import { useState } from 'react';
import { useNavigate } from "react-router-dom"
import React from 'react'
import axios from "axios";
import "./Registration.css";
const CustomerRegister = () => {
    var navigate=useNavigate()
    const [custObj ,setObj] = useState({fname:"", lname:"",address:"",email:"",pwd:""});
    var nav = useNavigate();
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
            alert("registered successfully. Please login")
          nav("/");
        alert(JSON.stringify(result));

            console.log(result.data)
            alert("Sucessfull Register")
            navigate("/")
            

         localStorage.custobject=result;
          nav("/customerHome");
        alert(result);

        }).catch(error=>{
            alert("Error in Registering")
            console.log(error);
        })

    }

    // private String firstName;
	// private String lastName;
	// private String address;
	// private String email;
	// private String password;

    return (
    <div >
    <div class="wrapper">
        <div class="form-left">
            <h2 class="text-uppercase">information</h2>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Et molestie ac feugiat sed. Diam volutpat commodo.
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
                    <input value={custObj.fname}  class="input-field"  onChange={handleChange} type="text" name='fname' id='firstName' required/>
                  
                <inpu></inpu>
                </div>
                <div class="col-sm-6 mb-3">
                    <label  for="lastName">Last Name</label>
                    <input value={custObj.lname}  class="input-field" onChange={handleChange} type="text" name='lname' id='lastName' required/>
                </div>
            </div>
            <div class="mb-3">
                <label for='address'>Address : </label>
               <br /><input   class="input-field" value={custObj.address} onChange={handleChange} type="text" name='address' id='address'  required/><br />
            </div>
                <div class="mb-3">
                    <label for='email'>Email : </label>
                     <input value={custObj.email} onChange={handleChange} class="input-field" type="email" name='email' id='email' required/>
                </div>

            <div class="row">
                <div class="col-sm-6 mb-3">
                    <label for='password'>Password : </label>
                  <input value={custObj.pwd} onChange={handleChange} type="password" name='pwd'  class="input-field" id='password' />

                </div>
                <div class="col-sm-6 mb-3">
                    <label for='password'>Confirm Password : </label>
                     <input  onChange={handleChange} type="text" name='cpwd' id='cpassword' class="input-field"/>
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
export default CustomerRegister