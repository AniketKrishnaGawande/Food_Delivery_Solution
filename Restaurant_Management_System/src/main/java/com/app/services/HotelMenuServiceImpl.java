package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.HotelMenu;
import com.app.repositories.HotelierMenuRepository;

@Service
@Transactional
public class HotelMenuServiceImpl implements HotelMenuServiceif {

	@Autowired
	private HotelierMenuRepository hotelMenuRepo;
	
	@Override
	public List<HotelMenu> fetchAllMenus() {
		List<HotelMenu> menuList=hotelMenuRepo.findAll();
		menuList.get(0).getHotelMenu().getHName();
		return menuList;
	}

	@Override
	public String addMenu(HotelMenu menu) {
		if(menu !=null)
		{
			hotelMenuRepo.save(menu);
			return "Menu added successful";
		}
		return "Give Correct Menu Details";
	}

	@Override
	public String removeMenu(long id) {
		if(hotelMenuRepo.existsById(id))
		{
			hotelMenuRepo.deleteById(id);
		return"Menu deleted successful ";
		}
		return "Give valid Id";
	}

}
