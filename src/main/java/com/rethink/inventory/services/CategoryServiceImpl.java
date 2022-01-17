package com.rethink.inventory.services;

import com.rethink.inventory.exceptions.CategoryNotFoundException;
import com.rethink.inventory.models.Category;
import com.rethink.inventory.models.enums.CategoryName;
import com.rethink.inventory.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Integer getCategoryLocation(CategoryName categoryName) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepository.findById(categoryName);

        if (category.isPresent()) {
            return category.get().getAisleNumber();
        } else {
            throw new CategoryNotFoundException("The category " + categoryName.toString() + " was not found");
        }
    }

}