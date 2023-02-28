package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.OrderHistoryDTO;
import com.app.pojos.Customer;
import com.app.pojos.HotelMenu;
import com.app.pojos.OrderHistory;
import com.app.repositories.CustomerRepository;
import com.app.repositories.HotelierMenuRepository;
import com.app.repositories.OrderHistoryRepository;

@Service
@Transactional
public class OrderHistoryService {

	@Autowired
	private OrderHistoryRepository orderRepo;
	@Autowired
	private CustomerServiceif custService;

	@Autowired
	private FoodCartServiceIf foodCartService;

	@Autowired
	private CartItemService cartItemService;

	public OrderHistory placeOrder(long custId) {
		OrderHistory orderHist = new OrderHistory();
		
		Customer cust = custService.getCustomerById(custId);
		orderHist.addMenuList(foodCartService.getAllCartMenu(cust.getCart().getId()));
		cartItemService.deleteAllCartItems(custId);
		cust.addOrderHistory(orderHist);
		return orderRepo.save(orderHist);
	}

	public List<OrderHistory> getAllHistory(long id) {

		return orderRepo.findByCustomerId(id);

	}

}
