package com.app.services;

import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.Customer;

public interface CustomerServiceif {
	
	//Customer Login
	public Customer validateLogin(LoginDTO dtls)throws CustomException;
	
	//Customer Registration
	public Customer registerCust(Customer cust);
	
	//Get Customer Details By Id
	public Customer getCustomerById(long id);

}
