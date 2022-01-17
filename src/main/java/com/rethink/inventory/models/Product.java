package com.rethink.inventory.models;

import com.rethink.inventory.models.enums.CategoryName;
import com.rethink.inventory.models.enums.Label;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "product")
public class Product {

    @Id
    private Integer id;
    private String name;
    private String description;
    private String ingredients;
    private LocalDateTime expiryDate;
    private double sellingPrice;
    private double buyingPrice;
    private String measurement;
    private CategoryName category;
    private Label label;
    private Integer supplier_id;

}
