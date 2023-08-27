package com.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Hotelier;

@Repository
public interface HotelierRepository extends JpaRepository<Hotelier, Long> {

	// Optional method for Hotelier login
	Optional<Hotelier> findByEmailAndPassword(String email, String password);

	List<Hotelier> findByStatus(boolean status);

}
