package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
//@NoArgsConstructor
@Table(name = "Customers")
@ToString
public class Customer extends User {
	@Column(length = 50)
	private String address;
	@OneToOne(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonIgnore
	private OrderHistory orderhistory;
	@OneToOne(mappedBy = "customer", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonIgnore
	private FoodCart cart;

	public void attachCart(FoodCart cart) {
		this.cart = cart;
		cart.setCustomer(this);
	}

	public Customer(String address, String firstName, String lastName, String password, String email) {
		super(firstName, lastName, password, email);
		// TODO Auto-generated constructor stub
		this.address = address;
	}
	public void addOrderHistory(OrderHistory hs) {
		orderhistory = hs;
		hs.setCust(this);
	}

	public Customer() {

	}

}
