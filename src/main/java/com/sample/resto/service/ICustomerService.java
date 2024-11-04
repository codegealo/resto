package com.sample.resto.service;

import com.sample.resto.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> getCustomerList();
    Customer createCustomer(Customer customer);
    Optional<Customer> getCustomerById(Long id);

}
