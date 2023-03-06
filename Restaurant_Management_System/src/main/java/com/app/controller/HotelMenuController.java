package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.HotelMenuAddDto;
import com.app.pojos.HotelMenu;
import com.app.pojos.Hotelier;
import com.app.services.HotelMenuServiceif;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/hotelMenu")
public class HotelMenuController {

	@Autowired
	private HotelMenuServiceif hotelMenuService;

	@GetMapping("/getAllHotelMenus")
	public List<HotelMenu> getAllHotelMenus() {

		return hotelMenuService.fetchAllMenus();
	}

	@GetMapping("/getMenuByHotelId/{hotelId}")
	public List<HotelMenu> fetchMenuByHotelId(@PathVariable long hotelId) {
		return hotelMenuService.fetchMenuByHotelId(hotelId);
	}

	@PostMapping("/addHotelMenus/{id}")
	public String addMenu(@RequestBody HotelMenuAddDto menu, @PathVariable Long id) {
		return hotelMenuService.addMenu(menu, id);
	}

	@DeleteMapping("/deleteHotelMenus/{id}")
	public String deleteMenu(@PathVariable Long id) {
		return hotelMenuService.removeMenu(id);
	}

}
