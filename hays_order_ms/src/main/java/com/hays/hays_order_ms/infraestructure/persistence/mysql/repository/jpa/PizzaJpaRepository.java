package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa;

import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaJpaRepository extends JpaRepository<PizzaEntity, Long> {
    @Query(value = " SELECT * FROM pizza WHERE name LIKE %:name% LIMIT :limit ", nativeQuery = true)
    List<PizzaEntity> findByNameTop(@Param("name") String name, @Param("limit") int limit);
}
