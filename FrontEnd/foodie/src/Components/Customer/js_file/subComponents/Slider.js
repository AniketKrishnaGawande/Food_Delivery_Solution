import image1 from "../../images/menu-item-3.png"
import image2 from "../../images/menu-item-1.png"
import image3 from "../../images/menu-item-2.png"
import image4 from "../../images/menu-item-4.png"
import image5 from "../../images/menu-item-5.png"
import image6 from "../../images/menu-item-6.png"





import React from "react";
const Slider=()=>{
return(
<div >





  <div class="row">
    <div class="col-sm-6">
    <div id="demo" class="carousel slide" data-bs-ride="carousel" >

<div class="carousel-indicators">
  <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
  <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
  <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
</div>

<div class="carousel-inner">
  <div class="carousel-item active">
    <img src={image1} alt="Los Angeles" class="d-block" style={{"width":"100%","height":"50%"}}/>
  </div>
  <div class="carousel-item">
  <img src={image2} alt="Los Angeles" class="d-block" style={{"width":"100%","height":"50%"}}/>
  </div>
  <div class="carousel-item">
  <img src={image3} alt="Los Angeles" class="d-block" style={{"width":"100%","height":"50%"}}/>
  </div>
</div>

<button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
  <span class="carousel-control-prev-icon"></span>
</button>
<button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
  <span class="carousel-control-next-icon"></span>
</button>
</div>    
    </div>
    <div class="col-sm-6">

    <div class="card">
    <div class="card-body">
      <h4 class="card-title">Directly to your doorstep.</h4>
      <p class="card-text">Some example text. Some example text.</p>
    </div>
  </div>    


    </div>
  </div>











</div>

);

}
export default Slider;