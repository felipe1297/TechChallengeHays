package com.hays.hays_order_ms.application.port.out.repository;

import com.hays.hays_order_ms.domain.model.Pizza;

import java.util.List;

public interface PizzaRepository {
    Pizza save(Pizza pizza);
    List<Pizza> findByNameTop(String name, Integer number);
    List<Pizza> findAll();
    Pizza findById(Long id);
}
