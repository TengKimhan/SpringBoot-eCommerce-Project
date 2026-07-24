package com.ecommerce.springbootecommerce.service;

import com.ecommerce.springbootecommerce.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
    }

    public String deleteCategory(Long categoryId) {
        Category category = (Category) categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElse(null);
        if (category == null) return "Category not found";

        categories.remove(category);
        return "Category with " + category.getCategoryId() + " deleted successfully!";
    }
}
