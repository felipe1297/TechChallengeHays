package com.hays.hays_order_ms.domain.model;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@ToString
public class Order {
    private String id;
    private Customer customer;
    private List<PizzaCustomization> customPizzas;
}
