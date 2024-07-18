package com.jc.gymbasicsystem.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

@Entity(name = "employee_entity")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmployeeEntity extends BaseEntity {
    @Id
    @UuidGenerator
    @Column(name = "employee_id", updatable = false, nullable = false)
    public String employeeId;

    @Column(name = "first_name", nullable = false)
    public String firstName;

    @Column(name = "last_name", nullable = false)
    public String lastName;

    @Column(name = "email", nullable = false)
    public String email;

    @Column(name = "phone_number", nullable = false)
    public String phoneNumber;

    @Column(name = "address", nullable = false)
    public String address;

    @Column(name = "position", nullable = true)
    public String position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;
}
