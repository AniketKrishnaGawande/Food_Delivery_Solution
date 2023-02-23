package com.app.services;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.CartItem;
import com.app.pojos.Customer;
import com.app.pojos.FoodCart;
import com.app.pojos.HotelMenu;
import com.app.repositories.CustomerRepository;
import com.app.repositories.FoodCartRepository;
import com.app.repositories.HotelierMenuRepository;

@Service
@Transactional
public class FoodCartService {

	@Autowired
	private FoodCartRepository cartRepo;

	@Autowired
	private CartItemService itemService;
	@Autowired
	private HotelMenuServiceif menuService;

	@Autowired
	private CustomerServiceif custService;

	public FoodCart addToCart(long custId, long menuId) {

		CartItem item = itemService.createCartItem(new CartItem(), menuService.getMenuById(menuId));
		Customer cust = custService.getCustomerById(custId);
		cust.getCart().AddCartItem(item);

		double price = 0;
		List<CartItem> list = cust.getCart().getCartItem();

		for (CartItem cartItem : list) {
			price += cartItem.getPrice();
		}
		cust.getCart().setCartTotalPrice(price);

		return cust.getCart();
	}

}
