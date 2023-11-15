package com.hays.hays_order_ms.infraestructure.http.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class PizzaCustomizationDto {
    private Long id;
    private PizzaDto pizza;
    private OrderDto order;
    private Set<ToppingDto> toppings;
    @NonNull
    private ParameterDto size;
    @NonNull
    private ParameterDto crust;
    private String notes;
}
