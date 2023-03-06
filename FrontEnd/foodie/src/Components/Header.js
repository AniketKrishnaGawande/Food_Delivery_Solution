import React from 'react'
import './Header.css';
import img from "./Images/head.PNG";


function Title()
{
    return(
        // <div className='font-link' style={{backgroundImage:{img}}}>
        //     <h1>Foodie</h1>
        //     <i>directly to ur doorstep</i>
        // </div>

        <div class="card" style={{"width":"100%","height":"200px"}}>
  <img class="card-img-top" src={img} alt="Card image" style={{"width":"100%","height":"200px"}}/>
  <div class="card-img-overlay">
    <h1 class="card-title"  style={{color:"white"}}>Foodie</h1>
    <i class="card-text" style={{color:"white"}} >directly to ur doorstep</i>
  </div>
</div>
    )
}
export default Title