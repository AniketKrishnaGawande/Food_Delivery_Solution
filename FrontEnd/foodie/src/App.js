// import logo from './logo.svg';
// import './App.css';
import Title from "./Components/Header";
import Login from "./Components/Authentication/Login";
import { Routes,Route } from "react-router-dom";
import CustomerRegister from './Components/Authentication/CustomerRegister';
import DeliveryBoyRegister from './Components/Authentication/DeliveryBoyRegister';
import HotelierRegister from './Components/Authentication/HotelierRegistration';
import Dummy from './Components/Admin/Dummy';
<<<<<<< HEAD
import CustomerHome from "./Components/Customer/js_file/Home";
import Home from "./Components/Admin/Home";
import Hotelier from "./Components/Admin/Hotelier";
import DeliveryBoy from "./Components/Admin/DeliveryBoy";
=======
import CustomerHome from "./Components/Customer/js_file/CustomerHome";
import Menu from "./Components/Customer/js_file/Menu";

>>>>>>> d35de0dc9c7db470c0ed3057f416ce74f061a39b
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
<<<<<<< HEAD
      <Route exact path="/customer/home" element={<CustomerHome></CustomerHome>}/>
      <Route exact path='/admin/home/hotelier' element={<Hotelier/>}/>
      <Route exact path='/admin/home/deliveryBoy' element={<DeliveryBoy/>}/>
      
      
=======
      <Route path="/customer"  element={<CustomerHome></CustomerHome>}/>
      <Route path="/customer/menu" element={<Menu></Menu>} ></Route>
>>>>>>> d35de0dc9c7db470c0ed3057f416ce74f061a39b
      </Routes>
    </div>
  );
  
  
}

export default App;
