package com.rethink.inventory.services;

import com.rethink.inventory.exceptions.ProductNotFoundException;
import com.rethink.inventory.models.StockItem;
import com.rethink.inventory.models.enums.ProductStatus;
import com.rethink.inventory.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public boolean isRunningOutOrOutOfStock(Integer productId) throws ProductNotFoundException {
        return !isInStock(productId);
    }

    @Override
    public boolean isInStock(Integer productId) throws ProductNotFoundException {
        Optional<StockItem> stockItem = stockRepository.findById(productId);

        if (stockItem.isPresent()) {
            return stockItem.get().getStatus() == ProductStatus.IN_STOCK;
        } else {
            throw new ProductNotFoundException("Could no find product with id " + productId);
        }
    }
}
