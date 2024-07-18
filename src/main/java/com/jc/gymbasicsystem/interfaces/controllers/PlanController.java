package com.jc.gymbasicsystem.interfaces.controllers;

import com.jc.gymbasicsystem.application.dto.plan.CreatePlanDto;
import com.jc.gymbasicsystem.application.services.PlanService;
import com.jc.gymbasicsystem.domain.entities.PlanEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/plans")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping()
    public ResponseEntity<List<PlanEntity>> getPlans() {
        return ResponseEntity.ok(planService.getAllPlans());
    }

    @PostMapping("/create")
    public ResponseEntity<PlanEntity> createPlan(
            @RequestBody @Valid CreatePlanDto createPlanDto
            ) {
        return ResponseEntity.ok(planService.createPlan(createPlanDto));
    }
}
