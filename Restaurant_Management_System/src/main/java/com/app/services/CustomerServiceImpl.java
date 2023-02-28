package com.app.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.LoginDTO;
import com.app.exception.CustomException;
import com.app.pojos.CartItem;
import com.app.pojos.Customer;
import com.app.pojos.FoodCart;
import com.app.pojos.OrderHistory;
import com.app.repositories.CustomerRepository;
import com.app.repositories.HotelierMenuRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerServiceif {
	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private HotelierMenuRepository menuRepo;

	public void removeFromCart(long custId, CartItem item) {
		Customer cust = custRepo.findById(custId).orElseThrow();
		cust.getCart().reduceCartTotalPrice(item.getPrice());
		cust.getCart().getCartItem().remove(item);
	}

	// Customer Login
	@Override
	public Customer validateLogin(LoginDTO dtls) throws CustomException {

		Customer cust = custRepo.findByEmailAndPassword(dtls.getEmail(), dtls.getPassword())
				.orElseThrow(() -> new CustomException("invalid details"));
		return cust;

	}

	// Customer Registration
	@Override
	public Customer registerCust(Customer cust) {
		cust.attachCart(new FoodCart());
		cust.addOrderHistory(new OrderHistory());
		return custRepo.save(cust);

	}

	// Get Customer Details By Id
	@Override
	public Customer getCustomerById(long id) {
		return custRepo.findById(id).orElseThrow();
	}

	@Override
	public void deleteAllCart(long custId) {
		custRepo.findById(custId).orElseThrow().getCart().setCartItem(new ArrayList<CartItem>());
	}

}
