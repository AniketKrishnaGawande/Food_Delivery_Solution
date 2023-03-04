import React, { useEffect, useState } from "react";
import axios from "axios";
import MenuItem from "./subComponents/MenuItem";
import Header from "./subComponents/Header";

const Menu=()=>{
var obj;
    var [menuArray,setMenuArray]= useState([]);
useEffect(()=>{

axios.get("http://localhost:8080/hotelMenu/getAllHotelMenus").then((result)=>{
        setMenuArray(result.data)
}).catch((err)=>{
alert(err);
});
},[]);

const menuList=()=>menuArray.map((menu, index)=>{return <MenuItem menuItem={menu}></MenuItem>});

return(<div>
<Header></Header>
<h3 style={{"text-align":"center"}} > Hotel Menu</h3>
    {menuList()}
</div>);

}
export default Menu;