package com.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.DeliveryBoy;
import com.app.pojos.DeliveryBoyAcceptStatus;
import com.app.pojos.OrderStatus;
@Repository
public interface DeliveryBoyRepository extends JpaRepository<DeliveryBoy,Long>{

	//Optional method for Delivery Boy login
	Optional<DeliveryBoy> findByEmailAndPassword(String email,String password);
	
	List<DeliveryBoy> findByStatusAndApprovedStatus(OrderStatus status, DeliveryBoyAcceptStatus approveStstus);
	
}
