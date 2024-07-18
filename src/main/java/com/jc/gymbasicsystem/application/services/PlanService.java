package com.jc.gymbasicsystem.application.services;

import com.jc.gymbasicsystem.application.dto.plan.CreatePlanDto;
import com.jc.gymbasicsystem.application.services.interfaces.IPlanService;
import com.jc.gymbasicsystem.domain.entities.PlanEntity;
import com.jc.gymbasicsystem.domain.usercases.plan.CreatePlanUseCase;
import com.jc.gymbasicsystem.domain.usercases.plan.GetPlansUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService implements IPlanService {

    @Autowired
    private GetPlansUseCase getPlansUseCase;

    @Autowired
    private CreatePlanUseCase createPlanUseCase;

    @Override
    public List<PlanEntity> getAllPlans() {
        return getPlansUseCase.execute();
    }

    @Override
    public PlanEntity getPlanById(String planId) {
        return null;
    }

    @Override
    public PlanEntity createPlan(CreatePlanDto createPlanDto) {
        return createPlanUseCase.execute(createPlanDto);
    }

    @Override
    public PlanEntity updatePlan(PlanEntity planEntity) {
        return null;
    }

    @Override
    public void deletePlan(String planId) {

    }
}
