package com.app.services;

import java.util.List;

import com.app.dto.HotelierDTO;
import com.app.pojos.Hotelier;

public interface HotelierServiceIf {
	List<Hotelier> fetchAllHotels();
	
	public String deleteHotel(long id);
	
	public String RegisterHotel(HotelierDTO hotel);
	
	public String approveHotel(long id);

}
