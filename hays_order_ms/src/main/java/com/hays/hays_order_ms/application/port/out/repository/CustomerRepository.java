package com.hays.hays_order_ms.application.port.out.repository;

import com.hays.hays_order_ms.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(String id);
    List<Customer> findAll();
    Customer save(Customer customer);
}
