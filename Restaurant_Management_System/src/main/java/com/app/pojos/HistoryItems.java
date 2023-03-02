package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HistoryItems extends BaseEntity {
	@CreationTimestamp
	private LocalDate dateOfPlacement;

	private double price;
	
	
	@Enumerated(EnumType.STRING)
	private HotelOrderStatus orderStatus = HotelOrderStatus.PENDING;
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus deliveryStatus = DeliveryStatus.PENDING;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<HotelMenu> menuList = new ArrayList<HotelMenu>();

	@OneToOne
	private DeliveryBoy deliveryBoy;


	public void addMenuList(List<CartItem> cartItem) {
		double price = 0;
		for (CartItem item : cartItem) {
			menuList.add(item.getMenu());
			price = price + item.getMenu().getMPrice();
		}
		this.price = price;
		this.deliveryStatus = DeliveryStatus.PENDING;
	     orderStatus = HotelOrderStatus.PENDING;
		
	}

	public HistoryItems(double price) {
		this.price = price;
	}

}
