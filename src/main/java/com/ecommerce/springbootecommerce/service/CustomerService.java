package com.ecommerce.springbootecommerce.service;

import com.ecommerce.springbootecommerce.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long customerId);
    Customer updateCustomer(Customer customer, Long customerId);
    String deleteCustomer(Long customerId);
}
