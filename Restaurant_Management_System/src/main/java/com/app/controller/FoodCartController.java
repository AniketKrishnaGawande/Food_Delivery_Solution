package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.FoodCart;
import com.app.services.FoodCartService;


@RestController
@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*")
@RequestMapping("/foodCart")
public class FoodCartController {
	@Autowired
	private FoodCartService foodService;

@PostMapping("/add/{custid}/{menuId}")
	public FoodCart addItemToCart(@PathVariable long custid, @PathVariable long menuId) {
		return foodService.addToCart(custid, menuId);
	}

	@GetMapping("/{custId}")
	public FoodCart getFoodCartByCustId(@PathVariable long custId) {

		return foodService.getCartByCustId(custId);
	}
}
