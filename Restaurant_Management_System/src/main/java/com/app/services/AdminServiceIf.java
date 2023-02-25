package com.app.services;

import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.Admin;

public interface AdminServiceIf {
	
	public Admin validateLogin(LoginDTO details) throws CustomException;
	
	public Admin registerAdmin(Admin admin);

}
