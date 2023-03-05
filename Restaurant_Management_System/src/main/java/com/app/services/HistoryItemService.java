package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.CartItem;
import com.app.pojos.DeliveryBoy;
import com.app.pojos.DeliveryStatus;
import com.app.pojos.HotelOrderStatus;
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
	
	
	public List<HistoryItems> getItemByDBoy(long dId){
		DeliveryBoy dBoy = dBoyService.getDBoyById(dId);
		
		return histItemRepo.findByDeliveryBoy(dBoy);
		
	}
	
	
	

	// change status by delivery boy
	public String changeDeliveryOrderStatus(Long orderId) {
		HistoryItems item = histItemRepo.findById(orderId).orElseThrow();
		item.setDeliveryStatus(DeliveryStatus.COMPLETED);
		dBoyService.completeDeliveryStatus(item.getDeliveryBoy());
		return "delivery status changed";
	}

	// change status by hotel
	public String changeHotelOrderStatus(Long orderId) {
		HistoryItems item = histItemRepo.findById(orderId).orElseThrow();
		item.setOrderStatus(HotelOrderStatus.COMPLETED);
		return "order status changed";
	}

}
