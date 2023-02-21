package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

		return hotelService.fetchAllHotels();
	}

}
