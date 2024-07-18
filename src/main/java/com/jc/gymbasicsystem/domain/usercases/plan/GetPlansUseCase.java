package com.jc.gymbasicsystem.domain.usercases.plan;

import com.jc.gymbasicsystem.domain.entities.PlanEntity;
import com.jc.gymbasicsystem.domain.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPlansUseCase {

    @Autowired
    private PlanRepository planRepository;

    public GetPlansUseCase(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<PlanEntity> execute() {
        return planRepository.findAll();
    }
}
