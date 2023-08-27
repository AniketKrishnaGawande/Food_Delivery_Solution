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

	@Autowired
	private CustomerServiceImpl custService;

	public CartItem getByCartItemId(long cartid) {
		return itemRepo.findById(cartid).orElseThrow();
	}

	public CartItem createCartItem(CartItem item, HotelMenu menu) {
		item.addMenu(menu);
		return itemRepo.save(item);
	}

	public String deleteItem(long custId, long itemId) {
		System.out.println("******************before remove from cart ************");
		custService.removeFromCart(custId, itemRepo.findById(itemId).orElseThrow());
		System.out.println("******************before find by id ************");
		itemRepo.findById(itemId).orElseThrow().removeMenu();
		System.out.println("******************before delete by id ************");
		return "item deleted";
	}

	public String deleteAllCartItems(long custId) {
		custService.deleteAllCart(custId);
		return "all cart items deleted";
	}

}
