package com.rethink.inventory.repositories;

import com.rethink.inventory.models.Category;
import com.rethink.inventory.models.enums.CategoryName;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, CategoryName> {

}