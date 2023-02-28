// import logo from './logo.svg';
// import './App.css';
import Title from "./Components/Header";
import Login from "./Components/Login";
import { Routes,Route } from "react-router-dom";
import Home from './Components/Home';
import AdminRegister from './Components/CustomerRegister';
import DeliveryBoyRegister from './Components/DeliveryBoyRegister';
import HotelierRegister from './Components/HotelierRegistration';

function App() {
  return(
    <div className="App">

      <div className="Header">
      <Title className="Title"></Title>
      </div>
      {/* <div className="Login">
      <Login></Login>
      </div> */}

      
      <Routes>
      <Route exact path="/" element={<Login/>} />
      <Route exact path="/home" element={<Home/>}/>
      <Route exact path="/Customerregister" element={<AdminRegister/>}/>
      <Route exact path="/DeliveryBoyregister" element={<DeliveryBoyRegister/>}/>
      <Route exact path="/Hotelierregister" element={<HotelierRegister/>}/>
      </Routes>

    </div>

  );
  
  
}

export default App;
