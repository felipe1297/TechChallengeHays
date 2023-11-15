package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository;

import com.hays.hays_order_ms.application.port.out.repository.ToppingRepository;
import com.hays.hays_order_ms.domain.excepcion.BusinessException;
import com.hays.hays_order_ms.domain.model.Topping;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper.ToppingEntityMapper;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa.ToppingJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@AllArgsConstructor
public class ToppingRepositoryImpl implements ToppingRepository {

    private final ToppingJpaRepository toppingJpaRepository;
    private final ToppingEntityMapper toppingEntityMapper;

    @Transactional
    @Override
    public Topping save(Topping topping) {
        return toppingEntityMapper.ingredientEntityToIngredient(
                toppingJpaRepository.save(
                        toppingEntityMapper.ingredientToIngredientEntity(topping)
                )
        );
    }

    @Override
    public Topping findById(Long id) {
        return toppingEntityMapper.ingredientEntityToIngredient(
                toppingJpaRepository.findById(id).orElseThrow(() -> new BusinessException("Ingredient does not exist"))
        );
    }

    @Override
    public List<Topping> findByNameTop(String name, Integer number) {
        return toppingEntityMapper.ingredientEntityListToIngredientList(
                toppingJpaRepository.findByNameTop(name, number)
        );
    }

    @Override
    public List<Topping> findAll() {
        return toppingEntityMapper.ingredientEntityListToIngredientList(
                toppingJpaRepository.findAll()
        );
    }
}
