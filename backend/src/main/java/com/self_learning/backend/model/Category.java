package com.self_learning.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private @NotBlank String categoryName;

    private @NotBlank String description;

    @Column(name = "image_url")
    private @NotBlank String imageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(@NotBlank String categoryName) {
        this.categoryName = categoryName;
    }

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }

    public @NotBlank String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(@NotBlank String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
