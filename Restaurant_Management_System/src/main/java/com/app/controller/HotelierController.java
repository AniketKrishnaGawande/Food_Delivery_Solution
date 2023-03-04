package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.HotelierDTO;
import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.Hotelier;
import com.app.services.HotelierServiceIf;

@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "http://localhost:3000")
public class HotelierController {

	@Autowired
	private HotelierServiceIf hotelService;

	@GetMapping("/approvedHotels")
	public List<Hotelier> getApprovedHotels() {
		return hotelService.fetchApprovedHotels();
	}

	@GetMapping("/getHotelDetails")
	public List<Hotelier> getAllHotels() {

		System.out.println("before controller");
		List<Hotelier> list = hotelService.fetchAllHotels();
		System.out.println("after controller");
		System.out.println(list);
		return list;
	}

	@PostMapping("/RegisterHotel")
	public String addHotels(@RequestBody HotelierDTO hotel) {
		System.out.println("In method Hotelier controller "+hotel);
		return hotelService.RegisterHotel(hotel);
	}

	
	@DeleteMapping("/deleteHotel/{id}")
	public String deleteHotelById(@PathVariable Long id) {
		return hotelService.deleteHotel(id);
	}
//	@GetMapping("/deleteHotel")
//	public String deleteHotelById(@RequestParam Long id) {
//		System.out.println(id);
//		return hotelService.deleteHotel(id);
//	}

	@PutMapping("/approvedHotel/{id}")
	public String approveHotel(@PathVariable Long id) {
		return hotelService.approveHotel(id);
	}

	@PostMapping("/hotelierLogin")
	public Hotelier validateLogin(@RequestBody LoginDTO login) throws CustomException {
		return hotelService.hotelLogin(login);
	}

}
