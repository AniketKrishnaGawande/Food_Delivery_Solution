package com.app.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.HotelMenuAddDto;
import com.app.pojos.HotelMenu;
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
	
	@Override
	public List<HotelMenu> fetchAllMenus() {
		List<HotelMenu> menuList=hotelMenuRepo.findAll();
		menuList.get(0).getHotelMenu().getHName();
		return menuList;
	}

	@Override
	public String addMenu(HotelMenuAddDto menu,long id) {
		if(menu !=null)
		{ System.out.println(id+"in service impl");
			HotelMenu hMenu=new HotelMenu(menu.getMName(),menu.getMPrice(),menu.getDescription(),menu.getMenu());
//			Hotelier hotel= hotelRepo.getById(menu.getId());
			Hotelier hotel=hotelRepo.findById(id).orElseThrow();
			hotel.addMenu(hMenu);
			hotelMenuRepo.save(hMenu);
			
			
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
