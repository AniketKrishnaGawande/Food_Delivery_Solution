package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.pojos.Menu;

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
public class HotelMenuAddDto {
		
	@Column(length = 20)
	private String mName;
	
	private double mPrice;

	@Column(length = 20)
	private String description;

	
	private Menu menu;
	

}
