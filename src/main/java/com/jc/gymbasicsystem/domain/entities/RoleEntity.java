package com.jc.gymbasicsystem.domain.entities;

import com.jc.gymbasicsystem.domain.enums.RoleNameEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "role_entity")
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleEntity extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "role_id", updatable = false, nullable = false)
    public String roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    public RoleNameEnum name;

    @Column(name = "description", nullable = false)
    public String description;
}
