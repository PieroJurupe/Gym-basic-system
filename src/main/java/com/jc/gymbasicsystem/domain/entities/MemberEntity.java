package com.jc.gymbasicsystem.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "member_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MemberEntity extends BaseEntity {
    @Id
    @UuidGenerator
    @GeneratedValue(generator = "uuid")
    @Column(name = "member_id", updatable = false, nullable = false)
    public String memberId;

    @Column(name = "first_name", nullable = false, length = 50)
    public String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    public String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    public String email;

    @Column(name = "phone_number", nullable = false, unique = true, length = 50)
    public String phoneNumber;

    @Column(name = "dni", nullable = false, unique = true, length = 8)
    public String dni;

    @Column(name = "date_of_birth", nullable = false)
    public String dateOfBirth;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<DailyIncomeEntity> dailyIncomeEntities = new HashSet<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<MemberPlanEntity> memberPlanEntities = new HashSet<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<AttendanceEntity> attendanceEntities = new HashSet<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<GroupClassRegistrationEntity> groupClassRegistrationEntities = new HashSet<>();
}
