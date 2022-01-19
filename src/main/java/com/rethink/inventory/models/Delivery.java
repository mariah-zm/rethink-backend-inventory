package com.rethink.inventory.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Delivery {

    private Long orderId;
    private List<DeliveryItem> deliveredItems;

}