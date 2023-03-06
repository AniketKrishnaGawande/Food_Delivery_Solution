// import logo from './logo.svg';
// import './App.css';
import Title from "./Components/Header";
import Login from "./Components/Authentication/Login";
import { Routes,Route } from "react-router-dom";
import CustomerRegister from './Components/Authentication/CustomerRegister';
import DeliveryBoyRegister from './Components/Authentication/DeliveryBoyRegister';
import HotelierRegister from './Components/Authentication/HotelierRegistration';
import Dummy from './Components/Admin/Dummy';
import Home from "./Components/Admin/Home";
import Hotelier from "./Components/Admin/Hotelier";
import DeliveryBoy from "./Components/Admin/DeliveryBoy";

import CustomerHome from "./Components/Customer/js_file/CustomerHome";
import Menu from "./Components/Customer/js_file/Menu";
import CustomerCart from "./Components/Customer/js_file/CustomerCart";
import CustomerHistory from "./Components/Customer/js_file/CustomerHistory";
import HotelHome from './Components/Hotelier/HotelierHome';
import Order from "./Components/Hotelier/OrderStatus";
import HotelMenus from "./Components/Hotelier/HotelMenus";
import Addmenu from "./Components/Hotelier/Addmenu";
import DeliveryHome from './Components/DeliveryBoy/DeliveryBoyHome';
import DeliveryDetails from "./Components/DeliveryBoy/DeliveryDetails";

import CustomerProfile from "./Components/Customer/js_file/CustomerProfile";


function App() {
  return(
    <div className="App">

      <div className="MainHeader">
      <Title className="Title"></Title>
      </div>
      {/* <div className="Login">
      <Login></Login>
      </div> */}
      <Routes>
      <Route exact path="/" element={<Login/>} />
     
     //Register Link
      <Route exact path="/Customerregister" element={<CustomerRegister/>}/>
      <Route exact path="/DeliveryBoyregister" element={<DeliveryBoyRegister/>}/>
      <Route exact path="/Hotelierregister" element={<HotelierRegister/>}/>


    //Admin 
      <Route exact path="/admin/home/*" element={<Home></Home>}/>
      <Route exact path='/admin/home/hotelier' element={<Hotelier/>}/>
      <Route exact path='/admin/home/deliveryBoy' element={<DeliveryBoy/>}/>
      
      /Customer
      <Route path="/customer"  element={<CustomerHome></CustomerHome>}/>
      <Route path="/customer/menu" element={<Menu></Menu>} ></Route>
      <Route path="/customer/cart" element={<CustomerCart></CustomerCart>} ></Route>
      <Route path="/customer/history" element={<CustomerHistory></CustomerHistory>} ></Route>
      <Route path="/customer/profile" element={<CustomerProfile></CustomerProfile>} ></Route>

      //Hotelier
      <Route exact path="/hotelier/home" element={<HotelHome/>}/>
      <Route exact path="/hotelier/home/OrderStatus" element={<Order/>}/>
      <Route exact path="/hotelier/home/hotelMenus" element={<HotelMenus></HotelMenus>}/>
      <Route exact path="hotelier/home/addMenu" element={<Addmenu></Addmenu>}/>

      //Delivery Boy
      <Route exact path="/delivery/home" element={<DeliveryHome/>}/>
      <Route exact path="/delivery/home/details" element={<DeliveryDetails></DeliveryDetails>}/>

      <Route exact path="/dummy" element={<Dummy></Dummy>}/>
      <Route exact path="/customer/home" element={<CustomerHome></CustomerHome>}/>
      
      </Routes>
    </div>
  );
  
  
}

export default App;
