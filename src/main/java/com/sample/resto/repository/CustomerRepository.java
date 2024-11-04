package com.sample.resto.repository;

import com.sample.resto.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    Customer findByName(String name);
//    Optional<Customer> findById(Long id);
}

