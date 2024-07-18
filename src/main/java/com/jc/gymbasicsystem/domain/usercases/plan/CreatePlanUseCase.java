package com.jc.gymbasicsystem.domain.usercases.plan;

import com.jc.gymbasicsystem.application.dto.plan.CreatePlanDto;
import com.jc.gymbasicsystem.domain.entities.PlanEntity;
import com.jc.gymbasicsystem.domain.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePlanUseCase {

    @Autowired
    private PlanRepository planRepository;

    public CreatePlanUseCase(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public PlanEntity execute(CreatePlanDto createPlanDto) {
        PlanEntity planEntity = new PlanEntity();
        planEntity.setName(createPlanDto.name);
        planEntity.setDescription(createPlanDto.description);
        planEntity.setPrice(createPlanDto.price);
        planEntity.setDurationDays(createPlanDto.durationDays);
        planEntity.setActive(true);

        return planRepository.save(planEntity);
    }
}
