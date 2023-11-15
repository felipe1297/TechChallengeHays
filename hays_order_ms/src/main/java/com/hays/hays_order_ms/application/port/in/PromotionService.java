package com.hays.hays_order_ms.application.port.in;

import com.hays.hays_order_ms.domain.model.Promotion;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PromotionService {
    Promotion createPromotion(Promotion promotion);
    Optional<Promotion> findById(String code);
    List<Promotion> findActivePromotions(Date endDate);
    Promotion changeStatusPromotion(String code);
}
