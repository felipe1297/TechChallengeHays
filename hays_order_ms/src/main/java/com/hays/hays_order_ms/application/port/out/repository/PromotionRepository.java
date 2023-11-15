package com.hays.hays_order_ms.application.port.out.repository;

import com.hays.hays_order_ms.domain.model.Promotion;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PromotionRepository {
    Promotion save(Promotion promotion);
    Optional<Promotion> findById(String code);
    List<Promotion> findAllByEndDateBefore(Date endDate);
}
