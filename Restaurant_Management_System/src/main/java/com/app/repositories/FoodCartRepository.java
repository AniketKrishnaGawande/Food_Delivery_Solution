package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.FoodCart;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Long> {

}
