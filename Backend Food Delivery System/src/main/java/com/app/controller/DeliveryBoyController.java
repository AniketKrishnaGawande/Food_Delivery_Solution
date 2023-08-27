package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DBoyRegisterDTO;
import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.DeliveryBoy;
import com.app.services.DeliveryBoyServiceif;

@RestController
@RequestMapping("/deliveryBoy")
@CrossOrigin(origins = "http://localhost:3000")
public class DeliveryBoyController {

	@Autowired 
	private DeliveryBoyServiceif deliveryService;
	
	@GetMapping("/getDeliveryBoy")
	public List<DeliveryBoy> getAllDeliveryBoys() {

		List<DeliveryBoy> list = deliveryService.getAllDeliveryBoy();
		return list;
	}
	
	@PostMapping("/registerDeliveryBoy")
	public String addDeliveryBoy(@RequestBody DBoyRegisterDTO boy)
	{
		return deliveryService.registerDeliveryBoy(boy);
	}
	
	@PostMapping("/login")
	public DeliveryBoy validateLogin(@RequestBody LoginDTO loginDetails)throws CustomException
	{
		return deliveryService.validateLogin(loginDetails);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDeliveryBoyById(@PathVariable Long id)
	{
		return deliveryService.deleteDeliveryBoy(id);
	}
	
	@PutMapping("/approvedStatus/{id}")
	public String approveDeliveryBoyStatus(@PathVariable Long id)
	{
		return deliveryService.approveStatus(id);
	}
}
