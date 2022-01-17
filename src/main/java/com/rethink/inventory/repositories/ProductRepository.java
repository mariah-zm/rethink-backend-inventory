package com.rethink.inventory.repositories;

import com.rethink.inventory.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAllByNameIgnoreCaseContaining(String name);

}
