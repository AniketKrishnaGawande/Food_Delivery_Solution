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
@Table(name = "hotels")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
<<<<<<< HEAD:Restaurant_Management_System/src/main/java/com/app/pojos/hotelier.java
public class hotelier extends BaseEntity {
	@Column(length = 20)
	private String hName;

	@Column(length = 20)
=======
public class Hotelier extends BaseEntity{
	@Column(length = 20)
	private String hName;
	
	@Column(length = 100)
>>>>>>> b65a01493167b33e5dbc45f4da319c0cab3c7075:Restaurant_Management_System/src/main/java/com/app/pojos/Hotelier.java
	private String hAddress;

	private int rating;
<<<<<<< HEAD:Restaurant_Management_System/src/main/java/com/app/pojos/hotelier.java

	@OneToMany(mappedBy = "hotelMenu", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<hotel_menu> menus = new ArrayList<>();

	public void addMenu(hotel_menu hm) {
		menus.add(hm);
		hm.setHotelMenu(this);
	}

	public void removeMenu(hotel_menu hm) {
=======
	
	@OneToMany(mappedBy = "hotelMenu",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<HotelMenu> menus=new ArrayList<>();
	
	public void addMenu(HotelMenu hm)
	{
		menus.add(hm);
		hm.setHotelMenu(this);
	}
	
	public void removeMenu(HotelMenu hm)
	{
>>>>>>> b65a01493167b33e5dbc45f4da319c0cab3c7075:Restaurant_Management_System/src/main/java/com/app/pojos/Hotelier.java
		menus.remove(hm);
		hm.setHotelMenu(null);
	}

}
