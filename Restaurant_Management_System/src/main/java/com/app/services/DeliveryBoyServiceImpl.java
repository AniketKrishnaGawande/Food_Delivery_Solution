package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.DBoyRegisterDTO;
import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.DeliveryBoy;
import com.app.pojos.DeliveryBoyAcceptStatus;
import com.app.pojos.HistoryItems;
import com.app.pojos.OrderStatus;
import com.app.repositories.DeliveryBoyRepository;

@Service
@Transactional
public class DeliveryBoyServiceImpl implements DeliveryBoyServiceif {

	@Autowired
	private DeliveryBoyRepository deliveryRepo;

	// Get Delivery Boy Details
	@Override
	public List<DeliveryBoy> getAllDeliveryBoy() {

		return deliveryRepo.findAll();
	}

	@Override
	public DeliveryBoy assignOrder(HistoryItems item) {

		DeliveryBoy dBoy = deliveryRepo.findByStatusAndApprovedStatus(OrderStatus.NOT_ASSIGN,true).orElseThrow();
		dBoy.setOrder(item);
		dBoy.setStatus(OrderStatus.ASSIGNED);
		return deliveryRepo.save(dBoy);
	}

	// Register Delivery Boy
	@Override
	public String registerDeliveryBoy(DBoyRegisterDTO boy) {
		if (boy != null) {
			DeliveryBoy dBoy = new DeliveryBoy(boy.getFirstName(), boy.getLastName(), boy.getEmail(),
					boy.getPassword());
			deliveryRepo.save(dBoy);
			return "Register Succesfully";
		}
		return "Enter valid Details";
	}

	// Delete Record of Delivery Boy by Id
	@Override
	public String deleteDeliveryBoy(long id) {
		if (deliveryRepo.existsById(id)) {
			deliveryRepo.deleteById(id);
			return "Delivery Boy Record deleted successfully";
		}
		return "Enter valid Id";
	}

	// Login Delivery Boy
	@Override
	public DeliveryBoy validateLogin(LoginDTO details) throws CustomException {
		// TODO Auto-generated method stub
		return deliveryRepo.findByEmailAndPassword(details.getEmail(), details.getPassword())
				.orElseThrow(() -> new CustomException("Invalid Credentials"));
	}

	public void completeDeliveryStatus(DeliveryBoy dBoy) {

		dBoy.setStatus(OrderStatus.NOT_ASSIGN);
		deliveryRepo.save(dBoy);
	}

	@Override
	public String approveStatus(long id) {
		if(deliveryRepo.existsById(id))
		{
			deliveryRepo.findById(id).orElseThrow().setApprovedStatus(DeliveryBoyAcceptStatus.APPROVED);
			return "Approved";
		}
		return "Enter valid Delivery Boy Id";
	}

}
