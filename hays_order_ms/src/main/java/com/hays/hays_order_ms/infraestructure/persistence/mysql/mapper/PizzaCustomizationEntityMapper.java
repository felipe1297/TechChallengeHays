package com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper;

import com.hays.hays_order_ms.domain.model.PizzaCustomization;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.PizzaCustomizationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PizzaCustomizationEntityMapper {
    PizzaCustomizationEntity pizzaCustomizationToPizzaCustomizationEntity(PizzaCustomization pizzaCustomization);
    List<PizzaCustomizationEntity> pizzaCustomizationListToPizzaCustomizationEntityList(List<PizzaCustomization> pizzaCustomization);
    PizzaCustomization pizzaCustomizationEntityToPizzaCustomization(PizzaCustomizationEntity pizzaCustomizationEntity);
    List<PizzaCustomization> pizzaCustomizationEntityListToPizzaCustomizationList(List<PizzaCustomizationEntity> pizzaCustomizationEntity);
}
