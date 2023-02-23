package com.app.services;

import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.Customer;

public interface CustomerServiceif {
	
	public Customer validateLogin(LoginDTO dtls)throws CustomException;
	public Customer registerCust(Customer cust);
	public Customer getCustomerById(long id);

}
