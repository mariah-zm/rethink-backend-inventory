package com.rethink.inventory.controllers;

import com.rethink.inventory.exceptions.ProductNotFoundException;
import com.rethink.inventory.models.Delivery;
import com.rethink.inventory.models.Stock;
import com.rethink.inventory.services.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/stock")
@RestController
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("")
    public @ResponseBody
    Stock getStock() {
        return stockService.getStock();
    }

    @GetMapping("/low")
    public @ResponseBody
    List<Integer> getLowStock() {
        return stockService.getLowStockItems();
    }

    @PostMapping("/quantity")
    public @ResponseBody String updateProductsQuantity(@RequestBody Map<Integer, Integer> quantities) {
        try {
            for (Integer id : quantities.keySet())
                stockService.updateProductQuantity(id, quantities.get(id));
            return "Quantity updated";
        } catch (ProductNotFoundException e) {
            return "Update failed: " + e.getMessage();
        }
    }

    @PostMapping("/delivery")
    public @ResponseBody String receiveDelivery(@RequestBody Delivery delivery) {
        stockService.receiveDelivery(delivery);
        return "Stock updated with delivery items";
    }

}