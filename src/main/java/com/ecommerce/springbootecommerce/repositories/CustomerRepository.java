package com.ecommerce.springbootecommerce.repositories;

import com.ecommerce.springbootecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
