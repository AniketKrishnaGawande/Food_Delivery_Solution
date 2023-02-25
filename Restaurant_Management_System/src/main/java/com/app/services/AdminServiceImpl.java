package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.Admin;
import com.app.repositories.AdminRepository;
@Service
@Transactional
public class AdminServiceImpl implements AdminServiceIf {

	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public Admin validateLogin(LoginDTO details) throws CustomException {
		// TODO Auto-generated method stub
		return adminRepo.findByEmailAndPassword(details.getEmail(),details.getPassword()).orElseThrow(()-> new CustomException("Invalid Login"));
	}

	@Override
	public Admin registerAdmin(Admin admin) {
		
		return adminRepo.save(admin);
	}

}
