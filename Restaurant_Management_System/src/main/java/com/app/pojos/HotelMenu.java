package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="hotel_menu")
@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter
public class HotelMenu extends BaseEntity{
	
	@Column(length = 20)
	private String mName;
	private double mPrice;
	
	@Column(length = 20)
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Menu menu;
	
<<<<<<< HEAD:Restaurant_Management_System/src/main/java/com/app/pojos/hotel_menu.java
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="hotelier_id",nullable=false)
	private hotelier hotelMenu;
=======
	@ManyToOne
	@JoinColumn(name="hotelier_id")
	private Hotelier hotelMenu;
>>>>>>> b65a01493167b33e5dbc45f4da319c0cab3c7075:Restaurant_Management_System/src/main/java/com/app/pojos/HotelMenu.java
	
	//photo pending
	
}
