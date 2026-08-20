package com.ecommerce.springbootecommerce.service;

import com.ecommerce.springbootecommerce.model.Customer;
import com.ecommerce.springbootecommerce.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer, Long customerId) {
        customerRepository.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

        customer.setId(customerId);
        customer.setEmail(customer.getEmail());
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.save(customer);
    }

    @Override
    public String deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

        customerRepository.delete(customer);
        return "Customer with " + customerId + " deleted successfully!";
    }
}
