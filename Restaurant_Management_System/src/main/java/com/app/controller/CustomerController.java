package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerRegistrationDTO;
import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.Customer;
import com.app.services.CustomerServiceif;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	private CustomerServiceif custService;

	@PostMapping("/customerLogin")
	public Customer validateLogin(@RequestBody LoginDTO logindtls) throws CustomException {
		return custService.validateLogin(logindtls);
	}

	@PostMapping("/customerRegister")
	public Customer registerCustomer(@RequestBody CustomerRegistrationDTO cust) {
		return custService.registerCust(new Customer(cust.getAddress(), cust.getFirstName(), cust.getLastName(),
				cust.getPassword(), cust.getEmail()));

	}
	
	
	

}
