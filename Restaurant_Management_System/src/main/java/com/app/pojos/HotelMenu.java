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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "hotel_menu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "hotelMenu")
public class HotelMenu extends BaseEntity {

	@Column(length = 20)
	private String mName;
	private double mPrice;

	@Column(length = 20)
	private String description;

	@Enumerated(EnumType.STRING)
	private Menu menu;
<<<<<<< HEAD
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="hotelier_id")
=======

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotelier_id", nullable = false)
@JsonBackReference
>>>>>>> 2630361dc43f729bc2739c8e994f2441431ea014
	private Hotelier hotelMenu;

	// photo pending

}
