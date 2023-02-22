package com.app.services;

import java.util.List;

import com.app.pojos.HotelMenu;

public interface HotelMenuServiceif {
	
	List<HotelMenu> fetchAllMenus();
	
	public String addMenu(HotelMenu menu);
	
	public String removeMenu(long id);

}
