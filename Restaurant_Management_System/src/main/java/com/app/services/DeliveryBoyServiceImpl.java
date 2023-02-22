package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.DBoyRegisterDTO;
import com.app.pojos.DeliveryBoy;
import com.app.repositories.DeliveryBoyRepository;
@Service
@Transactional
public class DeliveryBoyServiceImpl implements DeliveryBoyServiceif {
	
	@Autowired
	private DeliveryBoyRepository deliveryRepo;

	@Override
	public List<DeliveryBoy> getAllDeliveryBoy() {
		
		return deliveryRepo.findAll();
	}

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

	@Override
	public String deleteDeliveryBoy(long id) {
		if(deliveryRepo.existsById(id))
		{
			deliveryRepo.deleteById(id);
			return "Delivery Boy Record deleted successfully";
		}
		return "Enter valid Id";
	}

	//login
}
