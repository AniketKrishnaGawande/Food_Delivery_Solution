package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Hotelier;
import com.app.repositories.HotelierRepository;

@Service
@Transactional
public class HotelierServiceImpl implements HotelierServiceIf {

	@Autowired
	private HotelierRepository hotelRepo;

	@Override
	public List<Hotelier> fetchAllHotels() {
		// TODO Auto-generated method stub
		System.out.println("service before");
		List<Hotelier> hotelList = hotelRepo.findAll();
		System.out.println("service after");
		hotelList.get(0).getMenus().size();
		return hotelList;
	}
	
	//custom exception needed or exception
	public String deleteHotel(long id)
	{
		if(hotelRepo.existsById(id))
		{
		hotelRepo.deleteById(id);
		return"Hotel deleted successful ";
		}
		return "Give valid Id";
		
	}

	@Override
	public String addHotel(Hotelier hotel) {
		if(hotel !=null)
		{
			hotelRepo.save(hotel);
			return "Hotel added successful";
		}
		return "Give Correct Hotel Details";
				
	}
	
	

}
