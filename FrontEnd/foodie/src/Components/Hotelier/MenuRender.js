import React from "react";
import axios from "axios";
const MenuRender=(props)=>
{
    var deleteMenu=()=>
    {
        var id=props.menus.id
        console.log(id)
        axios.delete(`http://localhost:8080/hotelMenu/deleteHotelMenus/${id}`).then((response)=>
        {
            console.log(response.data)
            // window.location.reload(false)
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
        <h4 class="card-title">Category ::{props.menus.menu}
        </h4>
        <p class="card-text"> Taste ::{props.menus.description}</p>
        <p class="card-text"> Item ::{props.menus.mname}</p>
        <p class="card-text"> Price ::{props.menus.mprice}</p>

        <button class="btn btn-danger" onClick={deleteMenu}>Delete Menu</button>
        
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
export default MenuRender
