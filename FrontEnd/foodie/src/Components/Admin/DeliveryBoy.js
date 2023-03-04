import React from "react";
import Navbar from "./Navbar";
import { useState,useEffect } from "react";
import  axios from 'axios';
const DeliveryBoy=()=>
{

    const[BoyDetails,setBoyDetails]=useState([]);

    useEffect(()=>
    {
        axios.get("http://localhost:8080/deliveryBoy/getDeliveryBoy").then
        (response=>{setBoyDetails(response.data);console.log(response.data)})
    },[]);

    var InsertData=BoyDetails.map(boy=>
        {
            return(
                <tr>
                <td>{boy.id}</td>
                    <td>{boy.firstName}</td>
                    <td>{boy.email}</td>
                    <td>{boy.status}</td>
                    <td>{boy.approvedStatus}</td>

                    <button type="submit" name="btn" id="btn" class="btn btn-warning" onClick={()=>deleteRecord(boy.id)}>Remove DeliveryBoy</button>

                    <button type="submit" name="btn" id="btn" class="btn btn-warning" onClick={()=>updateStatus(boy.id)}>Update Status</button>
                </tr>
            )
        });

        var deleteRecord=(id)=>
        {
            console.log(id)
            return(
                
            axios.delete(`http://localhost:8080/deliveryBoy/delete/${id}`).then(response=>
            {
                window.location.reload(false);
                // alert(response)
            })
            .catch(error=>
                {
                    alert(error)
                })
            )
        }

        var updateStatus=(id)=>
        {
            return(
            axios.put(`http://localhost:8080/deliveryBoy/approvedStatus/${id}`).then(response=>
            {
                // alert(response.data)
                window.location.reload(false);
            })
            .catch(error=>
                {
                    alert(error)
                })
            )
        }

    return(
        <div>
             <Navbar></Navbar>

             <table className="table table-success table-stripedr  table-bordered">
                <thead>
                    <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Delivery Status</th>
                    <th scope="col">Approved Status</th>  
                    </tr>
                </thead>
                {InsertData}
            </table>
        </div>
    )
}
export default DeliveryBoy