package com.self_learning.backend.controller;

import com.self_learning.backend.common.ApiResponse;
import com.self_learning.backend.model.Category;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.self_learning.backend.service.CategoryService;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Created a new category"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Category> listCategories() {
        return categoryService.listCategories();
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") Integer categoryId, @RequestBody Category category) {
        try {
            categoryService.editCategory(categoryId, category);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Category does not exist"), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Some thing went wrong"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Updated the category"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer categoryId) {
        try {
            categoryService.deleteCategory(categoryId);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Category does not found"), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Some thing went wrong"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Deleted the category"), HttpStatus.OK);

    }
}
