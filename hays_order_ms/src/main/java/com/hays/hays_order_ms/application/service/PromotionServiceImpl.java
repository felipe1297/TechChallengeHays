package com.hays.hays_order_ms.application.service;

import com.hays.hays_order_ms.application.port.in.PromotionService;
import com.hays.hays_order_ms.application.port.out.repository.PromotionRepository;
import com.hays.hays_order_ms.domain.excepcion.BusinessException;
import com.hays.hays_order_ms.domain.model.Promotion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;


    @Transactional
    @Override
    public Promotion createPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public Optional<Promotion> findById(String code) {
        return promotionRepository.findById(code);
    }

    @Override
    public List<Promotion> findActivePromotions(Date endDate) {
        return promotionRepository.findAllByEndDateBefore(Objects.isNull(endDate) ? new Date() : endDate);
    }

    @Override
    public Promotion changeStatusPromotion(String code) {
        final var promotion = promotionRepository.findById(code).orElseThrow(() -> new BusinessException("Promotion does not exist"));
        promotion.setAvailable(!promotion.getAvailable());
        return promotionRepository.save(promotion);
    }
}
