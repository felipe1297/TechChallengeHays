package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa;

import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findAllByCustomerId(String customerId);
}
