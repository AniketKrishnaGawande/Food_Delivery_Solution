package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AdminRegistrationDTO;
import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.Admin;
import com.app.services.AdminServiceIf;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	@Autowired
	private AdminServiceIf adminService;
	
	@PostMapping("/adminLogin")
	public Admin validateLogin(@RequestBody LoginDTO loginDetails )throws CustomException
	{
	return adminService.validateLogin(loginDetails);	
	}
	
	@PostMapping("/adminRegister")
	public Admin registerLogin(@RequestBody AdminRegistrationDTO admin)
	{
		return adminService.registerAdmin(new Admin(admin.getAddress(),admin.getFirstName(),admin.getLastName(),
				admin.getPassword(),admin.getEmail()));
	}

}
