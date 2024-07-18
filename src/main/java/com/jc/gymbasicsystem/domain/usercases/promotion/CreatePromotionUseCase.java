package com.jc.gymbasicsystem.domain.usercases.promotion;

import com.jc.gymbasicsystem.application.dto.promotion.CreatePromotionDto;
import com.jc.gymbasicsystem.domain.entities.PromotionEntity;
import com.jc.gymbasicsystem.domain.repository.PromotionRepository;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePromotionUseCase {

    @Autowired
    private PromotionRepository promotionRepository;

    public CreatePromotionUseCase(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public PromotionEntity execute(CreatePromotionDto createPromotionDto) {

        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        LocalDateTime startDate = formatter.parseLocalDateTime(createPromotionDto.getStartDate());
        LocalDateTime endDate = formatter.parseLocalDateTime(createPromotionDto.getEndDate());
        PromotionEntity promotion = new PromotionEntity();
        promotion.setName(createPromotionDto.name);
        promotion.setDescription(createPromotionDto.description);
        promotion.setDiscount(createPromotionDto.discount);
        promotion.setStartDate(startDate.toString());
        promotion.setEndDate(endDate.toString());
        promotion.setActive(true);

        return promotionRepository.save(promotion);
    }
}
