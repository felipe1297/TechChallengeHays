package com.hays.hays_order_ms.application.port.in;

import com.hays.hays_order_ms.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer login(String id, String password);
    Optional<Customer> getById(String id);
}
