import React, { useEffect } from "react";

var HistoryItem=(props)=>{
var render=(data)=>{
    return(
     
        <p class="card-text"> Dish ::{data.mname}  <br/>  Hotel Name :: {data.hotel.hname}</p>
    )
}



    return(
        <div>
      <div class="container-fluid " style={{    "padding-top": "25px"}}>
      <div class="card bg-secondary"  >
      <div class="row">
      
        <div class="col-sm-12">
      <div class="card-body">
        <small>date of order :: {props.item.dateOfPlacement}</small><br/>
        <h5 class="card-title">Total Price ::{props.item.price}   {props.item.orderStatus=="PENDING"?<span style={{"color":"red"}}>Order Status :: Preparing</span>:<span style={{"color":"green"}}>Order Status :: Prepared</span>} {props.item.deliveryStatus=="PENDING"?<span style={{"color":"red"}}>delivery Status :: Pending</span>:<span style={{"color":"green"}}>delivery Status :: Completed</span>}  </h5>
         {props.item.menuList.map((data)=>render(data))}
           </div>
           </div>
    
        </div>
      </div>
    </div>
    </div>
    );
    

}


export default HistoryItem;