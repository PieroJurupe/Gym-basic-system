package com.jc.gymbasicsystem.domain.usercases.promotion;

import com.jc.gymbasicsystem.domain.entities.PromotionEntity;
import com.jc.gymbasicsystem.domain.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPromotionUseCase {

    @Autowired
    private PromotionRepository promotionRepository;

    public GetPromotionUseCase(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public List<PromotionEntity> execute() {
        return promotionRepository.findAll();
    }
}
