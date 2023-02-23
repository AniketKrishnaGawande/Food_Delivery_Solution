package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.CartItem;
import com.app.pojos.Customer;
import com.app.pojos.HotelMenu;
import com.app.repositories.CartItemRepository;
import com.app.repositories.CustomerRepository;

@Service
@Transactional
public class CartItemService {

	@Autowired
	private CartItemRepository itemRepo;

	public CartItem createCartItem(CartItem item, HotelMenu menu) {
		item.addMenu(menu);
		return itemRepo.save(item);
	}

}
