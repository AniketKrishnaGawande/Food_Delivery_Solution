import React, { useEffect } from "react";
import axios from "axios";

const Menu=()=>{

useEffect(()=>{

axios.get("http://localhost:8080/hotelMenu/getAllHotelMenus'").then((result)=>{
alert(result);
}).catch((err)=>{
alert(err);
});
},[]);



return(<div>
abc

</div>);

}
export default Menu;