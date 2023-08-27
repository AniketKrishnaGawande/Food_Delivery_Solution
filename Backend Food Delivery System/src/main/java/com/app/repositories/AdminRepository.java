package com.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	//Optional method for Admin login
	Optional<Admin> findByEmailAndPassword(String email,String password);
}
