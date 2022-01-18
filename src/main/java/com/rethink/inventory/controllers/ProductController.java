package com.rethink.inventory.controllers;

import com.rethink.inventory.exceptions.CategoryNotFoundException;
import com.rethink.inventory.exceptions.ProductNotFoundException;
import com.rethink.inventory.models.Product;
import com.rethink.inventory.models.enums.CategoryName;
import com.rethink.inventory.services.CategoryService;
import com.rethink.inventory.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/{productId}")
    public @ResponseBody
    Product getProduct(@PathVariable int productId) {
        try {
            return productService.getProduct(productId);
        } catch (ProductNotFoundException e) {
           return null;
        }
    }

    @GetMapping("/all")
    public @ResponseBody List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("")
    public @ResponseBody
    List<Product> findProductsByName(@RequestParam String name) {
        try {
            return productService.searchProductsByName(name);
        } catch (ProductNotFoundException e) {
            return null;
        }
    }

    @GetMapping("/{productId}/location")
    public @ResponseBody Integer getProductLocation(@PathVariable Integer productId) {
        try {
            Product product = productService.getProduct(productId);
            return categoryService.getCategoryLocation(product.getCategory());
        } catch (CategoryNotFoundException | ProductNotFoundException e) {
            return null;
        }
    }

}