import React from "react";
import Order from './OrderStatus';
import axios from "axios";
function OrderStatusRender(props){

    var changeStatus=()=>
    {
        var id=props.order.id
        console.log(id)
        axios.post(`http://localhost:8080/changeStatus/hotel/${id}`).then((response)=>
        {
            console.log(response.data)
            window.location.reload(false)
        }).catch((error)=>
        {
            console.log(error)
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
        <h4 class="card-title">Dish ::{props.order.historyItems.map((data)=>{return data.menuList.map((data1)=>
            {
                return data1.mname
            })   })}
        </h4>
        <p class="card-text"> Order Status ::{props.order.historyItems.map((data)=>{return data.orderStatus})}</p>
        <p class="card-text"> Delivery Status ::{props.order.historyItems.map((data)=>{return data.deliveryStatus})}</p>
        <p class="card-text"> Price ::{props.order.historyItems.map((data)=>{return data.price})}</p>
        <p class="card-text"> Price ::{props.order.historyItems.map((data)=>{return data.dateOfPlacement})}</p>
        <button class="btn btn-success" onClick={changeStatus}>Change Status</button>
           </div>
        </div>
        <div class="col-sm-6">
      <div class="card-body">
       
        
      </div>
    </div>
    
        </div>
      </div>
    </div>
    </div>
    );
    
}
export default OrderStatusRender