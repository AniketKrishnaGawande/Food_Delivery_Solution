package com.app.services;

import java.util.List;

import com.app.dto.HotelMenuAddDto;
import com.app.pojos.HotelMenu;

public interface HotelMenuServiceif {
	
	List<HotelMenu> fetchAllMenus();
	
	public String addMenu(HotelMenuAddDto menu,long id);
	
	public String removeMenu(long id);
	
	public HotelMenu getMenuById(long id);

}
