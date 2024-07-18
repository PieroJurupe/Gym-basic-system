package com.jc.gymbasicsystem.application.services;

import com.jc.gymbasicsystem.application.dto.promotion.CreatePromotionDto;
import com.jc.gymbasicsystem.application.services.interfaces.IPromotionService;
import com.jc.gymbasicsystem.domain.entities.PromotionEntity;
import com.jc.gymbasicsystem.domain.usercases.promotion.CreatePromotionUseCase;
import com.jc.gymbasicsystem.domain.usercases.promotion.GetPromotionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService implements IPromotionService {

    @Autowired
    CreatePromotionUseCase createPromotionUseCase;

    @Autowired
    GetPromotionUseCase getPromotionsUseCase;

    @Override
    public List<PromotionEntity> getAllPromotions() {
        return getPromotionsUseCase.execute();
    }

    @Override
    public PromotionEntity getPromotionById(String promotionId) {
        return null;
    }

    @Override
    public PromotionEntity createPromotion(CreatePromotionDto createPromotionDto) {
        return createPromotionUseCase.execute(createPromotionDto);
    }

    @Override
    public PromotionEntity updatePromotion(PromotionEntity promotionEntity) {
        return null;
    }

    @Override
    public void deletePromotion(String promotionId) {

    }
}
