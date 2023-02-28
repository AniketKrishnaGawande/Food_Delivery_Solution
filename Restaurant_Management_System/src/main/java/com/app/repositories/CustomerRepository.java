package com.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
@Repository
@javax.transaction.Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	//Optional method for Customer login
	Optional<Customer> findByEmailAndPassword(String email,String password);
	


}
