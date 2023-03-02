import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
function Home()
{   
    const navigate=useNavigate()
    const logout=()=>
    {
        localStorage.removeItem("item")
        
    }
    const redirect=()=>
    {
       
        if(localStorage.getItem("item"))
         {
            navigate('/dummy')
         }
         else{
            navigate('/')
         }
    }
    const displayName=()=>
    {
        const obj=JSON.parse(localStorage.getItem("item")).firstName 
        return obj
    }
    return(
        <div>
            <h2>{displayName()}</h2>
            <h1>Welcome to Login Page</h1>
            <a href='/'><button onClick={logout}>logout</button></a>
            <button onClick={redirect}>redirect</button>
        </div>
    )

}

export default Home
//dummy component