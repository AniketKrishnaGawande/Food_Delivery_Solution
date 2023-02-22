package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="hotelier_id")
	private Hotelier hotelMenu;
	
	//photo pending
	
}
