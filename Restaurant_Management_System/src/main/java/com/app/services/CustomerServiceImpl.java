package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.LoginDTO;
import com.app.pojos.Customer;
import com.app.repositories.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerServiceif {
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public Customer validateLogin(LoginDTO dtls) {

		custRepo.findByEmailAndPassword(dtls.getEmail(), dtls.getPassword());
		return null;

	}

}
