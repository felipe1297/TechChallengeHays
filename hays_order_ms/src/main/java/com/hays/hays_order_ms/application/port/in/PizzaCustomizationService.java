package com.hays.hays_order_ms.application.port.in;

import com.hays.hays_order_ms.domain.model.PizzaCustomization;

public interface PizzaCustomizationService {
    PizzaCustomization createPizzaCustomization(PizzaCustomization pizzaCustomization);
    PizzaCustomization findByPizzaId(Long idPizza);
}
