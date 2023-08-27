import React from "react";
import HotelNavbar from "./HotelNavbar";
import { useState } from 'react';
import { useNavigate } from "react-router-dom"
import axios from "axios";
const Addmenu=()=>
{
    const[menu,setMenu]=useState({description:"",menu:"",mname:"",mprice:""})

    const handleChange=(e)=>
    {
            var {name,value}=e.target;
            setMenu({...menu,[name]:value});
    } 

    const handleApi=()=>
    {

        if(menu.description=="" || menu.menu=="" || menu.mname==""|| menu.mprice=="")
        {
            alert("Enter data")
            return;
        }
        const hid = JSON.parse(localStorage.getItem("hotelier")).id
        axios.post(`http://localhost:8080/hotelMenu/addHotelMenus/${hid}`,{
            description:menu.description,
            menu:menu.menu,
            mname:menu.mname,
            mprice:menu.mprice,
            
        }).then(result=>{
           console.log("Menu Added")
           alert("Menu Added Sccessfully")
           window.location.reload(false)
          
        }).catch(error=>{
           
            console.log(error);
        })

    }


    return(
        <div>
            <HotelNavbar></HotelNavbar>

            <div class="wrapper">
        
        <div class="form-right">
            <h2 class="text-uppercase">Add Menus</h2>

            <div class="row">
            
                <div class="col-sm-6 mb-3">
                
                <label for="description">Description</label>
                    <input value={menu.description}  class="input-field"  onChange={handleChange} type="text" name='description' id='description' required/>
                  
                </div>
                
                <div class="col-sm-6 mb-3">
                    <label  for="menu">Menu Type</label>
                    <input value={menu.menu}  class="input-field" onChange={handleChange} type="text" name='menu' id='menu' required/>
                </div>
            </div>
            <div class="mb-3">
                <label for='mname'>Menu Name </label>
               <br /><input   class="input-field" value={menu.mname} onChange={handleChange} type="text" name='mname' id='mname'  required/><br />
            </div>
                <div class="mb-3">
                    <label for='mprice'>Menu Price  </label>
                     <input value={menu.mprice} onChange={handleChange} class="input-field" type="text" name='mprice' id='mprice' required/>
                </div>

            <div class="form-field">
                <button onClick={handleApi}  class="register btn btn-success">Add</button>
            </div>
        </div>

    </div>


        </div>
    )
}
export default Addmenu