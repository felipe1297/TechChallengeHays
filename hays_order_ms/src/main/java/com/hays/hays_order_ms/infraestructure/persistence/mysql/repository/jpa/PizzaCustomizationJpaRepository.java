package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa;

import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.PizzaCustomizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaCustomizationJpaRepository extends JpaRepository<PizzaCustomizationEntity,Long> {
    PizzaCustomizationEntity findTopByPizzaId(Long idPizza);
}
