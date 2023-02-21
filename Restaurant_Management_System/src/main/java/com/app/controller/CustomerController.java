package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.Customer;
import com.app.services.CustomerServiceif;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceif custService;

	@PostMapping("/login")
	public Customer validateLogin(@RequestBody LoginDTO logindtls) throws CustomException {
		return custService.validateLogin(logindtls);
	}

	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer cust) {
		return custService.registerCust(cust);

	}

}
