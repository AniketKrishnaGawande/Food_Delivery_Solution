package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DBoyRegisterDTO{
	
	private String firstName;

	private String lastName;

	private String email;
	
	private String password;

	

}
