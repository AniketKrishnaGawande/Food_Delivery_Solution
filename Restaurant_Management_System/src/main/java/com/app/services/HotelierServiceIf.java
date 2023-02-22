package com.app.services;

import java.util.List;

import com.app.pojos.Hotelier;

public interface HotelierServiceIf {
	List<Hotelier> fetchAllHotels();
	
	public String deleteHotel(long id);
	
	public String addHotel(Hotelier hotel);
	
	public String approveHotel(long id);

}
