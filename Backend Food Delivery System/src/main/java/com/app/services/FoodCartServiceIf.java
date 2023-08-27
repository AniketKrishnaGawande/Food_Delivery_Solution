package com.app.services;

import java.util.List;

import com.app.pojos.CartItem;
import com.app.pojos.FoodCart;
import com.app.pojos.HotelMenu;

public interface FoodCartServiceIf {
	public FoodCart addToCart(long custId, long menuId);

	public List<CartItem> getAllCartMenu(long foodCartId);

}
