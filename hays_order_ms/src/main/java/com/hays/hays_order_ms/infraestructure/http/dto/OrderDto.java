package com.hays.hays_order_ms.infraestructure.http.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class OrderDto {
    private String id;
    private CustomerDto customer;
    private List<PizzaCustomizationDto> customPizzas;
}
