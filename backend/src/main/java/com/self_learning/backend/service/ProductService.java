package com.self_learning.backend.service;

import com.self_learning.backend.dto.ProductDto;
import com.self_learning.backend.model.Category;
import com.self_learning.backend.model.Product;
import com.self_learning.backend.repository.ProductRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        productRepo.save(product);
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());
        return productDto;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productRepo.findAll();
        List<ProductDto> allProductsDto = new ArrayList<>();
        for(Product product: allProducts) {
            allProductsDto.add(getProductDto(product));
        }
        return allProductsDto;
    }

    public void updateProduct(ProductDto productDto, Optional<Category> optionalCategory, Integer productId) {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if(!optionalProduct.isPresent()) {
            throw new EntityNotFoundException("Product is not present");
        }
        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        // Update category
        product.setCategory(optionalCategory.get());

        productRepo.save(product);

    }

    public  void deleteProduct(Integer productId) {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if(!optionalProduct.isPresent()) {
            throw new EntityNotFoundException("Product is not present");
        }
        productRepo.delete(optionalProduct.get());
    }


}
