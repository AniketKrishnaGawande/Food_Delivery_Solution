package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "cart_item")
public class CartItem extends BaseEntity {

	private int quantity;
	@OneToOne
	private HotelMenu menu;
	private double price;

	public void addMenu(HotelMenu menu) {
		this.menu = menu;
		this.price = menu.getMPrice();
		this.quantity = 1;
	}

	public void removeMenu() {
		menu = null;
	}
}
