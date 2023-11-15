package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa;

import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PromotionJpaRepository extends JpaRepository<PromotionEntity,String> {
    List<PromotionEntity> findAllByEndDateBefore(Date endDate);
}
