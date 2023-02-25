package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.HotelierDTO;
import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
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
	public String RegisterHotel(HotelierDTO hotels) {
		if(hotels !=null)
		{
			Hotelier hotel=new Hotelier(hotels.getHName(),hotels.getHAddress(),hotels.getRating(),hotels.getEmail(),hotels.getPassword());
			hotel.setStatus(false);
			hotelRepo.save(hotel);
			return "Hotel added successful";
		}
		return "Give Correct Hotel Details";
				
	}

	@Override
	public String approveHotel(long id) {
		if(hotelRepo.existsById(id))
		{
			hotelRepo.getById(id).setStatus(true);
			return "Approved";
		}
		return "Enter valid Hotel Id";
	}

	@Override
	public Hotelier hotelLogin(LoginDTO details) throws CustomException {
		return hotelRepo.findByEmailAndPassword(details.getEmail(), details.getPassword())
				.orElseThrow(()-> new CustomException("Invalid details"));
	}
	
	

}
