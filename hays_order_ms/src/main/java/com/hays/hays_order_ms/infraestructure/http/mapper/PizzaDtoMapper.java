package com.hays.hays_order_ms.infraestructure.http.mapper;

import com.hays.hays_order_ms.domain.model.Pizza;
import com.hays.hays_order_ms.infraestructure.http.dto.PizzaDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PizzaDtoMapper {
    Pizza pizzaDtoToPizza(PizzaDto pizzaDto);
    List<Pizza> pizzaDtoListToPizzaList(List<PizzaDto> pizzaDtos);
    PizzaDto pizzaToPizzaDto(Pizza pizza);
    List<PizzaDto> pizzaListToPizzaDtoList(List<Pizza> pizzas);
}
