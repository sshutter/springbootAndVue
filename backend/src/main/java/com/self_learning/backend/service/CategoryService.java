package com.self_learning.backend.service;

import com.self_learning.backend.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.self_learning.backend.repository.CategoryRepo;

import java.util.List;

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

}
