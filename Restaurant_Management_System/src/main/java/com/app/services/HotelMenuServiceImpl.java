package com.app.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.HotelMenuAddDto;
import com.app.pojos.HotelMenu;
import com.app.pojos.HotelStatus;
import com.app.pojos.Hotelier;
import com.app.repositories.HotelierMenuRepository;
import com.app.repositories.HotelierRepository;

@Service
@Transactional
public class HotelMenuServiceImpl implements HotelMenuServiceif {

	@Autowired
	private HotelierMenuRepository hotelMenuRepo;

	@Autowired
	private HotelierRepository hotelRepo;

	@Autowired
	private HotelierServiceIf hService;

	// To fetch All Hotel Menus
	@Override
	public List<HotelMenu> fetchAllMenus() {
		List<HotelMenu> menuList = hotelMenuRepo.findAll();
		menuList.get(0).getHotel().getHName();
		return menuList;
	}

	public List<HotelMenu> fetchMenuByHotelId(long hId) {
		Hotelier hotel = hService.getHotelByHId(hId);
		return hotelMenuRepo.findByHotel(hotel);

	}

	// To Add menu in Hotel
	@Override
	public String addMenu(HotelMenuAddDto menu, long id) {
		if (menu != null) {
			System.out.println(id + "in service impl");
			HotelMenu hMenu = new HotelMenu(menu.getMName(), menu.getMPrice(), menu.getDescription(), menu.getMenu());
//			Hotelier hotel= hotelRepo.getById(menu.getId());
			Hotelier hotel = hotelRepo.findById(id).orElseThrow();
			if (hotel.getStatus() == HotelStatus.APPROVED) {
				hotel.addMenu(hMenu);
				hotelMenuRepo.save(hMenu);

				return "Menu added successful";
			} else {
				return "hotel not approved";
			}
		}
		return "Give Correct Menu Details";
	}

	// To Remove Menu in Hotel
	@Override
	public String removeMenu(long id) {

		HotelMenu menu = hotelMenuRepo.findById(id).orElseThrow();
		Hotelier hotel = menu.getHotel();
		hService.removeMenu(hotel.getId(), menu);
		hotelMenuRepo.deleteById(id);
		return "deleted";

	}

	// Get Hotel Menu's By Id
	@Override
	public HotelMenu getMenuById(long id) {
		return hotelMenuRepo.findById(id).orElseThrow();
	}
}
