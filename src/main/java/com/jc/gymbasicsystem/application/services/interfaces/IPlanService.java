package com.jc.gymbasicsystem.application.services.interfaces;

import com.jc.gymbasicsystem.application.dto.plan.CreatePlanDto;
import com.jc.gymbasicsystem.domain.entities.PlanEntity;

import java.util.List;

public interface IPlanService {
    List<PlanEntity> getAllPlans();

    PlanEntity getPlanById(String planId);

    PlanEntity createPlan(CreatePlanDto createPlanDto);

    PlanEntity updatePlan(PlanEntity planEntity);

    void deletePlan(String planId);
}
