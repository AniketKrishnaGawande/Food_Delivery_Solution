import React from "react";
import Navbar from "./Navbar";
import { useState,useEffect } from "react";
import  axios from 'axios';
import { useNavigate } from "react-router-dom";
const Hotelier = () => {
    const navigate=useNavigate()
    const[HotelDetails,setHotelDetails]=useState([]);

    useEffect(()=>
        {
            axios.get("http://localhost:8080/hotels/getHotelDetails").then(response=>{setHotelDetails(response.data) ;console.log(response.data)});
            
        },[]);

    var InsertData=HotelDetails.map(hotels=>
        {
            return(
                <tr>
                    <td>{hotels.id}</td>
                    <td>{hotels.hname}</td>
                    <td>{hotels.email}</td>
                    <td>{hotels.haddress}</td>
                    <td>{hotels.rating}</td>
                    <td>{hotels.status}</td>
                 
                    <button type="submit" name="btn" id="btn" class="btn btn-warning" onClick={()=>deleteRecord(hotels.id)}>Remove Hotel</button>
                   
                    <button type="submit" name="btn" id="btn" class="btn btn-warning" onClick={()=>updateStatus(hotels.id)}>Update Status</button>
   
                </tr>
            )
        });
/*

                    get History By hotel Id
                    //Hotel menus By hotel Id remaining

                    //and Make Delivery Copmonent and GetOrdersBy delivery boy id remaming
                    //change delivery status in delivery compo
                    
*/
        var deleteRecord=(id)=>
        {
            console.log(id)
            return(
                
            axios.delete("http://localhost:8080/hotels/deleteHotel/"+id).then(response=>
            {
                window.location.reload(false);
                // alert(response)
            })
            .catch(error=>
                {
                    alert("Can not delete Hotelier Because It is associated with Certain Order")
                })
            )
        }

        var updateStatus=(id)=>
        {
            return(
            axios.put(`http://localhost:8080/hotels/approvedHotel/${id}`).then(response=>
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

        const redirect=()=>
        {
            navigate("/")
        }


    return (
        <div>
            <Navbar></Navbar>

            <table className="table table-success table-stripedr  table-bordered">
                <thead>
                    <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Hotel name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Rating</th>
                    <th scope="col">Status</th>
                    
                    </tr>
                </thead>
                {InsertData}
            </table>
        </div>
    )
}
export default Hotelier