package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.CartItemService;

@RestController
@RequestMapping("/CartItem")
@CrossOrigin(origins = "http://localhost:3000")
public class CartItemController {

	@Autowired
	private CartItemService itemService;

	@DeleteMapping("/{custId}/{cartItemId}")
	public String deleteCartItem(@PathVariable long custId, @PathVariable long cartItemId) {
		return itemService.deleteItem(custId, cartItemId);
	}
}
