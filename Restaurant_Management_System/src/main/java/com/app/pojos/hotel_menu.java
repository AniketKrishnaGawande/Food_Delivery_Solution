package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

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
public class hotel_menu extends BaseEntity{
	
	@Column(length = 20)
	private String mName;
	private double mPrice;
	
	@Column(length = 20)
	private String description;
	private Menu menu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="hotelier_id")
	private hotelier hotelMenu;
	
	//photo pending
	
	

}
