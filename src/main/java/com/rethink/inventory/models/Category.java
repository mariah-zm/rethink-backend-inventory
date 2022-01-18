package com.rethink.inventory.models;

import com.rethink.inventory.models.enums.CategoryName;
import com.rethink.inventory.models.enums.CategoryNameEnumType;
import lombok.Getter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "category")
@TypeDef(name = "category_name", typeClass = CategoryNameEnumType.class)
public class Category {

    @Id
    @Type(type = "category_name")
    @Enumerated(EnumType.STRING)
    private CategoryName categoryName;

    private Integer aisleNumber;

}