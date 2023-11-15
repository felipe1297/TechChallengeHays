package com.hays.hays_order_ms.application.port.in;

import com.hays.hays_order_ms.domain.model.Pizza;

import java.util.List;

public interface PizzaService {
    Pizza createPizza(Pizza pizza);
    List<Pizza> getXPizzasByName(String name, Integer number);
    List<Pizza> getAllPizzas();
    Pizza getPizzaById(Long id);
}
