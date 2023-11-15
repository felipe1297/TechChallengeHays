package com.hays.hays_order_ms.infraestructure.persistence.mysql.mapper;

import com.hays.hays_order_ms.domain.model.Payment;
import com.hays.hays_order_ms.domain.model.Promotion;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.PaymentEntity;
import com.hays.hays_order_ms.infraestructure.persistence.mysql.entity.PromotionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PromotionEntityMapper {
    default Optional<PromotionEntity> promotionToPromotionEntity(Optional<Promotion> promotion) {
        return promotion.map(this::promotionToPromotionEntity);
    }
    PromotionEntity promotionToPromotionEntity(Promotion promotion);
    List<PromotionEntity> promotionListToPromotionEntityList(List<Promotion> promotion);
    default Optional<Promotion> promotionEntityToPromotion(Optional<PromotionEntity> promotionEntity) {
        return promotionEntity.map(this::promotionEntityToPromotion);
    }
    Promotion promotionEntityToPromotion(PromotionEntity promotionEntity);
    List<Promotion> promotionEntityListToPromotionList(List<PromotionEntity> promotionEntity);
}
