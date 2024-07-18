package com.jc.gymbasicsystem.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;

@Entity(name = "plan_entity")
@Data
@EqualsAndHashCode(callSuper = true)
public class PlanEntity extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "plan_id", updatable = false, nullable = false)
    public String planId;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "description", nullable = false)
    public String description;

    @Column(name = "price", nullable = false)
    public float price;

    @Column(name = "duration_days", nullable = false)
    public int durationDays;

    @OneToMany(mappedBy = "plan")
    private Set<MemberPlanEntity> memberPlans;
}
