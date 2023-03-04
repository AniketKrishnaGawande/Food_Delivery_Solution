import React from "react";
import { useNavigate } from "react-router-dom";
const Navbar=()=>
{
    const navigate=useNavigate()

    const displayName = () => {
        const obj = JSON.parse(localStorage.getItem("admin")).firstName
        return obj
    }
    const logout=()=>
    {
        localStorage.removeItem("admin")
        navigate("/")
        
    }
    return(
        
        <div>
            {/* <a href='/'><button onClick={logout}>logout</button></a> */}
            {/* <button onClick={redirect}>redirect</button> */}
            <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
                <div className="container-fluid">
                    <ul className="navbar-nav ">
                        <li className="nav-item">
                            <a className="nav-link active" href="#">[Welcome  &nbsp; &nbsp;{displayName()}]</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/admin/home/hotelier">Hotelier</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="/admin/home/deliveryBoy">Delivery-Boy</a>
                        </li>
                        {/* <li className="nav-item">
                            <a className="nav-link disabled" href="#">Disabled</a>
                        </li> */}

                        <button class="btn btn-warning" onClick={logout}> Logout</button>
                    </ul>
                </div>
            </nav>
        </div>
    )
}
export default Navbar;