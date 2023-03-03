package com.app.services;

import java.util.List;

import com.app.dto.DBoyRegisterDTO;
import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.DeliveryBoy;
import com.app.pojos.HistoryItems;

public interface DeliveryBoyServiceif {
	
	//Get Delivery Boy Details
	List<DeliveryBoy> getAllDeliveryBoy();
	
	//Register Delivery Boy
	public String registerDeliveryBoy(DBoyRegisterDTO boy);
	
	//Delete Record of Delivery Boy by Id
	public String deleteDeliveryBoy(long id);
	
	//Login Delivery Boy
	public DeliveryBoy validateLogin(LoginDTO details)throws CustomException;
	
	public DeliveryBoy assignOrder(HistoryItems item);
	public void completeDeliveryStatus(DeliveryBoy dBoy);

}
