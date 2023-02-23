package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
//@NoArgsConstructor
@Table(name = "Customers")
public class Customer extends User {
	@Column(length = 50)
	private String address;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonBackReference
	private List<OrderHistory> orderhistory = new ArrayList<OrderHistory>();

	@OneToOne(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
	private FoodCart cart;

	
	public void attachCart(FoodCart cart) {
		this.cart=cart;
		cart.setCustomer(this);
	}
	
	
	
	
	
	
	
	public Customer(String address, String firstName, String lastName, String password, String email) {
		super(firstName, lastName, password, email);
		// TODO Auto-generated constructor stub
		this.address = address;
	}
	
	public Customer()
	{
		
	}

	public void addOrderHistory(OrderHistory hs) {
		orderhistory.add(hs);
	}







	@Override
	public String toString() {
		return "Customer ["+super.toString()+"address=" + address + ", orderhistory=" + orderhistory + ", cart=" + cart + "]";
	}
}
