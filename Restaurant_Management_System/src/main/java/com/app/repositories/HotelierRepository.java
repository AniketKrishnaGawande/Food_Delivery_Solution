package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Hotelier;
@Repository
public interface HotelierRepository extends JpaRepository<Hotelier, Long> {

}
