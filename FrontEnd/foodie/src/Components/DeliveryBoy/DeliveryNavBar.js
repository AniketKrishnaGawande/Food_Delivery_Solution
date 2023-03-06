import React from "react";
import { useNavigate } from "react-router-dom";
const DeliveryNav=()=>
{
    var navigate=useNavigate()
    const displayName = () => {
        const obj = JSON.parse(localStorage.getItem("delivery")).firstName
        return obj
    }
    const logout=()=>
    {
        localStorage.removeItem("delivery")
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
                            <a className="nav-link" href="/delivery/home/details">Order Details</a>
                        </li>

                        <button class="btn btn-warning" onClick={logout}> Logout</button>
                    </ul>
                </div>
            </nav>
        </div>
    )

}
export default DeliveryNav