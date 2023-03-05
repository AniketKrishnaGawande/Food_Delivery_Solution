package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.HotelierDTO;
import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.HotelStatus;
import com.app.pojos.Hotelier;
import com.app.repositories.HotelierRepository;

@Service
@Transactional
public class HotelierServiceImpl implements HotelierServiceIf {

	@Autowired
	private HotelierRepository hotelRepo;

	@Override
	public Hotelier getHotelByHId(long hId) {
		return hotelRepo.findById(hId).orElseThrow();
	}

	public List<Hotelier> fetchApprovedHotels() {
		List<Hotelier> hotelList = hotelRepo.findByStatus(true);
		System.out.println("service after");
		hotelList.get(0).getMenus().size();
		return hotelList;

	}

	// To fetch All Hotel Details
	@Override
	public List<Hotelier> fetchAllHotels() {
		// TODO Auto-generated method stub
		System.out.println("service before");
		List<Hotelier> hotelList = hotelRepo.findAll();
		System.out.println("service after");
		hotelList.get(0).getMenus().size();
		return hotelList;
	}

	// custom exception needed or exception
	// To delete Hotel by id
	public String deleteHotel(long id) {
		if (hotelRepo.existsById(id)) {
			hotelRepo.deleteById(id);
			return "Hotel deleted successful ";
		}
		return "Give valid Id";

	}

	// To register Hotel
	@Override
	public String RegisterHotel(HotelierDTO hotels) {
		if (hotels != null) {
			System.out.println("In Hotelier service impl Dto obj" + hotels);
			Hotelier hotel = new Hotelier(hotels.getHName(), hotels.getHAddress(), hotels.getEmail(),
					hotels.getPassword());
			hotel.setStatus(HotelStatus.NOT_APPROVED);
			System.out.println("In Hotelier service impl after saving status obj" + hotel);
			hotelRepo.save(hotel);
			return "Hotel added successful";
		}
		return "Give Correct Hotel Details";

	}

	// To Approved Hotel By Id
	@Override
	public String approveHotel(long id) {
		if (hotelRepo.existsById(id)) {
			hotelRepo.findById(id).orElseThrow().setStatus(HotelStatus.APPROVED);
			return "Approved";
		}
		return "Enter valid Hotel Id";
	}

	// To Login hotel
	@Override
	public Hotelier hotelLogin(LoginDTO details) throws CustomException {
		return hotelRepo.findByEmailAndPassword(details.getEmail(), details.getPassword())
				.orElseThrow(() -> new CustomException("Invalid details"));
	}

}
