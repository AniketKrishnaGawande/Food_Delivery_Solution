package com.app.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HotelierDTO {
	
	private String hName;
	
	private String hAddress;
	
	private String email;
	
	private String password;
	

	public HotelierDTO(String hName, String hAddress, String email, String password) {
		super();
		System.out.println("In Hotelier DTO --------"+hName);
		this.hName = hName;
		this.hAddress = hAddress;
		this.email = email;
		this.password = password;
	}


}
