package com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper;

import com.hays.hays_order_ms.domain.model.Pizza;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.PizzaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PizzaEntityMapper {
    Pizza pizzaEntityToPizza(PizzaEntity pizzaEntity);
    List<Pizza> pizzaEntityListToPizzaList(List<PizzaEntity> pizzaEntity);
    PizzaEntity pizzaToPizzaEntity(Pizza pizza);
    List<PizzaEntity> pizzaListToPizzaEntityList(List<Pizza> pizza);
}
