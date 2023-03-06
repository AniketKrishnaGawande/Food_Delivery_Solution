import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function CartItem(props){

var nav=useNavigate();
     function remove(){
        var custId=JSON.parse(localStorage.customer).id;
        axios.delete(`http://localhost:8080/CartItem/${custId}/${props.cart.id}`).then((result)=>{
            alert("Item removed from cart");
         props.chgFlag(!props.flag2)
      window.location.reload(false)
            nav("/customer/cart")            
        }).catch((err)=>{
            alert("not removed")
        })

     }

return(
    <div>

<div></div>
  <div class="container-fluid " style={{    "padding-top": "25px"}}>
  <div class="card bg-secondary"  >
  <div class="row">
  
    <div class="col-sm-6 ">
  <div class="card-body">
    <h4 class="card-title">Dish ::{props.cart.menu.mname}</h4>
    <p class="card-text"> Quantity ::{props.cart.quantity}</p>
    <p class="card-text"> Price :: {props.cart.menu.mprice}</p>
       </div>
    </div>
    <div class="col-sm-6">
  <div class="card-body">
    <h6 class="card-text">Hotel :: {props.cart.menu.hotel.hname}</h6>
    <button onClick={()=>remove()} className="btn btn-danger">Remove from cart</button>
  </div>
</div>

    </div>
  </div>
</div>
</div>
);

}

export default CartItem;