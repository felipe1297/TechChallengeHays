package com.hays.hays_order_ms.application.port.out.repository;

import com.hays.hays_order_ms.domain.model.Order;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);
    Order findById(Long id);
    List<Order> findAllOrdersByCustomer(String customerId);
    List<Order> findAll();
}
