package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
