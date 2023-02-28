package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_history")
public class OrderHistory extends BaseEntity {
	@CreationTimestamp
	private LocalDate dateOfPlacement;
	
	private double price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_Id")
	private Customer customer;

	private OrderStatus status = OrderStatus.PENDING;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<HotelMenu> menuList = new ArrayList<HotelMenu>();

	public void addMenuList(List<CartItem> cartItem) {
		
		for(CartItem item : cartItem)
		{
			menuList.add(item.getMenu());			
		}
	}

	public OrderHistory(double price) {
		this.price = price;
	}

	public void setCust(Customer cust) {
		customer = cust;
	}

}
