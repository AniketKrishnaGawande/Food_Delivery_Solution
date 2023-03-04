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
      <Route exact path="/admin/home/*" element={<Home></Home>}/>
      <Route exact path="/Customerregister" element={<CustomerRegister/>}/>
      <Route exact path="/DeliveryBoyregister" element={<DeliveryBoyRegister/>}/>
      <Route exact path="/Hotelierregister" element={<HotelierRegister/>}/>
      <Route exact path="/dummy" element={<Dummy></Dummy>}/>
      <Route exact path="/customer/home" element={<CustomerHome></CustomerHome>}/>
      <Route exact path='/admin/home/hotelier' element={<Hotelier/>}/>
      <Route exact path='/admin/home/deliveryBoy' element={<DeliveryBoy/>}/>
      
      
      <Route path="/customer"  element={<CustomerHome></CustomerHome>}/>
      <Route path="/customer/menu" element={<Menu></Menu>} ></Route>
      <Route path="/customer/cart" element={<CustomerCart></CustomerCart>} ></Route>
      <Route path="/customer/history" element={<CustomerHistory></CustomerHistory>} ></Route>




      
      </Routes>
    </div>
  );
  
  
}

export default App;
