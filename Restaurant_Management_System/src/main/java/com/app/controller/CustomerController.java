package com.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDTO;
import com.app.pojos.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	
@PostMapping("/login")
public Customer validateLogin(@RequestBody LoginDTO logindtls) {
	
	
	
	
	return null;
	
}
	
	
	
	
	
}
