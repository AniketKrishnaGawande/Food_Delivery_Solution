package com.app.services;

import com.app.dto.LoginDTO;
import com.app.pojos.Customer;

public interface CustomerServiceif {
	
	public Customer validateLogin(LoginDTO dtls);

}
