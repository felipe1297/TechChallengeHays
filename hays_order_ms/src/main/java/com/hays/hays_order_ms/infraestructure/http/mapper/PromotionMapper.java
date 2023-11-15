package com.hays.hays_order_ms.infraestructure.http.mapper;

import com.hays.hays_order_ms.domain.model.Promotion;
import com.hays.hays_order_ms.infraestructure.http.dto.PromotionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
    Promotion promotionDtoToPromotion(PromotionDto promotionDto);
    List<Promotion> promotionDtoToPromotion(List<PromotionDto> promotionDto);
    PromotionDto promotionToPromotionDto(Promotion promotion);
    List<PromotionDto> promotionToPromotionDto(List<Promotion> promotion);
}
