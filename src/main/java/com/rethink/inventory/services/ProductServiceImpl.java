package com.rethink.inventory.services;

import com.rethink.inventory.exceptions.ProductNotFoundException;
import com.rethink.inventory.models.Product;
import com.rethink.inventory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(Integer productId) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException("Could no find product with id " + productId);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    @Override
    public List<Product> searchProductsByName(String name) throws ProductNotFoundException {
        ArrayList<Product> products = (ArrayList<Product>) productRepository.findAllByNameIgnoreCaseContaining(name);

        if (products == null || products.isEmpty()) {
            throw new ProductNotFoundException("Could not find any products matching \"" + name + "\"");
        }

        return products;
    }

}