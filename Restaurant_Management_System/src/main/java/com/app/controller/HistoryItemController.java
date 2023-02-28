package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.HistoryItemService;

@RestController
@RequestMapping("/changeStatus")
public class HistoryItemController {

	@Autowired
	private HistoryItemService histItemService;

	@PostMapping("/{orderId}")
	public String changeOrderStatus(@PathVariable long orderId) {
		return histItemService.changeOrderStatus(orderId);
	}

}