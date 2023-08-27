package com.app.services;

import java.util.List;

import com.app.dto.HotelMenuAddDto;
import com.app.pojos.HotelMenu;

public interface HotelMenuServiceif {
	
	//To fetch All Hotel Menus
	List<HotelMenu> fetchAllMenus();
	
	//To Add menu in Hotel
	public String addMenu(HotelMenuAddDto menu,long id);
	
	//To Remove Menu in Hotel
	public String removeMenu(long id);
	
	//Get Menu's By Id
	public HotelMenu getMenuById(long id);
	
	public List<HotelMenu> fetchMenuByHotelId(long hId);

}
