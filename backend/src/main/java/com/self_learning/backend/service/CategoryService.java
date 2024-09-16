package com.self_learning.backend.service;

import com.self_learning.backend.model.Category;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.self_learning.backend.repository.CategoryRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public void createCategory(Category category) {
        categoryRepo.save(category);
    }

    public List<Category> listCategories() {
        return categoryRepo.findAll();
    }

    public void editCategory(int categoryId, Category updateCategory) {
        Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            // Handle if null value
            if(updateCategory.getCategoryName() != null) {
                category.setCategoryName(updateCategory.getCategoryName());
            }
            if(updateCategory.getDescription() != null) {
                category.setDescription(updateCategory.getDescription());
            }
            if(updateCategory.getImageUrl() != null) {
                category.setImageUrl(updateCategory.getImageUrl());
            }
            categoryRepo.save(category);
        } else {
            throw new EntityNotFoundException("Category with ID " + categoryId + " not found");
        }

    }
}
