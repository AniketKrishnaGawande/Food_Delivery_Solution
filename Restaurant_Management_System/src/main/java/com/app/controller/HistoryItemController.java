package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.DeliveryBoy;
import com.app.pojos.HistoryItems;
import com.app.services.HistoryItemService;

@RestController
@RequestMapping("/changeStatus")
@CrossOrigin(origins = "http://localhost:3000")
public class HistoryItemController {

	@Autowired
	private HistoryItemService histItemService;

	@PostMapping("/hotel/{orderId}")
	public String changeHotelOrderStatus(@PathVariable long orderId) {
		return histItemService.changeHotelOrderStatus(orderId);
	}

	@GetMapping("/getHistoryItemByDeliveryBoy/{dBoyId}")
	public List<HistoryItems> getItemByDBoy(@PathVariable long dBoyId) {
		return histItemService.getItemByDBoy(dBoyId);

	}

	@PostMapping("/dboy/{orderId}")
	public String changeDeliveryOrderStatus(@PathVariable long orderId) {
		return histItemService.changeDeliveryOrderStatus(orderId);
	}
}
