package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.HotelMenu;
import com.app.pojos.Hotelier;
import com.app.services.HotelMenuServiceif;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/hotelMenu")
public class HotelMenuController {
	
	@Autowired
	private HotelMenuServiceif hotelMenuService;
	
	@GetMapping
	public List<HotelMenu> getAllHotelMenus() {

		return hotelMenuService.fetchAllMenus();
	}
	
	@PostMapping("/addMenu")
	public String addMenu(@RequestBody HotelMenu menu)
	{
		return hotelMenuService.addMenu(menu);
	}
	
	@GetMapping("/deleteMenu/{id}")
	public String deleteMenu(@PathVariable Long id)
	{
		return hotelMenuService.removeMenu(id);
	}

}
