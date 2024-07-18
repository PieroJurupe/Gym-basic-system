package com.jc.gymbasicsystem.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "group_class_entity")
@Data
@EqualsAndHashCode(callSuper = true)
public class GroupClassEntity extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "group_class_id", updatable = false, nullable = false)
    public String groupClassId;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "description", nullable = false)
    public String description;

    @Column(name = "price", nullable = false)
    public float price;

    @Column(name = "duration_minutes", nullable = false)
    public int durationMinutes;

    @Column(name = "capacity", nullable = false)
    public int capacity;

    @Column(name = "date_time", nullable = false)
    public LocalDateTime dateTime;

    @OneToMany(mappedBy = "groupClass")
    private Set<GroupClassRegistrationEntity> groupClassRegistrations;
}
