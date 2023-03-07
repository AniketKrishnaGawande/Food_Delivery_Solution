import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Header from "./subComponents/Header";
import HistoryItem from "./subComponents/HistoryItem";


function CustomerHistory(){
const nav =useNavigate();
  var [history,SetHistory]=useState(

    {id: 0, historyItems: [{id: 0,
        dateOfPlacement: "",
        price: 0,
        orderStatus: "",
        deliveryStatus: "",
        menuList: [
          {
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
          }
        ]
      }
    ]
  }
)


useEffect(()=>{

  if(!localStorage.customer)
  {nav("/")}


    var id = JSON.parse(localStorage.customer).id;
    axios.get(`http://localhost:8080/order/getAllOrders/${id}`).then((result)=>{
   var obj =result.data;
      SetHistory({...obj})
}).catch((err)=>{
alert(err);
});
},[])




var render=()=>history.historyItems.map((data)=>data.id==0?<div></div>:<HistoryItem  item={data}></HistoryItem>)



return(<div>
<Header></Header>

{history.historyItems.length==0?<h3 style={{"text-align":"center"}} > you dont have order any history</h3>: <div>
    
    
    
    {render()}
    
    
    </div>}

</div>);
}

export default CustomerHistory;