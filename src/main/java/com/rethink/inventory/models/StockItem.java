package com.rethink.inventory.models;

import com.rethink.inventory.models.enums.CategoryNameEnumType;
import com.rethink.inventory.models.enums.ProductStatus;
import com.rethink.inventory.models.enums.ProductStatusEnumType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "stock")
@TypeDef(name = "product_status", typeClass = ProductStatusEnumType.class)
public class StockItem {

    @Id
    private Integer productId;

    private int quantity;

    @Setter
    @Type(type = "product_status")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }

}
