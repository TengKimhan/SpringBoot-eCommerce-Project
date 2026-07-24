package com.ecommerce.springbootecommerce.service;

import com.ecommerce.springbootecommerce.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
}
