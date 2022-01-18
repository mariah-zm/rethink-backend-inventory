package com.rethink.inventory.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Stock {

    private List<StockItem> stockItems;

    public Stock() {
        this.stockItems = new ArrayList<>();
    }

    public void addStockItem(StockItem item) {
        this.stockItems.add(item);
    }

}