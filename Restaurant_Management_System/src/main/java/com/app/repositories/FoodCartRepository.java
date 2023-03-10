package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.FoodCart;
import com.app.pojos.OrderHistory;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Long> {
	
	
	
	@Query(nativeQuery =true, value =  "select * from food_cart where customer_id=:id")
	FoodCart findByCustomerId(long id);

}
