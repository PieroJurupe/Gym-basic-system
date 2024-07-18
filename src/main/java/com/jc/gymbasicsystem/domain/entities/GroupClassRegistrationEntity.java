package com.jc.gymbasicsystem.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity(name = "group_class_registration_entity")
@Data
@EqualsAndHashCode(callSuper = true)
public class GroupClassRegistrationEntity extends BaseEntity {
    @Id
    @UuidGenerator
    @Column(name = "group_class_registration_id", updatable = false, nullable = false)
    public String groupClassRegistrationId;

    @ManyToOne
    @JoinColumn(name = "group_class_id", nullable = false)
    public GroupClassEntity groupClass;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    public MemberEntity member;

    @Column(name = "date_time", nullable = false)
    public LocalDateTime dateTime;


}
