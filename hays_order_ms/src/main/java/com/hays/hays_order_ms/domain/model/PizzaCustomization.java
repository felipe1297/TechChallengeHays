package com.hays.hays_order_ms.domain.model;

import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@ToString
public class PizzaCustomization {
    private Long id;
    private Pizza pizza;
    private Order order;
    private Set<Topping> toppings;
    @NonNull
    private Parameter size;
    @NonNull
    private Parameter crust;
    private String notes;
}
