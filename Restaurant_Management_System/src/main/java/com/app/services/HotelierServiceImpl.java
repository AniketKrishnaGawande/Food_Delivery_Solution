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
		List<Hotelier> hotelList = hotelRepo.findAll();
		return hotelList;
	}
	
	public void deleteHotel(long id)
	{
		hotelRepo.deleteById(id);
	}

}
