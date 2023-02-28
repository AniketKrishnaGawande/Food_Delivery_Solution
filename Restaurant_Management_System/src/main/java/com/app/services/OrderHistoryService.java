package com.app.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.OrderHistoryDTO;
import com.app.pojos.Customer;
import com.app.pojos.HistoryItems;
import com.app.pojos.HotelMenu;
import com.app.pojos.OrderHistory;
import com.app.repositories.CustomerRepository;
import com.app.repositories.HotelierMenuRepository;
import com.app.repositories.OrderHistoryRepository;

@Service
@Transactional
public class OrderHistoryService {

	@Autowired
	private OrderHistoryRepository historyRepo;

	@Autowired
	private CustomerServiceif custService;

	@Autowired
	private HistoryItemService historyItemService;

	@Autowired
	private FoodCartService foodCartService;

	public void placeOrder(long custId) {

		Customer cust = custService.getCustomerById(custId);
		HistoryItems hItem = historyItemService.createHistoryItem(new HistoryItems(), cust.getCart().getCartItem());
		cust.getOrderhistory().addToHistoryItemList(hItem);
		foodCartService.removeAllCartItems(cust.getCart().getId(), cust.getCart().getCartItem().size());
	}

	public OrderHistory getHistoryByCustId(Long custId) {
		OrderHistory history = historyRepo.findByCustomerId(custId);
		history.getHistoryItems().size();
		return history;
	}

	public List<OrderHistory> getOrderHistoryByHotelId(long id) {
		List<OrderHistory> list = historyRepo.findAll();
		List<OrderHistory> listByHotelId = new ArrayList<OrderHistory>();

		for (OrderHistory history : list) {
			for (HistoryItems item : history.getHistoryItems()) {
				for (HotelMenu menu : item.getMenuList()) {
					if (menu.getHotel().getId() == id) {
						listByHotelId.add(history);
					}
				}
			}
		}
		return listByHotelId;
	}

}
