package com.app.pojos;

import javax.persistence.Entity;

@Entity
public class Admin extends User{
	
	private String address;

	public Admin(String address, String firstName, String lastName, String password, String email) {
		super(firstName,lastName,password,email);
		this.address=address;
	}
	
	public Admin()
	{
		
	}
	
	

}
