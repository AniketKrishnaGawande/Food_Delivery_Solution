package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.OrderHistory;


@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {

	
	@Query(nativeQuery =true, value =  "select * from order_history where cust_id=:id")
	List<OrderHistory> findByCustomerId(long id);
}
