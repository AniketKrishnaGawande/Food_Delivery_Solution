package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DBoyRegisterDTO;
import com.app.pojos.DeliveryBoy;
import com.app.services.DeliveryBoyServiceif;

@RestController
@RequestMapping("/DeliveryBoy")
public class DeliveryBoyController {

	@Autowired 
	private DeliveryBoyServiceif deliveryService;
	
	@GetMapping("/getDeliveryBoy")
	public List<DeliveryBoy> getAllDeliveryBoys() {

		List<DeliveryBoy> list = deliveryService.getAllDeliveryBoy();
		
		return list;
	}
	
	@PostMapping("/RegisterDeliveryBoy")
	public String addDeliveryBoy(@RequestBody DBoyRegisterDTO boy)
	{
		return deliveryService.registerDeliveryBoy(boy);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDeliveryBoyById(@PathVariable Long id)
	{
		return deliveryService.deleteDeliveryBoy(id);
	}
	
}
