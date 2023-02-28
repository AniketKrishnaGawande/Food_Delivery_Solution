package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.CartItem;
import com.app.pojos.HistoryItems;
import com.app.pojos.OrderStatus;
import com.app.repositories.HistoryItemRepository;

@Service
@Transactional
public class HistoryItemService {

	@Autowired
	private HistoryItemRepository histItemRepo;

	public HistoryItems createHistoryItem(HistoryItems historyItem, List<CartItem> cartItem) {
		historyItem.addMenuList(cartItem);
		return histItemRepo.save(historyItem);
	}

	public String changeOrderStatus(Long orderId) {
		HistoryItems item = histItemRepo.findById(orderId).orElseThrow();
		item.setStatus(OrderStatus.COMPLETED);
		return "status changed";
	}

}
