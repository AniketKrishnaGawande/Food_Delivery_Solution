package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.CartItem;
import com.app.pojos.DeliveryBoy;
import com.app.pojos.HistoryItemStatus;
import com.app.pojos.HistoryItems;
import com.app.pojos.OrderStatus;
import com.app.repositories.HistoryItemRepository;

@Service
@Transactional
public class HistoryItemService {

	@Autowired
	private HistoryItemRepository histItemRepo;

	@Autowired
	private DeliveryBoyServiceif dBoyService;
	
	
	public HistoryItems createHistoryItem(HistoryItems historyItem, List<CartItem> cartItem) {
		historyItem.addMenuList(cartItem);
		DeliveryBoy dBoy = dBoyService.assignOrder(historyItem);
		historyItem.setDeliveryBoy(dBoy);
		return histItemRepo.save(historyItem);
	}

	public String changeOrderStatus(Long orderId) {
		HistoryItems item = histItemRepo.findById(orderId).orElseThrow();
		item.setStatus(HistoryItemStatus.COMPLETED);
		return "status changed";
	}

}
