import React from "react";
import axios from "axios";
const DeliveryRender = (props) => {

    var changeStatus=()=>
    {
        var id=props.delivery.id
        console.log(id)
        axios.post(`http://localhost:8080/changeStatus/dboy/${id}`).then((response)=>
        {
            console.log(response.data)
            window.location.reload(false)
        }).catch((error)=>
        {
            console.log(error)
        })
        
    }
    return (
        <div>
            <div></div>
            <div class="container-fluid " style={{ "padding-top": "25px" }}>
                <div class="card bg-secondary"  >
                    <div class="row">

                        <div class="col-sm-6 ">
                            <div class="card-body">
                                <h4 class="card-title">Order Name ::{props.delivery.menuList.map((data) => {
                                    return data.mname
                                })}
                                </h4>

                                <p class="card-text"> Order Received  ::{props.delivery.dateOfPlacement}
                                </p>

                                <p class="card-text"> Price ::{props.delivery.price}
                                </p>

                                <p class="card-text"> Delivery Status ::{props.delivery.deliveryStatus}
                                </p>

                                <p class="card-text"> Hotel Name ::{props.delivery.menuList.map((data) => {
                                    return data.hotel.hname})}
                                </p>

                                <p class="card-text"> Enquiry Email ::{props.delivery.menuList.map((data) => {
                                    return data.hotel.email})}
                                </p>
                                
                                 <p class="card-text"> Hotel Address ::{props.delivery.menuList.map((data) => {
                                    return data.hotel.haddress})}
                                </p> 

                               
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
    )
}
export default DeliveryRender