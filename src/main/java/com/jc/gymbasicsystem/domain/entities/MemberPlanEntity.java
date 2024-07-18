package com.jc.gymbasicsystem.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
// TODO: change name to SubscriptionEntity
@Entity(name = "member_plan_entity")
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberPlanEntity extends BaseEntity {
    @Id
    @UuidGenerator
    @Column(name = "member_plan_id", updatable = false, nullable = false)
    public String memberPlanId;

    @Column(name = "start_date", nullable = false)
    public LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    public LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private PlanEntity plan;

    @ManyToOne
    @JoinColumn(name = "promotion_id", nullable = true)
    private PromotionEntity promotion;

}
