import React from "react";
import Header from "./subComponents/Header";
const CustomerProfile=()=>{

return(
<div >
    <Header></Header>
<div class="card"  style={{"height":"60%","width":"50%",alignItems:"center",alignItems:"center"}}>
  <div class="card-body">
    <h3 class="card-title">PROFILE :: </h3>
    <h4 class="card-title">Name :: {JSON.parse(localStorage.customer).firstName +" "+ JSON.parse(localStorage.customer).lastName}</h4>
    <p class="card-text">Email id :: {JSON.parse(localStorage.customer).email}</p>
    <p class="card-text">Address :: {JSON.parse(localStorage.customer).address}</p>  
  </div>
</div>
</div>

);

}

export default CustomerProfile;