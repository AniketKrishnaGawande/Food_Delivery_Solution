package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="hotels")
@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter
public class hotelier extends BaseEntity{
	@Column(length = 20)
	private String hName;
	
	@Column(length = 20)
	private String hAddress;
	
	private int rating;
	
	@OneToMany(mappedBy = "hotelMenu",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<hotel_menu> menus=new ArrayList<>();
	
	public void addMenu(hotel_menu hm)
	{
		menus.add(hm);
		hm.setHotelMenu(this);
	}
	
	public void removeMenu(hotel_menu hm)
	{
		menus.remove(hm);
		hm.setHotelMenu(null);
	}

}