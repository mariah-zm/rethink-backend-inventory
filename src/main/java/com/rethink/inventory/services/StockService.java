package com.rethink.inventory.services;

import com.rethink.inventory.exceptions.ProductNotFoundException;

public interface StockService {

    boolean isRunningOutOrOutOfStock(Integer productId) throws ProductNotFoundException;

    boolean isInStock(Integer productId) throws ProductNotFoundException;

}
