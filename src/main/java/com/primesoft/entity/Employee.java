package com.primesoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@Setter
@Getter
public class Employee {
    @Id
    @Column(name = "emp_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "emp_name", nullable = false)
    private String empName;

    @Lob
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Lob
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Lob
    @Column(name = "updated_by")
    private String updatedBy;

}