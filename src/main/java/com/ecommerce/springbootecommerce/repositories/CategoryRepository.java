package com.ecommerce.springbootecommerce.repositories;

import com.ecommerce.springbootecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
