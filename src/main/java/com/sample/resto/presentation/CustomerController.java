package com.sample.resto.presentation;

import com.sample.resto.model.Customer;
import com.sample.resto.model.constant.Constants;
import com.sample.resto.repository.CustomerRepository;
import com.sample.resto.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getCustomerList());
    }

    @PostMapping
    public ResponseEntity<Customer>  createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        Optional<Customer> optionalCustomer = customerService.getCustomerById(id);
        if(optionalCustomer.isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, Constants.CUSTOMER_NOT_FOUND);
        }
        return    ResponseEntity.ok(optionalCustomer.get());
    }
}
