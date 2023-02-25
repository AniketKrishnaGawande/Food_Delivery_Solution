package com.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Hotelier;
@Repository
public interface HotelierRepository extends JpaRepository<Hotelier, Long> {
	
	Optional<Hotelier> findByEmailAndPassword(String email,String password);

}
