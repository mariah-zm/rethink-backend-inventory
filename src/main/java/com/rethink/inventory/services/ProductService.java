package com.rethink.inventory.services;

import com.rethink.inventory.exceptions.ProductNotFoundException;
import com.rethink.inventory.models.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(Integer productId) throws ProductNotFoundException;

    List<Product> getAllProducts();

    List<Product> searchProductsByName(String name) throws ProductNotFoundException;

}