package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.CartItem;
import com.app.pojos.Customer;
import com.app.pojos.FoodCart;
import com.app.repositories.CustomerRepository;
import com.app.repositories.HotelierMenuRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerServiceif {
	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private HotelierMenuRepository menuRepo;

	//Customer Login
	@Override
	public Customer validateLogin(LoginDTO dtls) throws CustomException {

		return custRepo.findByEmailAndPassword(dtls.getEmail(), dtls.getPassword())
				.orElseThrow(() -> new CustomException("invalid details"));

	}

	//Customer Registration
	@Override
	public Customer registerCust(Customer cust) {
		cust.attachCart(new FoodCart());
		return custRepo.save(cust);

	}

	//Get Customer Details By Id
	@Override
	public Customer getCustomerById(long id) {
		return custRepo.findById(id).orElseThrow();
	}

}
