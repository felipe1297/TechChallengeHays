package com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper;

import com.hays.hays_order_ms.domain.model.Topping;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.ToppingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToppingEntityMapper {
    Topping ingredientEntityToIngredient(ToppingEntity toppingEntity);
    List<Topping> ingredientEntityListToIngredientList(List<ToppingEntity> toppingEntity);
    ToppingEntity ingredientToIngredientEntity(Topping topping);
    List<ToppingEntity> ingredientListToIngredientEntityList(List<Topping> topping);
}
