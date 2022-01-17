package com.rethink.inventory.services;

import com.rethink.inventory.exceptions.CategoryNotFoundException;
import com.rethink.inventory.models.enums.CategoryName;

public interface CategoryService {

    Integer getCategoryLocation(CategoryName categoryName) throws CategoryNotFoundException;

}