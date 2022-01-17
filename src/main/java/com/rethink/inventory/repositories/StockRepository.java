package com.rethink.inventory.repositories;

import com.rethink.inventory.models.StockItem;
import org.springframework.data.repository.CrudRepository;


public interface StockRepository extends CrudRepository<StockItem, Integer> {

}
