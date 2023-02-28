package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "hotels")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
@JsonInclude(value =Include.NON_NULL )
public class Hotelier extends BaseEntity{
	@Column(length = 20)
	private String hName;
	
	@Column(length = 100)

	private String hAddress;

	private int rating;
	
	private boolean status=false;
	
	private String email;
	
	private String password;
		
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<HotelMenu> menus = new ArrayList<>();
	
	//dto purpose
	public Hotelier(String hName, String hAddress, int rating,String email, String Password) {
		
		this.hName = hName;
		this.hAddress = hAddress;
		this.rating = rating;
		this.status=false;
		this.email=email;
		this.password=password;
	}

	public void addMenu(HotelMenu hm) {
		menus.add(hm);
		hm.setHotel(this);
	}

	public void removeMenu(HotelMenu hm)
	{
		menus.remove(hm);
		hm.setHotel(null);
	}

	}
