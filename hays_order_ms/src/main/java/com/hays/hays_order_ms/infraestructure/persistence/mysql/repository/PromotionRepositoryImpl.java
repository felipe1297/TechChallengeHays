package com.hays.hays_order_ms.infraestructure.persistence.mysql.repository;

import com.hays.hays_order_ms.application.port.out.repository.PromotionRepository;
import com.hays.hays_order_ms.domain.model.Promotion;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper.PromotionEntityMapper;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.repository.jpa.PromotionJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PromotionRepositoryImpl implements PromotionRepository {

    private final PromotionJpaRepository promotionJpaRepository;
    private final PromotionEntityMapper promotionEntityMapper;

    @Transactional
    @Override
    public Promotion save(Promotion promotion) {
        return promotionEntityMapper.promotionEntityToPromotion(
                promotionJpaRepository.save(
                        promotionEntityMapper.promotionToPromotionEntity(promotion)
                )
        );
    }

    @Override
    public Optional<Promotion> findById(String code) {
        return promotionEntityMapper.promotionEntityToPromotion(
                promotionJpaRepository.findById(code)
        );
    }

    @Override
    public List<Promotion> findAllByEndDateBefore(Date endDate) {
        return promotionEntityMapper.promotionEntityListToPromotionList(
                promotionJpaRepository.findAllByEndDateBefore(endDate)
        );
    }
}
