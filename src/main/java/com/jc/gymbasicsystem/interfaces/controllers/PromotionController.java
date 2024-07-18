package com.jc.gymbasicsystem.interfaces.controllers;

import com.jc.gymbasicsystem.application.dto.promotion.CreatePromotionDto;
import com.jc.gymbasicsystem.application.services.PromotionService;
import com.jc.gymbasicsystem.domain.entities.PromotionEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping()
    public ResponseEntity<List<PromotionEntity>> getPromotions() {
        return ResponseEntity.ok(promotionService.getAllPromotions());
    }

    @PostMapping("/create")
    public ResponseEntity<PromotionEntity> createPromotion(
            @RequestBody @Valid CreatePromotionDto createPromotionDto
            ) {
        return ResponseEntity.ok(promotionService.createPromotion(createPromotionDto));
    }
}
