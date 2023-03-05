package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.DeliveryBoy;
import com.app.pojos.HistoryItems;

public interface HistoryItemRepository extends JpaRepository<HistoryItems, Long> {
	
	
	List<HistoryItems> findByDeliveryBoy(DeliveryBoy dBoy);

}
