package com.app.services;

import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.Admin;

public interface AdminServiceIf {
	
	// Admin Login 
	public Admin validateLogin(LoginDTO details) throws CustomException;
	
	// Register Admin
	public Admin registerAdmin(Admin admin);

}
