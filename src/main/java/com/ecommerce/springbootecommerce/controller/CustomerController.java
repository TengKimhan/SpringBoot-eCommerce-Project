package com.ecommerce.springbootecommerce.controller;

import com.ecommerce.springbootecommerce.model.Customer;
import com.ecommerce.springbootecommerce.service.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        try {
            return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/customers/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        try {
            return new ResponseEntity<>(customerService.updateCustomer(customer, customerId), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
       try {
           return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.OK);
       } catch (ResponseStatusException e) {
           return new ResponseEntity<>(e.getReason(), e.getStatusCode());
       }

    }
}
