package com.rethink.inventory.models;

import com.rethink.inventory.models.enums.CategoryName;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "category")
public class Category {

    @Id
    private CategoryName categoryName;
    private Integer aisleNumber;
}
