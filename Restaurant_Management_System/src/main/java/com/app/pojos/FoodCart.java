package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodCart extends BaseEntity {
	private double cartTotalPrice;
	@OneToOne
	@JoinColumn(name = "customer_id")
	@JsonBackReference
	private Customer customer;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItem> cartItem = new ArrayList<CartItem>();

	public void AddCartItem(CartItem cartItem) {
		this.cartItem.add(cartItem);
	}

	public void reduceCartTotalPrice(double price) {
		cartTotalPrice = cartTotalPrice - price;
	}
}
