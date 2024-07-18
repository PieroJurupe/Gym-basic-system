package com.jc.gymbasicsystem.application.services.interfaces;

import com.jc.gymbasicsystem.domain.entities.MemberPlanEntity;

import java.util.List;

public interface IMemberPlanService {
    List<MemberPlanEntity> getAllMemberPlans();

    MemberPlanEntity getMemberPlanById(String memberPlanId);

    MemberPlanEntity createMemberPlan(MemberPlanEntity memberPlanEntity);

    MemberPlanEntity updateMemberPlan(MemberPlanEntity memberPlanEntity);

    void deleteMemberPlan(String memberPlanId);
}
