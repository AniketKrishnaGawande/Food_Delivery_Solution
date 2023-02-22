package com.app.pojos;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="delivery_boy")
@Getter
@Setter
@ToString(exclude = "password")
public class DeliveryBoy extends User{
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status=OrderStatus.NOT_ASSIGN;
	
	private boolean approvedStatus=false;
	
	

	public DeliveryBoy() {
		super();
	}
	
	public DeliveryBoy(String firstnm,String lastnm,String Email,String passwd) {
		this.setFirstName(firstnm);
		this.setLastName(lastnm);
		this.setEmail(Email);
		this.setPassword(passwd);
	}
	
	
	
	//hotelier
	//add -->register
	//login hotelier
	
	//del boy
	//login
	//register --> add --> status (boolean)
	//delete admin apprved
	
	//admin login
	//register

}
