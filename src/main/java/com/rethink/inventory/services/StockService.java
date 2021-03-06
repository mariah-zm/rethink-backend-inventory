package com.rethink.inventory.services;

import com.rethink.inventory.exceptions.ProductNotFoundException;
import com.rethink.inventory.models.Delivery;
import com.rethink.inventory.models.Stock;

import java.util.List;

public interface StockService {

    Stock getStock();

    List<Integer> getLowStockItems();

    void updateProductQuantity(Integer productId, int quantity) throws ProductNotFoundException;

    boolean isRunningOutOrOutOfStock(Integer productId) throws ProductNotFoundException;

    boolean isInStock(Integer productId) throws ProductNotFoundException;

    void receiveDelivery(Delivery delivery);

}
