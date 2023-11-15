package com.hays.hays_order_ms.application.port.in;

import com.hays.hays_order_ms.domain.model.Topping;

import java.util.List;

public interface ToppingService {
    Topping creatIngredient(Topping topping);
    Topping getIngredientById(Long id);
    List<Topping> getXIngredientByName(String name, Integer number);
    List<Topping> getAll();
}
