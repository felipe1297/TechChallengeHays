package com.hays.hays_order_ms.application.port.out.repository;

import com.hays.hays_order_ms.domain.model.Topping;

import java.util.List;

public interface ToppingRepository {
    Topping save(Topping topping);
    Topping findById(Long id);
    List<Topping> findByNameTop(String name, Integer number);
    List<Topping> findAll();
}
