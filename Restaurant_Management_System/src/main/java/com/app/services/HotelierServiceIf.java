package com.app.services;

import java.util.List;

import com.app.dto.HotelierDTO;
import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.Hotelier;

public interface HotelierServiceIf {
	List<Hotelier> fetchAllHotels();
	
	public String deleteHotel(long id);
	
	public String RegisterHotel(HotelierDTO hotel);
	
	public String approveHotel(long id);
	
	public Hotelier hotelLogin(LoginDTO details)throws CustomException;

}
