import React from "react";
import { useNavigate } from "react-router-dom";
const HotelNavbar=()=>
{
    const navigate=useNavigate()

    const displayName = () => {
        const obj = JSON.parse(localStorage.getItem("hotelier")).hname
        return obj
    }
    const logout=()=>
    {
        localStorage.removeItem("hotelier")
        navigate("/")
        
    }
    return(
        
        <div>
            
            <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
                <div className="container-fluid">
                    <ul className="navbar-nav ">
                        <li className="nav-item">
                            <a className="nav-link active" href="#">[Welcome  &nbsp; &nbsp;{displayName()}]</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/hotelier/home/OrderStatus">Order Status</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/hotelier/home/hotelMenus">Hotel Menus</a>
                        </li>

                        <li className="nav-item">
                            <a className="nav-link" href="/hotelier/home/addMenu">Add Menu</a>
                        </li>
                       

                        <button class="btn btn-warning" onClick={logout}> Logout</button>
                    </ul>
                </div>
            </nav>
        </div>
    )
}
export default HotelNavbar;