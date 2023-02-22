package com.app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import com.app.pojos.OrderStatus;
import com.app.pojos.User;

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

	private String password;

	private String email;

}
