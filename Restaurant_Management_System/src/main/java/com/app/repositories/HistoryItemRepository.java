package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.HistoryItems;

public interface HistoryItemRepository extends JpaRepository<HistoryItems, Long> {

}
