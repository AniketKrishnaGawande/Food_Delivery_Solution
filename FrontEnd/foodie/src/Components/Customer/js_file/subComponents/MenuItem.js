import axios from "axios";
import React from "react";

function MenuItem(props){



const addToCart=(menuId)=>{

var custId=JSON.parse(localStorage.customer).id;
axios.post(`http://localhost:8080/foodCard/add/${custId}/${menuId}`).then((result)=>{
    alert("added")
}).catch((err)=>{
    alert("not added")
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
    <h4 class="card-title">Dish ::{props.menuItem.mname}</h4>
    <p class="card-text"> Description ::{props.menuItem.description}</p>
    <p class="card-text"> {props.menuItem.menu}</p>
    <p class="card-text"> Price :: {props.menuItem.mprice}</p>
   <button onClick={()=>addToCart(props.menuItem.id)}>Add to Cart</button> 

       </div>
    </div>
    <div class="col-sm-6">
  <div class="card-body">
    <h6 class="card-text">Hotel :: {props.menuItem.hotel.hname}</h6>
    <p class="card-text">Address :: {props.menuItem.hotel.haddress}</p>
    <p class="card-text">Ratings ::  {props.menuItem.menu}</p>
  </div>
</div>

    </div>
  </div>
</div>
    </div>
);

}

export default MenuItem;