package com.rethink.inventory.repositories;

import com.rethink.inventory.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {


}
