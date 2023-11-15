package com.hays.hays_order_ms.application.port.out.repository;

import com.hays.hays_order_ms.domain.model.PizzaCustomization;

public interface PizzaCustomizationRepository {
    PizzaCustomization save(PizzaCustomization pizzaCustomization);
    PizzaCustomization findByPizzaId(Long idPizza);
}
