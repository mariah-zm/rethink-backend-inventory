package com.rethink.inventory.controllers;

import com.rethink.inventory.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    @GetMapping("/{productId}")
    public @ResponseBody Product getProduct(@PathVariable int productId) {
        // TODO Implement method
        return null;
    }

    @GetMapping("/{name}")
    public @ResponseBody List<Product> findProducts(@PathVariable String name) {
        // TODO Implement method
        return null;
    }

}