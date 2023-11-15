package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository;

import com.hays.hays_order_ms.application.port.out.repository.PizzaCustomizationRepository;
import com.hays.hays_order_ms.domain.model.PizzaCustomization;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper.PizzaCustomizationEntityMapper;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa.PizzaCustomizationJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@AllArgsConstructor
public class PizzaCustomizationRepositoryImpl implements PizzaCustomizationRepository {

    private final PizzaCustomizationJpaRepository pizzaCustomizationJpaRepository;
    private final PizzaCustomizationEntityMapper pizzaCustomizationEntityMapper;

    @Transactional
    @Override
    public PizzaCustomization save(PizzaCustomization pizzaCustomization) {
        return pizzaCustomizationEntityMapper.pizzaCustomizationEntityToPizzaCustomization(
                pizzaCustomizationJpaRepository.save(
                        pizzaCustomizationEntityMapper.pizzaCustomizationToPizzaCustomizationEntity(pizzaCustomization)
                )
        );
    }

    @Override
    public PizzaCustomization findByPizzaId(Long idPizza) {
        return pizzaCustomizationEntityMapper.pizzaCustomizationEntityToPizzaCustomization(
                pizzaCustomizationJpaRepository.findTopByPizzaId(idPizza)
        );
    }
}
