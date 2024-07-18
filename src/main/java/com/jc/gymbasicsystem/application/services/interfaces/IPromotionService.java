package com.jc.gymbasicsystem.application.services.interfaces;

import com.jc.gymbasicsystem.application.dto.promotion.CreatePromotionDto;
import com.jc.gymbasicsystem.domain.entities.PromotionEntity;

import java.util.List;

public interface IPromotionService {
    List<PromotionEntity> getAllPromotions();

    PromotionEntity getPromotionById(String promotionId);

    PromotionEntity createPromotion(CreatePromotionDto createPromotionDto);

    PromotionEntity updatePromotion(PromotionEntity promotionEntity);

    void deletePromotion(String promotionId);
}
