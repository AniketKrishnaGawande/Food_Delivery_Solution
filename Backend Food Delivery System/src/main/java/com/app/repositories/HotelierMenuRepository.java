package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.HotelMenu;
import com.app.pojos.Hotelier;
import com.app.pojos.OrderHistory;

public interface HotelierMenuRepository extends JpaRepository<HotelMenu, Long> {
	
	
	
	List<HotelMenu> findByHotel(Hotelier hotel);

}
