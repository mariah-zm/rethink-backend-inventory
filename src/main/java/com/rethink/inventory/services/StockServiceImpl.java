package com.rethink.inventory.services;

import com.rethink.inventory.exceptions.ProductNotFoundException;
import com.rethink.inventory.models.Delivery;
import com.rethink.inventory.models.DeliveryItem;
import com.rethink.inventory.models.Stock;
import com.rethink.inventory.models.StockItem;
import com.rethink.inventory.models.enums.ProductStatus;
import com.rethink.inventory.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock getStock() {
        ArrayList<StockItem> stock = (ArrayList<StockItem>) stockRepository.findAll();
        return new Stock(stock);
    }

    @Override
    public Stock getOutOfStockItems() {
        ArrayList<StockItem> stockItems = (ArrayList<StockItem>) stockRepository.findAll();
        Stock stock = new Stock();

        for(StockItem item : stockItems) {
            if (item.getStatus() == ProductStatus.out_of_stock) {
                stock.addStockItem(item);
            }
        }

        return stock;
    }

    @Override
    public void updateProductQuantity(Integer productId, int quantity) throws ProductNotFoundException {
        Optional<StockItem> item = stockRepository.findById(productId);

        if (item.isPresent()) {
            StockItem stockItem = item.get();
            stockItem.updateQuantity(quantity);
            stockRepository.save(stockItem);
        } else {
            throw new ProductNotFoundException("Could no find product with id " + productId);
        }
    }

    @Override
    public boolean isRunningOutOrOutOfStock(Integer productId) throws ProductNotFoundException {
        return !isInStock(productId);
    }

    @Override
    public boolean isInStock(Integer productId) throws ProductNotFoundException {
        Optional<StockItem> stockItem = stockRepository.findById(productId);

        if (stockItem.isPresent()) {
            return stockItem.get().getStatus() == ProductStatus.in_stock;
        } else {
            throw new ProductNotFoundException("Could no find product with id " + productId);
        }
    }

    @Override
    public void receiveDelivery(Delivery delivery) {
        for (DeliveryItem item : delivery.getDeliveredItems()) {
            try {
                this.updateProductQuantity(item.getProductId(), item.getDeliveryQty());
            } catch (ProductNotFoundException e) {
                e.printStackTrace();
            }
        }

        // TODO send message with orderId to order microservice so that order status is updated to delivered
    }
}
