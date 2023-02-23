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
	private CustomerRepository custRepo;
	@Autowired
	private HotelierMenuRepository menuRepo;

	public OrderHistory placeOrder(OrderHistoryDTO order) {

		OrderHistory orderHist = new OrderHistory(order.getPrice());

		Customer cust = custRepo.findById(order.getCustId()).orElseThrow();
		orderHist.setCust(cust);
		HotelMenu menu = menuRepo.findById(order.getMenuId()).orElseThrow();
		System.out.println(menu);
		orderHist.addMenuList(menu);
		return orderRepo.save(orderHist);
	}


public List<OrderHistory> getAllHistory(long id){
	
	return orderRepo.findByCustomerId(id);	
	
}

}
