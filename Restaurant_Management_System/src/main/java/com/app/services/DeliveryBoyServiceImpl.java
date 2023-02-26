package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.DBoyRegisterDTO;
import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.DeliveryBoy;
import com.app.repositories.DeliveryBoyRepository;
@Service
@Transactional
public class DeliveryBoyServiceImpl implements DeliveryBoyServiceif {
	
	@Autowired
	private DeliveryBoyRepository deliveryRepo;

	//Get Delivery Boy Details
	@Override
	public List<DeliveryBoy> getAllDeliveryBoy() {
		
		return deliveryRepo.findAll();
	}

	//Register Delivery Boy
	@Override
	public String registerDeliveryBoy(DBoyRegisterDTO boy) {
		if(boy!=null)
		{
			DeliveryBoy dBoy=new DeliveryBoy(boy.getFirstName(),boy.getLastName(),boy.getEmail(),boy.getPassword());
			deliveryRepo.save(dBoy);
			return "Register Succesfully";
		}
		return "Enter valid Details";
	}

	//Delete Record of Delivery Boy by Id
	@Override
	public String deleteDeliveryBoy(long id) {
		if(deliveryRepo.existsById(id))
		{
			deliveryRepo.deleteById(id);
			return "Delivery Boy Record deleted successfully";
		}
		return "Enter valid Id";
	}

	//Login Delivery Boy
	@Override
	public DeliveryBoy validateLogin(LoginDTO details) throws CustomException {
		// TODO Auto-generated method stub
		return deliveryRepo.findByEmailAndPassword(details.getEmail(),details.getPassword()).orElseThrow(()->new CustomException("Invalid Credentials"));
	}

	
}
