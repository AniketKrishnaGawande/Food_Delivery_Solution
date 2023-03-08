import axios from "axios";
import React, { useEffect, useState } from "react";
import Header from "./subComponents/Header";
import CartItem from "./subComponents/CartItem";
import { useNavigate } from "react-router-dom";


function CustomerCart(){
    var [flag,setFlag]=useState(false);

var [obj,setObj]=useState({
    id: 0,
    cartTotalPrice: 0,
    cartItem: [
      {
        id: 0,
        quantity: 0,
        menu: {
          id: 0,
          description: "",
          menu: "",
          hotel: {
            id: 0,
            rating: 0,
            status: "",
            email: "",
            hname: "",
            haddress: ""
          },
          mprice: 0,
          mname: ""
        },
        price: 0
      }
    ]
  });




var nav=useNavigate();   
useEffect(()=>{

  if(!localStorage.customer)
  {nav("/")}


var id = JSON.parse(localStorage.customer).id;
axios.get(`http://localhost:8080/foodCart/${id}`).then((result)=>{
localStorage.cart= JSON.stringify (result.data);
var obj1=result.data;

setObj({...obj1});
console.log(obj1);

setFlag(!flag);
}).catch((err)=>{
    alert(err);
})

},[]);


var checkOut=()=>{

        var custId=JSON.parse(localStorage.customer).id;
        axios.post(`http://localhost:8080/order/placedOrder/${custId}`).then((result)=>{
            alert("successfully checked out");
            nav("/customer")
        }).catch((err)=>{
            alert("error occured")
        })

}
var refresh=(data)=>{
    setFlag(data);
}


var cartRender=()=>obj.cartItem.map((data)=><CartItem flag2={flag} chgFlag={refresh} cart={data} ></CartItem>)



    return(
<div>
<Header/>
<h3 style={{"text-align":"center"}} > Cart</h3>
{obj.cartTotalPrice==0?<h3 style={{"text-align":"center"}} > No item in Cart</h3>: <div><div className="p-2"><h3>Total Price :: {obj.cartTotalPrice}</h3><button  onClick={()=>{checkOut()}}   className="btn btn-success">check out</button> </div>{cartRender()}</div>}
</div>
);
}

export default CustomerCart;