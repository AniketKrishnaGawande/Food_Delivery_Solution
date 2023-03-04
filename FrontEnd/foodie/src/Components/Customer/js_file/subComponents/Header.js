import React from "react";
import logo from "../../images/img_avatar1.png"
import "../../css_file/header.css"
const Header=function(props){
return(
    <div>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid col">
  <img src={logo} alt="Logo" style={{"width":"40px", "float":"left"}} class="rounded-pill" />

      {JSON.parse(localStorage.customer).firstName+" "+JSON.parse(localStorage.customer).lastName}
            <ul class="navbar-nav">
     <li class="nav-item">
        <a class="nav-link" href="/customer/menu">Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/customer/cart">Cart</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/customer/history">history</a>
      </li>
    </ul>
    </div>
 </nav>
          
</div>
);
}
export default Header;