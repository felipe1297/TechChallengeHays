package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository;

import com.hays.hays_order_ms.application.port.out.repository.PizzaRepository;
import com.hays.hays_order_ms.domain.excepcion.BusinessException;
import com.hays.hays_order_ms.domain.model.Pizza;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper.PizzaEntityMapper;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa.PizzaJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@AllArgsConstructor
public class PizzaRepositoryImpl implements PizzaRepository {

    private final PizzaJpaRepository pizzaJpaRepository;
    private final PizzaEntityMapper pizzaEntityMapper;

    @Transactional
    @Override
    public Pizza save(Pizza pizza) {
        return pizzaEntityMapper.pizzaEntityToPizza(
                pizzaJpaRepository.save(
                        pizzaEntityMapper.pizzaToPizzaEntity(pizza)
                )
        );
    }

    @Override
    public List<Pizza> findByNameTop(String name, Integer number) {
        return pizzaEntityMapper.pizzaEntityListToPizzaList(
                pizzaJpaRepository.findByNameTop(name, number)
        );
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaEntityMapper.pizzaEntityListToPizzaList(
                pizzaJpaRepository.findAll()
        );
    }

    @Override
    public Pizza findById(Long id) {
        return pizzaEntityMapper.pizzaEntityToPizza(
                pizzaJpaRepository.findById(id).orElseThrow(() -> new BusinessException("Pizza does not exist"))
        );
    }
}
