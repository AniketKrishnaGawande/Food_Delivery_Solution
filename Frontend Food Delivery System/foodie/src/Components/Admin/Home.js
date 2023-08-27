import React, { useEffect } from 'react'
import { Route, Routes, useNavigate } from 'react-router-dom'
import './CSS files/Home.css'
import Hotelier from './Hotelier'
import Navbar from './Navbar'
import eogo from '../Images/background2.jpg'
function Home() {   /*
    const navigate=useNavigate()
    const logout=()=>
    {
        localStorage.removeItem("admin")
        
    }
    */
    /*
     const redirect=()=>
     {
        
         if(localStorage.getItem("admin"))
          {
             navigate('/dummy')
          }
          else{
             navigate('/')
          }
     }
     */
   
    return (
        <div>
        <div>
            <Navbar></Navbar>
        </div>
        <img src={eogo} alt="eogo" className="eogo"></img>
        </div>
    )

}

export default Home
//dummy component