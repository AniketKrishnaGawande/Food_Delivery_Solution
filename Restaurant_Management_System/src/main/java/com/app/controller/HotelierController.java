package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Hotelier;
import com.app.services.HotelierServiceIf;

@RestController
@RequestMapping("/hotels")
public class HotelierController {

	@Autowired
	private HotelierServiceIf hotelService;

	@GetMapping
	public List<Hotelier> getAllHotels() {

		System.out.println("before controller");
		List<Hotelier> list = hotelService.fetchAllHotels();
		System.out.println("after controller");
		System.out.println(list);
		return list;
	}
	
	@PostMapping("/addHotel")
	public String addHotels(@RequestBody Hotelier hotel)
	{
		return hotelService.addHotel(hotel);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteHotelById(@PathVariable Long id)
	{
		return hotelService.deleteHotel(id);
	}
	
	@GetMapping("/approved/{id}")
	public String approveHotel(@PathVariable Long id)
	{
		return hotelService.approveHotel(id);
	}
	
	

}
