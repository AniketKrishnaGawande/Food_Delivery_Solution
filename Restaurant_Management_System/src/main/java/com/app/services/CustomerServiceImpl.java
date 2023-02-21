package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.Customer;
import com.app.repositories.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerServiceif {
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public Customer validateLogin(LoginDTO dtls) throws CustomException {

		return custRepo.findByEmailAndPassword(dtls.getEmail(), dtls.getPassword())
				.orElseThrow(() -> new CustomException("invalid details"));

	}

	@Override
	public Customer registerCust(Customer cust) {


		return 		custRepo.save(cust);

	}

}
