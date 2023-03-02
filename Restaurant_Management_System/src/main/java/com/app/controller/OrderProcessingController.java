package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.OrderHistory;
import com.app.services.OrderHistoryService;

@RestController
@RequestMapping("/order")
public class OrderProcessingController {

	@Autowired
	private OrderHistoryService orderService;

	@PostMapping("/placedOrder/{custId}")
	public String acceptOrder(@PathVariable long custId) {

		orderService.placeOrder(custId);
		return "history added";

	}

	@GetMapping("getAllOrders/{Custid}")
	public OrderHistory getAllOrders(@PathVariable long Custid) {

		OrderHistory hist= orderService.getHistoryByCustId(Custid);
		
		System.out.println("********cntr *************");
		return hist;
	}

	@GetMapping("/historyForHotel/{hotelId}")
	public List<OrderHistory> getHistoryByHotelId(@PathVariable long hotelId) {
		return orderService.getOrderHistoryByHotelId(hotelId);
	}

}
