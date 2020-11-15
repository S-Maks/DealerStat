package com.dealerStat.store.repository;

import com.dealerStat.store.model.Trader;
import org.springframework.data.repository.CrudRepository;

public interface TraderRepository extends CrudRepository<Trader, Long> {
}
