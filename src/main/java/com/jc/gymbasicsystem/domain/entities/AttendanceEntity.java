package com.jc.gymbasicsystem.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity(name = "attendance_entity")
@Data
@EqualsAndHashCode(callSuper = true)
public class AttendanceEntity extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "attendance_id", updatable = false, nullable = false)
    public String attendanceId;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private MemberEntity member;

    @Column(name = "date_time_entry", nullable = false)
    public LocalDateTime dateTimeEntry;

    @Column(name = "date_time_exit", nullable = true)
    public LocalDateTime dateTimeExit;

}
