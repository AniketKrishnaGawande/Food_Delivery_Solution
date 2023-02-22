package com.app.dto;

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
public class HotelierDTO {
	
	
	private String hName;
	
	private String hAddress;

	private int rating;
	
	private String email;
	
	private String password;

	
	

}
