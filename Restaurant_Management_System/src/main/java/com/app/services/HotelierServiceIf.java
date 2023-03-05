package com.app.services;

import java.util.List;

import com.app.dto.HotelierDTO;
import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.Hotelier;

public interface HotelierServiceIf {
	
	//To fetch All Hotel Details
	List<Hotelier> fetchAllHotels();
	
	//To delete Hotel by id
	public String deleteHotel(long id);
	
	public List<Hotelier> fetchApprovedHotels();
	//To register Hotel
	public String RegisterHotel(HotelierDTO hotel);
	
	//To Approved Hotel By Id
	public String approveHotel(long id);
	
	//To Login hotel
	public Hotelier hotelLogin(LoginDTO details)throws CustomException;
	
	public Hotelier getHotelByHId(long hId);

}
