package com.rethink.inventory.controllers;

import com.rethink.inventory.models.Delivery;
import com.rethink.inventory.models.StockItem;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/stock")
@RestController
public class StockController {

    @GetMapping("/{productId}")
    public @ResponseBody StockItem getStockItem(@PathVariable int productId) {
        // TODO Implement method
        return null;
    }

    @PostMapping("/delivery")
    public @ResponseBody String receiveDelivery(@RequestBody Delivery delivery) {
        // TODO Implement method
        return "Stock updated with delivery items";
    }

}