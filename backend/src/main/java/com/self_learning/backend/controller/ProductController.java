package com.self_learning.backend.controller;

import com.self_learning.backend.common.ApiResponse;
import com.self_learning.backend.dto.ProductDto;
import com.self_learning.backend.model.Category;
import com.self_learning.backend.model.Product;
import com.self_learning.backend.repository.CategoryRepo;
import com.self_learning.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepo categoryRepo;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if(!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Category does not exists"), HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(productDto, optionalCategory.get());
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if(!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Category doesn't exist"), HttpStatus.BAD_REQUEST);
        }
        productService.updateProduct(productDto, optionalCategory, productId);
        return  new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("productId") Integer productId) {
        productService.deleteProduct(productId);
        return  new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been deleted"), HttpStatus.OK);
    }
}
