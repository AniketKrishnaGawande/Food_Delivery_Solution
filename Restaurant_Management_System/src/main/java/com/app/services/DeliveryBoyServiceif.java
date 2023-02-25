package com.app.services;

import java.util.List;

import com.app.dto.DBoyRegisterDTO;
import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.DeliveryBoy;

public interface DeliveryBoyServiceif {
	
	List<DeliveryBoy> getAllDeliveryBoy();
	
	public String registerDeliveryBoy(DBoyRegisterDTO boy);
	
	public String deleteDeliveryBoy(long id);
	
	public DeliveryBoy validateLogin(LoginDTO details)throws CustomException;

}
