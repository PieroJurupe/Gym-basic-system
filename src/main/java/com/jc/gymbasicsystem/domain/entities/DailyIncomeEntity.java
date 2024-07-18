package com.jc.gymbasicsystem.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "daily_income_entity")
@Data
@EqualsAndHashCode(callSuper = true)
public class DailyIncomeEntity extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "daily_income_id", updatable = false, nullable = false)
    public String dailyIncomeId;

    @Column(name = "amount", nullable = false)
    public float amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private MemberEntity member;
}
