package com.hays.hays_order_ms.infraestructure.http.mapper;

import com.hays.hays_order_ms.domain.model.PizzaCustomization;
import com.hays.hays_order_ms.infraestructure.http.dto.PizzaCustomizationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PizzaCustomizationDtoMapper {
    PizzaCustomizationDto pizzaCustomizationToPizzaCustomizationDto(PizzaCustomization pizzaCustomization);
    List<PizzaCustomizationDto> pizzaCustomizationListToPizzaCustomizationDtoList(List<PizzaCustomization> pizzaCustomization);
    PizzaCustomization pizzaCustomizationDtoToPizzaCustomization(PizzaCustomizationDto pizzaCustomizationDto);
    List<PizzaCustomization> pizzaCustomizationDtoListToPizzaCustomizationList(List<PizzaCustomizationDto> pizzaCustomizationDto);
}
