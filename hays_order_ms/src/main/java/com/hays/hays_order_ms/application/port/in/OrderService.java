package com.hays.hays_order_ms.application.port.in;

import com.hays.hays_order_ms.domain.model.*;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order, Payment payment);
    Order findById(Long id);
    List<Order> findAllOrdersByCustomer(String customerId);
    List<Order> findAllOrder();
}
