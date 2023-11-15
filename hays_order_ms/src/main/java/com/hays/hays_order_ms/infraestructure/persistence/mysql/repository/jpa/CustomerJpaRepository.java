package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa;

import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity,String> {
}
