package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="User_tbl")
@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter
@ToString(exclude = "password")
public class User extends BaseEntity {
	@Column(length = 20)
	private String firstName;
	
	@Column(length = 20)
	private String lastName;
	
	@Column(length = 20)
	private String password;
	
	@Column(length = 20)
	private String email;
	
	
	private Role role;
	
	

}
