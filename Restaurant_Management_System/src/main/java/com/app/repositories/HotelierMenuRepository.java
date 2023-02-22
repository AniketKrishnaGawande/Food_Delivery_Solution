package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.HotelMenu;

public interface HotelierMenuRepository extends JpaRepository<HotelMenu, Long> {

}
