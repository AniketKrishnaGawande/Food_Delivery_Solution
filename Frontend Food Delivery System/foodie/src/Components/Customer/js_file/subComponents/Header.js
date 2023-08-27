import React, { useEffect } from "react";
import logo from "../../images/img_avatar1.png"
import "../../css_file/header.css"
import { useNavigate } from "react-router-dom";
const Header=function(props){



  const nav=useNavigate();

useEffect(()=>{
  if(!localStorage.customer)
  {nav("/")}
},[])

const logOut=()=>{
localStorage.removeItem("customer");
alert("logged out successfully")
nav("/")
}

  return(
    <div>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid col">

    <a  href="/customer/profile">
  <img src={logo} alt="Logo" style={{"width":"40px", "float":"left"}} class="rounded-pill" />
  </a>
      {JSON.parse(localStorage.customer).firstName+" "+JSON.parse(localStorage.customer).lastName}
            <ul class="navbar-nav">
            <li class="nav-item">
        <a class="nav-link" href="/customer">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/customer/profile">Profile</a>
      </li>
     <li class="nav-item">
        <a class="nav-link" href="/customer/menu">Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/customer/cart">Cart</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/customer/history">history</a>
      </li>
      <li class="nav-item">
      <button type="button"   onClick={logOut} class="btn btn-warning">Log out</button>

      </li>

    </ul>
    </div>
 </nav>
          
</div>
);
}
export default Header;