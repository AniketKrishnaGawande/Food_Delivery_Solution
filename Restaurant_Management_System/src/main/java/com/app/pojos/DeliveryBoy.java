package com.app.pojos;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@ToString
public class DeliveryBoy extends User{
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status=OrderStatus.NOT_ASSIGN;
	
	private DeliveryBoyAcceptStatus approvedStatus=DeliveryBoyAcceptStatus.NOT_APPROVED;
	
	@OneToOne
	@JsonIgnore
	private HistoryItems order;
	
	public DeliveryBoy() {
		super();
	}
	
	public DeliveryBoy(String firstnm,String lastnm,String Email,String passwd) {
		this.setFirstName(firstnm);
		this.setLastName(lastnm);
		this.setEmail(Email);
		this.setPassword(passwd);
		status=OrderStatus.NOT_ASSIGN;
		approvedStatus=DeliveryBoyAcceptStatus.NOT_APPROVED;
		order=null;
	}
	

}
