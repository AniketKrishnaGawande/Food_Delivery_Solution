import React from "react";
import Order from './OrderStatus';
import axios from "axios";
function OrderStatusRender(props){

    var changeStatus=(id)=>
    {
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


const render =()=>props.order.historyItems.map((data)=>{
  return (
    <div>
 <h4 class="card-title">Dish ::{data.menuList.map((data1)=>
            {
                return data1.mname
            })   }
        </h4>
        <p class="card-text"> Order Status ::{data.orderStatus}</p>
        <p class="card-text"> Delivery Status ::{data.deliveryStatus}</p>
        <p class="card-text"> Price ::{data.price}</p>
        <p class="card-text"> Price ::{data.dateOfPlacement}</p>
        <button class="btn btn-success" onClick={()=>{changeStatus(data.id)}}>Change Status</button>
    </div>
  );
})


    return(
        <div>
    
    <div></div>
      <div class="container-fluid " style={{    "padding-top": "25px"}}>
      <div class="card bg-secondary"  >
      <div class="row">
      
        <div class="col-sm-6 ">
      <div class="card-body">
        
        {render()}
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