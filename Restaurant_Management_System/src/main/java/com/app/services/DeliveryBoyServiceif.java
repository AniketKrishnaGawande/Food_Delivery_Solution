package com.app.services;

import java.util.List;

import com.app.dto.DBoyRegisterDTO;
import com.app.pojos.DeliveryBoy;

public interface DeliveryBoyServiceif {
	
	List<DeliveryBoy> getAllDeliveryBoy();
	
	public String registerDeliveryBoy(DBoyRegisterDTO boy);
	
	public String deleteDeliveryBoy(long id);
	
	//login

}
