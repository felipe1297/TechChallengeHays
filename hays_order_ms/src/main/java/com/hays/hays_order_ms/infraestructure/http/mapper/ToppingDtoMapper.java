package com.hays.hays_order_ms.infraestructure.http.mapper;

import com.hays.hays_order_ms.domain.model.Topping;
import com.hays.hays_order_ms.infraestructure.http.dto.ToppingDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToppingDtoMapper {
    Topping ingredientDtoToIngredient(ToppingDto toppingDto);
    List<Topping> ingredientDtoListToIngredientList(List<ToppingDto> toppingDto);
    ToppingDto ingredientToIngredientDto(Topping topping);
    List<ToppingDto> ingredientListToIngredientDtoList(List<Topping> topping);
}
