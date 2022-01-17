package com.rethink.inventory.models;

import com.rethink.inventory.models.enums.ProductStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "stock")
public class StockItem {

    @Id
    private Integer productId;

    private int quantity;

    private ProductStatus status;

}
