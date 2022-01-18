package com.rethink.inventory.models;

import com.rethink.inventory.models.enums.CategoryName;
import com.rethink.inventory.models.enums.Label;
import lombok.Getter;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
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

    private double sellingPrice;

    private double buyingPrice;

    private String measurement;

    @Enumerated(EnumType.STRING)
    private CategoryName category;

    @Enumerated(EnumType.STRING)
    private Label label;

    private Integer supplier_id;

}
